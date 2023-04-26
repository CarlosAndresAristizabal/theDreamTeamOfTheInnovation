package Modelo;

import java.io.Serializable;

public class modelo implements Serializable {

  private String authorid;
  private String nombre;
  private String afiliaciones;
  private String web;
  private String profecion;

  public modelo(
    String authorid,
    String nombre,
    String afiliaciones,
    String web,
    String profecion
  ) {
    this.authorid = authorid;
    this.nombre = nombre;
    this.afiliaciones = afiliaciones;
    this.web = web;
    this.profecion = profecion;
  }

  /**
   * @return String return the authorid
   */
  public String getauthorid() {
    return authorid;
  }

  /**
   * @param authorid the authorid to set
   */
  public void setauthoraid(String authorid) {
    this.authorid = authorid;
  }

  /**
   * @return String return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return String return the afiliaciones
   */
  public String getAfiliaciones() {
    return afiliaciones;
  }

  /**
   * @param afiliaciones the afiliaciones to set
   */
  public void setAfiliaciones(String afiliaciones) {
    this.afiliaciones = afiliaciones;
  }

  /**
   * @return String return the web
   */
  public String getWeb() {
    return web;
  }

  /**
   * @param web the web to set
   */
  public void setWeb(String web) {
    this.web = web;
  }

  /**
   * @return String return the profecion
   */
  public String getprofecion() {
    return profecion;
  }

  /**
   * @param profecion the profecion to set
   */
  public void setprofecion(String profecion) {
    this.profecion = profecion;
  }

  public void datos() {
    System.out.println(String.format(nombre, afiliaciones, web, profecion));
  }
}
