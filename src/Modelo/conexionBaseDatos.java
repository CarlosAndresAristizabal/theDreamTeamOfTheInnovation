package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBaseDatos {

  private final String nombreBD = "registroinvestigadores";
  private final String user = "root";
  private final String password = "";
  private final String url = "jdbc:mysql://localhost:3306/" + nombreBD;
  private Connection conexion = null;

  public Connection getConexion() throws ClassNotFoundException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conexion = (Connection) DriverManager.getConnection(
          this.url,
          this.user,
          this.password);
    } catch (SQLException e) {
      System.err.println(e);
    }
    return conexion;
  }
}
