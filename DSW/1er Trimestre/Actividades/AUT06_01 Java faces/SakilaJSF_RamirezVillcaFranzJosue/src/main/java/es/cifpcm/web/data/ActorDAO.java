package es.cifpcm.web.data;

import es.cifpcm.model.Actor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface ActorDAO {
  
  public List<Actor> selectAll() throws SQLException;
  
}
