package es.cifpcm.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Ingredientes;
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
public class IngredientesDAOImpl implements IngredientesDAO {

  private final Logger logger = LoggerFactory.getLogger(IngredientesDAOImpl.class);

  private ConnectionDB connectionDB;

  public IngredientesDAOImpl() {
    connectionDB = new ConnectionDB();
  }

  @Override
  public List<Ingredientes> selectAll() {
    List<Ingredientes> listIngredientes = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "SELECT * FROM ingredients";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listIngredientes.add(new Ingredientes(rs.getInt(1), rs.getString(2)));
      }
    } catch (SQLException ex) {
      logger.error(IngredientesDAOImpl.class.getName() + " " + ex.getMessage());        
    } finally {
      try {
        connectionDB.Close();
      } catch (SQLException ex) {
        logger.error(IngredientesDAOImpl.class.getName() + " " + ex.getMessage());
      }
    }
    return listIngredientes;
  }

}
