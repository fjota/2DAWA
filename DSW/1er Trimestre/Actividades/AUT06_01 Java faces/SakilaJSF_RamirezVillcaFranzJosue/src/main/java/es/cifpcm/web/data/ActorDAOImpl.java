package es.cifpcm.web.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Actor;
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
public class ActorDAOImpl implements ActorDAO {
  
  private final Logger logger = LoggerFactory.getLogger(ActorDAOImpl.class);
  
  private ConnectionDB connectionDB;

  public ActorDAOImpl() {
    connectionDB = new ConnectionDB();
  }
      
  @Override
  public List<Actor> selectAll() throws SQLException {
    List<Actor> listActor = new ArrayList<>();   
    PreparedStatement preparedStatement = null;
    try {
      String sql = "SELECT * FROM actor";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {        
        listActor.add(new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
      }
    } catch (SQLException ex) {
      logger.error(ActorDAOImpl.class
              .getName() + " " + ex.getMessage());
    } finally {
      connectionDB.Close();
    }
    return listActor;
  }
  
}
