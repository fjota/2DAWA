package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Municipios;
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
public class MunicipiosDaoImpl implements MunicipiosDao {

  private final Logger logger = LoggerFactory.getLogger(MunicipiosDaoImpl.class);

  private DaoFactory df;

  public MunicipiosDaoImpl() {
    df = DaoFactory.getInstance();
  }

  @Override
  public List<Municipios> selectAll() {
    List<Municipios> listMunicipios = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    Connection conn = null;
    try {
      conn = df.getConnection();
      String sql = "SELECT * FROM municipios";
      preparedStatement = conn.prepareStatement(sql);
      
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listMunicipios.add(new Municipios(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
      }
    } catch (SQLException ex) {
      logger.error(MunicipiosDaoImpl.class.getName() + " " + ex.getMessage());
    } finally {
      try {
        if (!conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException ex) {
        logger.error(MunicipiosDaoImpl.class.getName() + " " + ex.getMessage());
      }
    }

    return listMunicipios;
  }
}
