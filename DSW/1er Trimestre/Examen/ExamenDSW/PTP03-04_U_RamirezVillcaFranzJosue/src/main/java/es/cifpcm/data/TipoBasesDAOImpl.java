package es.cifpcm.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Ingredientes;
import es.cifpcm.model.TipoBases;
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
public class TipoBasesDAOImpl implements TipoBasesDAO {

  private final Logger logger = LoggerFactory.getLogger(TipoBasesDAOImpl.class);

  private final ConnectionDB connectionDB;

  public TipoBasesDAOImpl() {
    connectionDB = new ConnectionDB();
  }

  @Override
  public List<TipoBases> selectAll() {
    List<TipoBases> listTipoBases = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "SELECT * FROM tiposbases";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listTipoBases.add(new TipoBases(rs.getInt(1), rs.getString(2)));
      }
    } catch (SQLException ex) {
      logger.error(TipoBasesDAOImpl.class.getName() + " " + ex.getMessage());
    } finally {
      try {
        connectionDB.Close();
      } catch (SQLException ex) {
        logger.error(TipoBasesDAOImpl.class.getName() + " " + ex.getMessage());
      }
    }
    return listTipoBases;
  }

}
