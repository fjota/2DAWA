package es.cifpcm.data;

import es.cifpcm.model.Movies;
import java.sql.SQLException;

/**
 *
 * @author Josue Ramirez
 */
public interface MoviesDAO {
    
  public void insert(Movies movie) throws SQLException;  
  
}
