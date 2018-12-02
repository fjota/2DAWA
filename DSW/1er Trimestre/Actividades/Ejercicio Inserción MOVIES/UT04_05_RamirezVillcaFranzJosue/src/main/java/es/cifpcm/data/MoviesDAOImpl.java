package es.cifpcm.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Movies;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Ramirez
 */
public class MoviesDAOImpl implements MoviesDAO {
  
  private final Logger logger = LoggerFactory.getLogger(MoviesDAOImpl.class);
  
  ConnectionDB connectionDB;
  
  public MoviesDAOImpl() {
    connectionDB = new ConnectionDB();
  }  

  @Override
  public void insert(Movies movie) 
          throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      String sql = "INSERT INTO movies (idcategory, titulo) VALUES (?,?)";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      preparedStatement.setInt(1, movie.getIdCategory());
      preparedStatement.setString(2, movie.getTitulo());
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      logger.error(MoviesDAOImpl.class.getName() + " " + ex.getMessage());
    } finally {
      connectionDB.Close();
    }
  }
  
}
