
package Modelo;

public class conexionAPI {
  // api_key:c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618
  // id = "EicYvbwAAAAJ"
  private final String https = "https://serpapi.com/search.json?engine=google_scholar_author";
  private final String apiKey = "c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618";
  private final int numResultado = 10;

  public String getHttps() {
    return this.https;
  }

  public String getApiKey() {
    return this.apiKey;
  }

  public int getNumResultado() {
    return this.numResultado;
  }

  public conexionAPI() {
  }

}
