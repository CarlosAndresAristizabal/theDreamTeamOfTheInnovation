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
        System.out.println("//*              GOOGLE SCHOLAR API                *//");
        System.out.println("//*                                                *//");
        System.out.println("//**************************************************//");
    }

    // Creamos el contenido donde se llama el contructor del controlador y modelo
    public void contenido() {
        // Creamos variable booleana para que realizar el bucle del menú
        boolean item = false;
        // instaciamos el contructor de scanner para poder recibir datos desde la
        // terminal
        Scanner scanner = new Scanner(System.in);
        // imprimimos primer mensaje
        System.out.println(
                "Ingresa tu ApiKey si no tienes puedes usar esta => e32e34e6f73b14ca43d0bfb4e93168b90c699b91b3d9024ad1ea497031104d85");
        // guardamos lo ingrsado por teclado en una variable string que es la apikey
        String apikey = scanner.nextLine();
        // entramos en ciclo do while para repetir las opciones del menu
        do {
            // imprimimos mensaje
            System.out.println("Selecciona una opcion:");
            System.out.println("1. Buscar perfil por ID: ");
            System.out.println("2. Ver registro de la BD ");
            System.out.println("3. Ver Top 10");
            System.out.println("4. Salir");
            // Creamos variable donde se almacenara la opcion de entrada
            int opcion = scanner.nextInt();
            // creamos un swicth par crear un menu.
            switch (opcion) {
                case 1:
                    // imprimimos mensaje
                    System.out.println("Ingresa el ID");
                    // escaneamos el texto ingresasdo
                    Scanner scanner2 = new Scanner(System.in);
                    // la guardamos en la variable
                    String id = scanner2.nextLine();
                    // Instanciamos el contrutor de autor para poder almacenar el id ingresado
                    autor conid = new autor(id);
                    // guardamos el id
                    conid.setId(id);
                    // Instaciamos el constructor de la API y almacenamos el id y apikey
                    controladorAPIAutor ctlApi = new controladorAPIAutor(id, apikey);
                    // se lamacena el apikey
                    conid.setApikey(apikey);
                    // conectamos a la API
                    ctlApi.conexionUrl();
                    // leemos el JSON
                    ctlApi.lecturaJson();
                    // recooremos el JSON
                    ctlApi.recorrido();
                    // Obtenemos el resultado
                    ctlApi.resultado();
                    // Mostramos otro menu de opciones
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Selecciona una opcion:");
                    System.out.println("1. Guardar datos en la BD");
                    System.out.println("2. Salir");
                    // guardamos lo introducido en una variable
                    int opcion3 = scanner3.nextInt();
                    // hacer otro menu de opcion con swicth
                    switch (opcion3) {
                        case 1:
                            // guardamos los resultados a la base de datos
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
                    // instaciamos el constructor de autor
                    autor conid2 = new autor();
                    // INstaciamos el construtor del controlador API
                    controladorAPIAutor ctlApi2 = new controladorAPIAutor(conid2.getId(), conid2.getApikey());
                    // Hacemos una consulta de los datos guardados enla base de datos
                    ctlApi2.consulta();
                    break;
                case 3:
                    // instaciamos el constructor de autor
                    autor conid3 = new autor();
                    // INstaciamos el construtor del controlador API
                    controladorAPIAutor ctlApi3 = new controladorAPIAutor(conid3.getId(), conid3.getApikey());
                    // Hacemos la consulta del top 10 de los investigadores con m,as articulos
                    // publicados
                    ctlApi3.consultaTop();
                    break;
                default:
                    System.out.println("Ingresaste una opcion invalida");
                    break;
                case 4:
                    // le colocamos a la variable item un false para poder salir del ciclo
                    item = false;
                    break;
            }
        } while (item);
    }

    // Imprimimos un footer
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
