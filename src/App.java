import Modelo.autor;
import Modelo.conexionAPI;
import Modelo.consultasBD;
import Vista.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Controlador.controladorAPIAutor;

public class App {

  public static void main(String[] args) {
    // api_key:c7b692215b27d50b9842228c9ba707cecadcf67dc6b16ff41c24af002ed37618
    // id = "EicYvbwAAAAJ"

    vista inicia = new vista();
    inicia.portada();
    inicia.contenido();
    inicia.footer();

  }
}
