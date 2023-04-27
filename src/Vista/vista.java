package Vista;

import Modelo.autor;
import Modelo.conexionAPI;
import Modelo.consultasBD;
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

public class vista {

    public vista() {

    }

    public void portada() {
        System.out.println("//**************************************************//");
        System.out.println("//*                                                *//");
        System.out.println("//*              GOOGLE SCHOOL API                 *//");
        System.out.println("//*                                                *//");
        System.out.println("//**************************************************//");
    }

    public void contenido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el id del autor");
        String id = scanner.nextLine();
        autor conid = new autor(id);
        conid.setId(id);
        controladorAPIAutor ctlApi = new controladorAPIAutor(id);
        ctlApi.recorrido();
    }

    public void footer() {
        System.out.println("//**************************************************//");
        System.out.println("//*                                                *//");
        System.out.println("//*             Realizado por:                     *//");
        System.out.println("//*      Carlos Andres Aristizabal K.              *//");
        System.out.println("//*        Full Stack Developer Core               *//");
        System.out.println("//*               CopyRight ©                      *//");
        System.out.println("//*       Todos los derechos reservados            *//");
        System.out.println("//*                    2023                        *//");
        System.out.println("//*                                                *//");
        System.out.println("//**************************************************//");
    }
}
