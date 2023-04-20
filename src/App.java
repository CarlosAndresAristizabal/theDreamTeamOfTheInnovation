import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class App {

  /**
   * @param args
   */

  // private static HttpURLConnection conexion;

  public static void main(String[] args) throws IOException {
    //   api_key:c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618

    //Encerramos todo el código de petición en un Try/Catch
    try {
      //Creamos variables para poder modificar el querry
      String http =
        "https://serpapi.com/search.json?engine=google_scholar_author";
      String authorid = "LSsXyncAAAAJ";
      String apiKey =
        "c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618";
      int num = 4;
      final String url =
        http + "&author_id=" + authorid + "&num=" + num + "&apikey=" + apiKey;
      //Inicio de la Conexion
      URL miUrl = new URL(url);
      URLConnection conexion = miUrl.openConnection();
      //Lectura del conetnido de la respuesta
      Reader lectura = new InputStreamReader(conexion.getInputStream());
      BufferedReader contenido = new BufferedReader(lectura);
      String linea;
      //Recorremos el contenido para mostrarlo en consola
      while ((linea = contenido.readLine()) != null) {
        System.out.println(linea);
      }
    } catch (Exception e) {
      System.out.println("Error de I/O " + e.getMessage());
    }
  }
}
