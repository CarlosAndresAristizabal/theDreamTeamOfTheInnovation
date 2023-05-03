package Controlador;

// se importan todas las librerias utilizadas
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.autor;
import Modelo.conexionAPI;

// Clase del controlador de la api
public class controladorAPIAutor {
  // Variables de conexion de la Api
  private String ids, hots, apikey;
  // instaciamos JSON parse de la libreria
  JSONParser parser = new JSONParser();
  // variables de la libreria JSONObject
  JSONObject jsonResult, author, art = null;
  // variables long donde se almacenaran resultados
  long artDisponible, artNoDisponible, totalArticulos = 0;
  // Instaciamos la libreria reader para la lectura y almacenar en cache con
  // buffer y traer la infromación en un string
  Reader lectura;
  BufferedReader contenido;
  StringBuilder stringBuilder;

  // un constructor del controlador vacio
  public controladorAPIAutor() {

  }

  // UN constructor con parametros de id y apikey
  public controladorAPIAutor(String ids, String apikey) {
    this.ids = ids;
    this.apikey = apikey;
  }

  // instaciamos el constructor de autor
  autor personaje = new autor();

  // creamos la conexcion de la API
  public void conexionUrl() {
    // lo encerramos en un try catch para el manejo de error si no hay conexion
    try {
      // instaciamos el constructor de la conexion
      conexionAPI conexion = new conexionAPI();
      // en esta variable juntamos la url completa para el acceso ala API
      hots = conexion.getHttps() + "&author_id=" + ids + "&num=" + conexion.getNumResultado()
          + "&apikey=" +
          apikey;
    } catch (Exception e) {
      // imprimos el error
      System.out.println("Error de I/O -----" + e.getMessage());

    }
  }

  // metodo para la lectura del JSON
  public void lecturaJson() {
    // lo encerramos en un try catch para el manejo de error si no hay conexion
    try {
      // INstaciamos url de la libreria URL
      URL miUrl = new URL(hots);
      // Usamos el URL COnection
      URLConnection conexionUrl = miUrl.openConnection();
      // Usamos la variable de lectura ya definidad con aterioridad y almacenamos
      // entrada envivo de la infromacion de la API
      lectura = new InputStreamReader(
          // obtenemos lo guardado
          conexionUrl.getInputStream(),
          "UTF-8");
      // almacenamos lo leido y lo guardamos en contenido
      contenido = new BufferedReader(lectura);
      // realizamos un stringbuilder para almacenar el json en uhn string
      stringBuilder = new StringBuilder();

    } catch (Exception e) {
      // imprimos el error si hay error en la coenxcion o en la lectrura

      System.out.println("Error de I/O -----" + e.getMessage());

    }
  }

  // creamos un metodo de recorrido par estraer información
  public void recorrido() {
    // Encerramos todo el código de petición en un Try/Catch
    try {
      // recorremos con for el contenido
      for (int item; (item = contenido.read()) >= 0;)
        // añadimos dicho recorrido si incontramos datos y lo almacenamos el
        // stringbuilder
        stringBuilder.append(
            (char) item);
      // se crea la instancia para parseará a un json de la respuesta que es un string
      // se parsea la respuesta en un JSONObject
      jsonResult = (JSONObject) parser.parse(
          stringBuilder.toString());
      // Retorna la respuesta y la emcasuplamos en un jsonObject para poder recorrelo
      author = (JSONObject) jsonResult.get("author");
      // Contador de arciculos creados por el autor, se recorre para extraeer los
      // accesos publicos
      art = (JSONObject) jsonResult.getOrDefault("public_access", 0);
      // se castea a long;
      artDisponible = (long) art.getOrDefault("available", 0);
      artNoDisponible = (long) art.getOrDefault("not_available", 0);
      // Se suman para sacar el total de aritculos realizados.
      totalArticulos = artDisponible + artNoDisponible;

    } catch (Exception e) {
      // imprimos el error

      System.out.println("Error de I/O -----" + e.getMessage());
    }
  }

  // metodo de resultado que mostrara
  public void resultado() {
    // despus de obtener toda la infromacion guardada se almacena en dichas
    // variables y luego ser llamada y imprimirlas
    personaje.setId(ids);
    personaje.setNombre(author.getOrDefault("name", 0).toString());
    personaje.setAfiliaciones(author.getOrDefault("affiliations", 0).toString());
    personaje.setWeb(author.getOrDefault("website", 0).toString());
    personaje.setArtDisponibles((long) art.getOrDefault("available", 0));
    personaje.setArtNoDisponibes((long) art.getOrDefault("not_available", 0));
    personaje.setTotalArti((long) totalArticulos);
    personaje.datos();
  }

  // metodo de guardar los datos obtenidos y almacenarlo en la base de datos
  public void guadar() {
    // Encerramos todo el código de petición en un Try/Catch
    try {
      // Hacemos conexion de a la base de datos
      Connection conexionBDGuardar = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/registroinvestigadores",
          "root",
          "");
      // preparamos la conexcion con la peticion a la BD
      PreparedStatement ps = conexionBDGuardar.prepareStatement(
          "INSERT INTO autor VALUES (?,?,?,?,?,?,?)");
      // obtenemos los datos y guardamos en cada item de las tabla creada en la bd
      ((PreparedStatement) ps).setString(1, personaje.getId());
      ((PreparedStatement) ps).setString(2, personaje.getNombre());
      ((PreparedStatement) ps).setString(3, personaje.getAfiliaciones());
      ((PreparedStatement) ps).setString(4, personaje.getWeb());
      ((PreparedStatement) ps).setLong(5, personaje.getArtDisponibles());
      ((PreparedStatement) ps).setLong(6, personaje.getArtNoDisponibes());
      ((PreparedStatement) ps).setLong(7, personaje.getTotalArti());
      ((PreparedStatement) ps).executeUpdate();
      // actualizamos y mostrando un mensaje de exito
      System.out.println("Datos ingresados correctamente");
    } catch (SQLException e) {
      // manejamos el erro si los hay en la coenxion y mandamos el mensaje
      System.out.println("NO CONECTA!!");
      System.err.println(e);
    }
  }

  // metodo de consulta de BD
  public void consulta() {
    // Encerramos todo el código de petición en un Try/Catch
    try {
      // Hacemos conexion de a la base de datos
      Connection conexionBDTop = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/registroinvestigadores",
          "root",
          "");
      // hacemos la preparacion de la peticion
      PreparedStatement ps = conexionBDTop.prepareStatement("SELECT * FROM autor");
      // obtenemos resultado de la BD
      ResultSet resultado = ps.executeQuery();
      // recorremos el resultado de la BD
      while (resultado.next()) {
        // IMprimimos la datos adquiridos de la BD
        System.out.println(resultado.getString(1) + "  |  " + resultado.getString(2) + "  |  "
            + resultado.getLong(7));
      }
      // y cerramos la coenxion de la BD
      resultado.close();
    } catch (Exception e) {
      // manejamos el erro si los hay en la coenxion y mandamos el mensaje
      e.printStackTrace();
    }
  }
  // metodo de TOP 10 de BD

  public void consultaTop() {
    // Encerramos todo el código de petición en un Try/Catch

    try {
      // Hacemos conexion de a la base de datos

      Connection conexionBDTop = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/registroinvestigadores",
          "root",
          "");
      // hacemos la preparacion de la peticion y lo ordenamos en forma descendete
      PreparedStatement ps = conexionBDTop.prepareStatement("SELECT * FROM autor ORDER BY TotalArticulos DESC");
      // obtenemos resultado de la BD
      ResultSet resultado = ps.executeQuery();
      // recorremos el resultado de la BD
      for (int item = 0; item < 10; item++) {
        // IMprimimos la datos adquiridos de la BD
        resultado.next();
        System.out.println(resultado.getString(1) + "  |  " + resultado.getString(2) + "  |  "
            + resultado.getLong(7));
      }
      // y cerramos la coenxion de la BD
      resultado.close();
    } catch (Exception e) {
      // manejamos el erro si los hay en la coenxion y mandamos el mensaje
      e.printStackTrace();
    }
  }
}