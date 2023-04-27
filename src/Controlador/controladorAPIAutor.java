package Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Modelo.autor;
import Modelo.conexionAPI;

public class controladorAPIAutor {

  private String ids, hots;
  JSONParser parser = new JSONParser();
  JSONObject jsonResult, author, art = null;
  long artDisponible, artNoDisponible, totalArticulos = 0;
  Reader lectura;
  BufferedReader contenido;
  StringBuilder stringBuilder;

  public controladorAPIAutor(String ids) {
    this.ids = ids;
  }

  // id = "EicYvbwAAAAJ"

  autor personaje = new autor();

  public void conexionUrl() {
    try {
      conexionAPI conexion = new conexionAPI();
      hots = conexion.getHttps() + "&author_id=" + ids + "&num=" + conexion.getNumResultado()
          + "&apikey=" +
          conexion.getApiKey();
    } catch (Exception e) {
      System.out.println("Error de I/O -----" + e.getMessage());

    }
  }

  public void lecturaJson() {
    try {
      URL miUrl = new URL(hots);
      URLConnection conexionUrl = miUrl.openConnection();
      lectura = new InputStreamReader(
          conexionUrl.getInputStream(),
          "UTF-8");
      contenido = new BufferedReader(lectura);
      stringBuilder = new StringBuilder();

    } catch (Exception e) {
      System.out.println("Error de I/O -----" + e.getMessage());

    }
  }

  public void recorrido() {
    // Encerramos todo el código de petición en un Try/Catch
    try {
      for (int item; (item = contenido.read()) >= 0;)
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
      System.out.println("Error de I/O -----" + e.getMessage());
    }
  }

  public void resultado() {
    personaje.setId(ids);
    personaje.setNombre(author.getOrDefault("name", 0).toString());
    personaje.setAfiliaciones(author.getOrDefault("affiliations", 0).toString());
    personaje.setWeb(author.getOrDefault("website", 0).toString());
    personaje.setArtDisponibles((long) art.getOrDefault("available", 0));
    personaje.setArtNoDisponibes((long) art.getOrDefault("not_available", 0));
    personaje.setTotalArti((long) totalArticulos);
    personaje.datos();
  }
}