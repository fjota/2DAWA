package es.cifpcm.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramirez
 */
public class ConnectionDB {
  
  private final Logger logger = LoggerFactory.getLogger(ConnectionDB.class);

  private String dbUrl;
  private String dbUser;
  private String dbPassword;
  private int dbPageSize;
  private int DEFAULT_PAGESIZE = 10;
  private int minPageSize = 0;
  private Connection conn;

  public ConnectionDB() {

    try {
      ResourceBundle rb = ResourceBundle.getBundle("empleados");
      dbUrl = rb.getString("database.url");
      dbUser = rb.getString("database.user");
      dbPassword = rb.getString("database.password");
      dbPageSize = rb.getString("database.pageSize") == null ?
              DEFAULT_PAGESIZE : 
              Integer.parseInt(rb.getString("database.pageSize"));
      String driverClassName = rb.getString("database.driver");
      Class.forName(driverClassName);
    } catch (ClassNotFoundException | NumberFormatException ex) {
      logger.error(ConnectionDB.class.getName() + " " + ex.getMessage());
    }

  }
  
  public Connection Connect() 
          throws SQLException {
    try {
      conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      return conn;
    } catch (SQLException ex) {
      logger.error(ConnectionDB.class.getName() + " " + ex.getMessage());
      return null;
    }    
  }
  
  public void Close() throws SQLException {
    if (conn != null) {
      if (!conn.isClosed()) {
        conn.close();
      }
    }
  }

  public String getDbUrl() {
    return dbUrl;
  }

  public void setDbUrl(String dbUrl) {
    this.dbUrl = dbUrl;
  }

  public String getDbUser() {
    return dbUser;
  }

  public void setDbUser(String dbUser) {
    this.dbUser = dbUser;
  }

  public String getDbPassword() {
    return dbPassword;
  }

  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
  }

  public int getDbPageSize() {
    return dbPageSize;
  }

  public void setDbPageSize(int dbPageSize) {
    this.dbPageSize = dbPageSize;
  }

  public int getDEFAULT_PAGESIZE() {
    return DEFAULT_PAGESIZE;
  }

  public void setDEFAULT_PAGESIZE(int DEFAULT_PAGESIZE) {
    this.DEFAULT_PAGESIZE = DEFAULT_PAGESIZE;
  }

  public int getMinPageSize() {
    return minPageSize;
  }

  public void setMinPageSize(int minPageSize) {
    this.minPageSize = minPageSize;
  } 

  public Connection getConn() {
    return conn;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }
          
 

}
