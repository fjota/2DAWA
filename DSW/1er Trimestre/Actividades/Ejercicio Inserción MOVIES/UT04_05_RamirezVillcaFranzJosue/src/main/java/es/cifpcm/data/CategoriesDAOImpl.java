package es.cifpcm.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Ramirez
 */
public class CategoriesDAOImpl implements CategoriesDAO {
  
  private final Logger logger = LoggerFactory.getLogger(CategoriesDAOImpl.class);
  
  ConnectionDB connectionDB;
  
  public CategoriesDAOImpl() {
    connectionDB = new ConnectionDB();
  }

  @Override
  public List<Categories> selectAll() 
          throws SQLException {
    List<Categories> listcaCategories = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "SELECT * FROM Categories";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listcaCategories.add(new Categories(rs.getInt(1), rs.getString(2)));
      }
    } catch (SQLException ex) {
      logger.error(CategoriesDAOImpl.class.getName() + " " + ex.getMessage());
    } finally {
      connectionDB.Close();
    }   
    return listcaCategories;
  }  
  
}
