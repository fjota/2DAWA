package es.cifpcm.data;

import es.cifpcm.model.Categories;
import es.cifpcm.model.Movies;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josue Ramirez
 */
public interface CategoriesDAO {
  
  public List<Categories> selectAll() throws SQLException; 
  
}
