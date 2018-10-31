package es.cifpcm;

import java.sql.*;

/**
 *
 * Creacion de Tabla 
 * 
 * MySQL JDBC DRIVER
 * 
 * @author Josué Ramírez
 */
public class EjemploAccessDB2 {

  public static void main(String[] args) throws SQLException {

    Connection conexion = null;
    try {
      // Cargar el driver
      Class.forName("com.mysql.jdbc.Driver");
      // Se obtiene una conexión con la base de datos. 

      conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "2daw", "2daw");
      // Se crea un Statement, para realizar el query
      Statement s = conexion.createStatement();
      //se crea una tabla nueva
      s.executeUpdate("CREATE TABLE contacto2 (id INT AUTO_INCREMENT, PRIMARY KEY(id),nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
      //Los datos que vamos a insertar los tenemos en 3 arrays
      String nombres[] = {"Juan", "Pedro", "Antonio"};
      String apellidos[] = {"Gomez", "Lopez", "Alvarez"};
      String telefonos[] = {"987452154", "989654125", "985321478"};
      //se insertan datos en la tabla
      for (int i = 0; i < nombres.length; i++) {
        s.executeUpdate("INSERT INTO contacto2 (nombre, apellidos, telefono) VALUES ('"
                + nombres[i] + "','" + apellidos[i] + "','" + telefonos[i] + "' )");
      }
      // Se realiza una consulta sobre la tabla contacto.
      ResultSet rs = s.executeQuery("select * from contacto2");
      // Se recorre el ResultSet, mostrando por pantalla los resultados.
      while (rs.next()) {
        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
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
