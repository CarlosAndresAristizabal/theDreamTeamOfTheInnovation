package Modelo;

import java.io.Serializable;

/*
 * Creamos un clase llamada autor que tendra las variables requeridas
 */
public class autor implements Serializable {
  // variable string
  private String id, nombre, afiliaciones, web, apikey;
  // variables long
  private long artDisponibles, artNoDisponibes, totalArti;

  // construtor con un paramaetro ID
  public autor(String id) {
    this.id = id;
  }

  // constructor vacio
  public autor() {

  }

  // constructor con todas la variables
  public autor(
      String id,
      String nombre,
      String afiliaciones,
      String web,
      String apikey,
      long artDisponible,
      long artNoDisponibes,
      long totalArti) {
    this.id = id;
    this.nombre = nombre;
    this.afiliaciones = afiliaciones;
    this.web = web;
    this.apikey = apikey;
    this.artDisponibles = artDisponible;
    this.artNoDisponibes = artNoDisponibes;
    this.totalArti = totalArti;
  }

  // Getters y setters
  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getAfiliaciones() {
    return afiliaciones;
  }

  public void setAfiliaciones(String afiliaciones) {
    this.afiliaciones = afiliaciones;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public String getApikey() {
    return apikey;
  }

  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  public long getArtDisponibles() {
    return artDisponibles;
  }

  public void setArtDisponibles(long artDisponibles) {
    this.artDisponibles = artDisponibles;
  }

  public long getArtNoDisponibes() {
    return artNoDisponibes;
  }

  public void setArtNoDisponibes(long artNoDisponibes) {
    this.artNoDisponibes = artNoDisponibes;
  }

  public long getTotalArti() {
    return totalArti;
  }

  public void setTotalArti(long totalArti) {
    this.totalArti = totalArti;
  }

  // metodo de impresion de datos
  public void datos() {
    System.out.println("/*----------------------------------- */");
    System.out.println("Id: " + id);
    System.out.println("Nombre: " + nombre);
    System.out.println("Univeridad: " + afiliaciones);
    System.out.println("Sitio Web: " + web);
    System.out.println("Articulos disponibles: " + artDisponibles);
    System.out.println("Articulos no disponibles: " + artNoDisponibes);
    System.out.println("Total de articulos: " + totalArti);
    System.out.println("/*----------------------------------- */");
  }

}
