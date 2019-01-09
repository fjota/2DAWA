package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Provincias;
import es.cifpcm.miali.model.Users;
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
public class UsersDaoImpl implements UsersDao {

  private final org.slf4j.Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

  private DaoFactory df;

  public UsersDaoImpl() {
    df = DaoFactory.getInstance();
  }

  @Override
  public Users insertUser(Users user) {
    PreparedStatement preparedStatement = null;
    Connection conn = null;
    try {
      conn = df.getConnection();
      String sql = "INSERT INTO users (user_name, password) VALUES(?, ?)";
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, user.getUser_name());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      logger.error(UsersDaoImpl.class.getName() + " " + ex.getMessage());
    } finally {
      try {
        if (!conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException ex) {
        logger.error(UsersDaoImpl.class.getName() + " " + ex.getMessage());
      }
    }
    return user;
  }

  @Override
  public String selectUser(String user_name, String password) {
    PreparedStatement preparedStatement = null;
    Connection conn = null;
    try {
      conn = df.getConnection();
      String sql = "SELECT user_name FROM users WHERE user_name = ? and password = ?";
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, user_name);
      preparedStatement.setString(2, password);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return rs.getString(1);
      }
    } catch (SQLException ex) {
      logger.error(UsersDaoImpl.class.getName() + " " + ex.getMessage());
    } finally {
      try {
        if (!conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException ex) {
        logger.error(UsersDaoImpl.class.getName() + " " + ex.getMessage());
      }
    }
    return null;
  }

}
