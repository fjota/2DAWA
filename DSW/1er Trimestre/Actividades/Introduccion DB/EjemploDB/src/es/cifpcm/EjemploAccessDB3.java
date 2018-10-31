package es.cifpcm;

import java.sql.*;

/**
 *
 * Actualizacion de datos
 *
 * MySQL JDBC DRIVER
 *
 * @author Josué Ramírez
 */
public class EjemploAccessDB3 {

  public static void main(String[] args) throws SQLException {

    Connection conexion = null;
    int id;
    try {     
      // Cargar el driver
      Class.forName("com.mysql.jdbc.Driver");
      // Se obtiene una conexión con la base de datos.
      conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "2daw", "2daw");
      // Se crea un Statement, para realizar el query
      Statement s = conexion.createStatement();

      // Se realiza la consulta
      // Queremos obtener el id del primer contacto con nombre Juan
      ResultSet rs = s.executeQuery("SELECT id FROM contacto WHERE nombre='Juan'");

      if (rs.next()) { //Si rs.next() devuelve true significa que al menos hay un registro
        id = rs.getInt("id"); //se obtienen su id
        //se actualiza el registro
        s.executeUpdate("UPDATE contacto SET telefono='123456789' WHERE id=" + id);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } finally { // Se cierra la conexión con la base de datos.
      try {
        if (conexion != null) {
          conexion.close();
        }
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    }

  }

}
