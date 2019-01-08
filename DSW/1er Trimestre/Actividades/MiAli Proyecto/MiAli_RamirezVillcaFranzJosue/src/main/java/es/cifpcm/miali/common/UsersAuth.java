package es.cifpcm.miali.common;

import es.cifpcm.miali.data.UsersDao;
import es.cifpcm.miali.data.UsersDaoImpl;
import es.cifpcm.miali.model.Users;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "usersAuth")
@RequestScoped
public class UsersAuth extends Users {
    
  UsersDao usersDaoImpl = new UsersDaoImpl();
  
  /**
   * Creates a new instance of UsersAuth
   */
  public UsersAuth() {        
  }
  
  public String registerUser(){
    usersDaoImpl.insertUser(new Users(this.getUser_id(), this.getUser_name(), this.getPassword()));
    return "/newCostumer";
  }
    
  public String loginUser(){
    if (usersDaoImpl.selectUser(this.getUser_name()) == null) {
      return "/index";
    } else {
      return "/newCostumer";      
    }
  }
  
}
