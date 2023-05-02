package Vista;

import Modelo.autor;
import java.util.Scanner;
import Controlador.controladorAPIAutor;

public class vista {
    // constructur vacio
    public vista() {

    }

    // creamos cabecera
    public void head() {
        System.out.println("//**************************************************//");
        System.out.println("//*                                                *//");
        System.out.println("//*              GOOGLE SCHOLAR API                 *//");
        System.out.println("//*                                                *//");
        System.out.println("//**************************************************//");
    }

    // Creamos el contenido donde se llama el contructor del controlador y modelo
    public void contenido() {
        boolean item = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Ingresa tu ApiKey si no tienes puedes usar esta => e32e34e6f73b14ca43d0bfb4e93168b90c699b91b3d9024ad1ea497031104d85");
        String apikey = scanner.nextLine();
        do {
            System.out.println("Selecciona una opcion:");
            System.out.println("1. Buscar perfil por ID: ");
            System.out.println("2. Ver registro de la BD ");
            System.out.println("3. Ver Top 10");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el ID");
                    Scanner scanner2 = new Scanner(System.in);
                    String id = scanner2.nextLine();
                    autor conid = new autor(id);
                    conid.setId(id);
                    controladorAPIAutor ctlApi = new controladorAPIAutor(id, apikey);
                    conid.setApikey(apikey);
                    ctlApi.conexionUrl();
                    ctlApi.lecturaJson();
                    ctlApi.recorrido();
                    ctlApi.resultado();
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Selecciona una opcion:");
                    System.out.println("1. Guardar datos en la BD");
                    System.out.println("2. Salir");
                    int opcion3 = scanner3.nextInt();
                    switch (opcion3) {
                        case 1:
                            ctlApi.guadar();
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Ingresaste una opcion invalida");
                            break;
                    }
                    break;
                case 2:
                    autor conid2 = new autor();
                    controladorAPIAutor ctlApi2 = new controladorAPIAutor(conid2.getId(), conid2.getApikey());
                    ctlApi2.consulta();
                    break;
                case 3:
                    autor conid3 = new autor();
                    controladorAPIAutor ctlApi3 = new controladorAPIAutor(conid3.getId(), conid3.getApikey());
                    ctlApi3.consultaTop();
                    break;
                default:
                    System.out.println("Ingresaste una opcion invalida");
                    break;
                case 4:
                    item = false;
                    break;
            }
        } while (item);
    }

    public void footer() {
        System.out.println("//**************************************************//");
        System.out.println("//*                                                *//");
        System.out.println("//*                Realizado por:                  *//");
        System.out.println("//*         Carlos Andres Aristizabal K.           *//");
        System.out.println("//*           Full Stack Developer Core            *//");
        System.out.println("//*                  CopyRight ©                   *//");
        System.out.println("//*          Todos los derechos reservados         *//");
        System.out.println("//*                       2023                     *//");
        System.out.println("//*                                                *//");
        System.out.println("//**************************************************//");
    }
}
