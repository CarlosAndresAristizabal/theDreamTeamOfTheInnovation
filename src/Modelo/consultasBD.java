// package Modelo;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class consultasBD {
// private final String nombreBD = "registroinvestigadores";
// private final String user = "root";
// private final String password = "";
// private final String url = "jdbc:mysql://localhost:3306/" + nombreBD;

// public boolean registar(autor autor) {

// try {
// Connection conexion = DriverManager.getConnection(
// this.url,
// this.user,
// this.password);
// Statement ps = conexion.createStatement();
// System.out.println(autor.getId());
// String sql = "INSERT INTO autor
// (Id,Nombre,Afiliacion,Web,ArticulosDisponibles,ArticulosNoDisponibles,TotalArticulos)
// VALUES ('"
// + autor.getId() + "','" + autor.getNombre() + "','" + autor.getAfiliaciones()
// + "','" + autor.getWeb() + "','"
// + autor.getArtDisponibles() + "','" + autor.getArtNoDisponibes() + "','" +
// autor.getTotalArti() + "')";
// ps.executeUpdate(sql);
// System.out.println(sql);
// System.out.println("Datos ingresados correctamente");
// return true;
// } catch (SQLException e) {
// System.out.println("NO CONECTA!!");
// System.err.println(e);
// return false;
// }
// }

// public boolean ranking(autor autor) {

// ResultSet resultado;
// try {
// Connection conexionp = DriverManager.getConnection(
// this.url,
// this.user,
// this.password);
// String sql = "ALTER TABLE autor ORDER BY TotalArticulos DESC";
// PreparedStatement ps = conexionp.prepareStatement(sql);
// ps.setString(1, autor.getId());
// resultado = ps.executeQuery();
// while (resultado.next()) {
// System.out.println(resultado.getString("Id") + " | " +
// resultado.getString("Nombre") + " | "
// + resultado.getLong("TotalArticulos"));
// return true;
// }
// return false;
// } catch (SQLException e) {
// System.err.println(e);
// return false;
// }

// }

// }
