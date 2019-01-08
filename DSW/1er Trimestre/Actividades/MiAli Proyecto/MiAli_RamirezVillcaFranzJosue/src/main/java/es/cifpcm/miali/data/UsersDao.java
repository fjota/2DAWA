package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Users;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface UsersDao {
  
  public Users insertUser(Users user);  
  public String selectUser(String user_name);
  
}
