import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {

  /**
   * @param args
   */

  public static void main(String[] args) throws IOException {
    //   api_key:c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618
    //Encerramos todo el código de petición en un Try/Catch
    try {
      //Creamos variables para poder modificar el querry
      String http =
        "https://serpapi.com/search.json?engine=google_scholar_author";
      String authorid = "EicYvbwAAAAJ";
      String apiKey =
        "c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618";
      int num = 4;
      final String url =
        http + "&author_id=" + authorid + "&num=" + num + "&apikey=" + apiKey;
      //Inicio de la Conexion
      URL miUrl = new URL(url);
      URLConnection conexion = miUrl.openConnection();
      //Lectura del conetnido de la respuesta
      Reader lectura = new InputStreamReader(
        conexion.getInputStream(),
        "UTF-8"
      );
      BufferedReader contenido = new BufferedReader(lectura);
      StringBuilder stringBuilder = new StringBuilder();
      for (int item; (item = contenido.read()) >= 0;) stringBuilder.append(
        (char) item
      );
      String respuesta = stringBuilder.toString();
      //se crea el objeto que parseará la respuesta
      JSONParser parser = new JSONParser();
      //se parsea la respuesta en un JSONObject
      JSONObject jsonResult = (JSONObject) parser.parse(respuesta);
      //Retorna la respuesta y la emcasuplamos en un jsonObject para poder recorrelo
      JSONObject author = (JSONObject) jsonResult.get("author");
      // Se recorre segun json para extraer la aprofeción
      JSONArray perfil = (JSONArray) author.getOrDefault("interests", 0);
      // Se recorre el Jsonarray
      JSONObject profecion = (JSONObject) perfil.get(0);
      // se imprime en pantalla los datos personales
      System.out.println("Id: " + authorid);
      System.out.println("Nombre: " + author.getOrDefault("name", 0));
      System.out.println("Profeción: " + profecion.getOrDefault("title", 0));
      System.out.println(
        "Univeridad: " + author.getOrDefault("affiliations", 0)
      );
      System.out.println("Sitio Web: " + author.getOrDefault("website", 0));
    } catch (Exception e) {
      System.out.println("Error de I/O -----" + e.getMessage());
    }
  }
}
