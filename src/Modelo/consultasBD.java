package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultasBD extends conexionBaseDatos {

  public boolean registar(autor autor) throws ClassNotFoundException {
    PreparedStatement ps = null;
    Connection conexion = getConexion();

    String sql =
      "INSERT INTRO autor (Id,Nombre,Afiliacion,web,ArticulosDisponibles,ArticulosNoDisponibles,TotalArticulos) VALUES (?,?,?,?)";
    try {
      ps = conexion.prepareStatement(sql);
      ps.setString(1, autor.getId());
      ps.setString(2, autor.getNombre());
      ps.setString(3, autor.getAfiliaciones());
      ps.setString(4, autor.getWeb());
      ps.setLong(5, autor.getArtDisponibles());
      ps.setLong(6, autor.getArtNoDisponibes());
      ps.setLong(7, autor.getTotalArti());
      ps.execute();
      return true;
    } catch (SQLException e) {
      System.err.println(e);
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  public boolean buscar(autor autor) throws ClassNotFoundException {
    PreparedStatement ps = null;
    ResultSet resultado;
    Connection conexion = getConexion();

    String sql = "SELECT * FROM author WHERE Id=?";
    try {
      ps = conexion.prepareStatement(sql);
      ps.setString(1, autor.getId());
      resultado = ps.executeQuery();
      while (resultado.next()) {
        autor.setId(resultado.getString("Id"));
        autor.setNombre(resultado.getString("Nombre"));
        autor.setAfiliaciones(resultado.getString("Afiliacion"));
        autor.setWeb(resultado.getString("Web"));
        autor.setArtDisponibles(resultado.getLong("ArticulosDisponibles"));
        autor.setArtNoDisponibes(resultado.getLong("ArticulosNoDisponibles"));
        autor.setTotalArti(resultado.getLong("TotalArticulos"));
        return true;
      }
      return false;
    } catch (SQLException e) {
      System.err.println(e);
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  public boolean ranking(autor autor) throws ClassNotFoundException {
    PreparedStatement ps = null;
    ResultSet resultado;
    Connection conexion = getConexion();

    String sql = "ALTER TABLE autor ORDER BY TotalArticulos DESC";
    try {
      ps = conexion.prepareStatement(sql);
      ps.setString(1, autor.getId());
      resultado = ps.executeQuery();
      while (resultado.next()) {
        autor.setId(resultado.getString("Id"));
        autor.setNombre(resultado.getString("Nombre"));
        autor.setTotalArti(resultado.getLong("TotalArticulos"));
        return true;
      }
      return false;
    } catch (SQLException e) {
      System.err.println(e);
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }
}
