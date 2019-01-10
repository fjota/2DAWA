package es.cifpcm.miali.common;

import es.cifpcm.miali.data.UsersDao;
import es.cifpcm.miali.data.UsersDaoImpl;
import es.cifpcm.miali.model.Users;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "usersAuth")
@ApplicationScoped
public class UsersAuth extends Users {

  UsersDao usersDaoImpl = new UsersDaoImpl();

  /**
   * Creates a new instance of UsersAuth
   */
  public UsersAuth() {
  }

  public String registerUser() {
    usersDaoImpl.insertUser(this);
    return "/index";
  }

  public String loginUser() {
    if (usersDaoImpl.selectUser(this.getUser_name(), this.getPassword()) != null) {
      return "/index";
    } else {
      return "/login";
    }
  }

}
