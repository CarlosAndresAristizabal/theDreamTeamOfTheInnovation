
package Modelo;

//  creamos un modelo para la conexion de la API
public class conexionAPI {
  // api_key:c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618
  // apikey:"3ee68331448b03e34d061f40af2be4306dde115d6e4513a8d366be01925f01b4"
  // id = "EicYvbwAAAAJ"

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
