
package Modelo;

//  creamos un modelo para la conexion de la API
public class conexionAPI {

  private final String https = "https://serpapi.com/search.json?engine=google_scholar_author";
  private final int numResultado = 10;

  public String getHttps() {
    return this.https;
  }

  public int getNumResultado() {
    return this.numResultado;
  }

  public conexionAPI() {
  }

}
