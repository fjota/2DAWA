package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Provincias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
public class ProvinciasDaoImpl implements ProvinciasDao {
  
  private final org.slf4j.Logger logger = LoggerFactory.getLogger(ProvinciasDaoImpl.class);

  private DaoFactory df;   
  
  public ProvinciasDaoImpl() {
    df = DaoFactory.getInstance();
  }

  @Override
  public List<Provincias> selectAll() {

    List<Provincias> listProvincias = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    Connection conn = null; 
    try {
      conn = df.getConnection();
      String sql = "SELECT * FROM provincias";
      preparedStatement = conn.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listProvincias.add(new Provincias(rs.getInt(1), rs.getString(2)));
      }
    } catch (SQLException ex) {
      logger.error(ProvinciasDaoImpl.class.getName() + " " + ex.getMessage()); 
    } finally {
      try {
        if (!conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException ex) {
        logger.error(ProvinciasDaoImpl.class.getName() + " " + ex.getMessage()); 
      }      
    }
  
    return listProvincias;
  }

}
