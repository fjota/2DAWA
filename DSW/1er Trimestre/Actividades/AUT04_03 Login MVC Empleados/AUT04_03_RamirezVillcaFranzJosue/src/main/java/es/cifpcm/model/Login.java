package es.cifpcm.model;

import java.util.Date;

/**
 *
 * @author Josué Ramírez
 */
public class Login {

  private String login;
  private String password;
  private int emp_no;

  public Login(String login, String password, int emp_no) {
    this.login = login;
    this.password = password;
    this.emp_no = emp_no;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getEmp_no() {
    return emp_no;
  }

  public void setEmp_no(int emp_no) {
    this.emp_no = emp_no;
  }
  
  

}
