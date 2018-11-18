package es.cifpcm.controller;

import es.cifpcm.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
public class LoginControllerServlet extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(LoginControllerServlet.class);

  //Database Settings
  private String dbUrl;
  private String dbUser;
  private String dbPassword;
  private int dbPageSize;
  private final int DEFAULT_PAGESIZE = 5;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    try {      
      String configBundleName = config.getInitParameter("app.config");
      ResourceBundle rb = ResourceBundle.getBundle(configBundleName);
      dbUrl = rb.getString("database.url");
      dbUser = rb.getString("database.user");
      dbPassword = rb.getString("database.password");
      dbPageSize = rb.getString("database.pageSize") == null ? DEFAULT_PAGESIZE : Integer.parseInt(rb.getString("database.pageSize"));
      String driverClassName = rb.getString("database.driver");
      Class.forName(driverClassName);
    } catch (ClassNotFoundException ex) {
      logger.error(LoginControllerServlet.class.getName() + " " + ex);
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    Connection conn = null;
    Login log = null;
    try {
      conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String query = "SELECT login, emp_no FROM employees.login WHERE login= ? AND password = ?";
      PreparedStatement pstmt = conn.prepareStatement(query);
      String user = request.getParameter("txtUser");
      String password = request.getParameter("txtPassword");
      pstmt.setString(1, user);
      pstmt.setString(2, password);
      ResultSet rs;
      rs = pstmt.executeQuery();
      if (rs.next()) {
        log = new Login(rs.getInt("emp_no"), rs.getString("login"), "");
        request.setAttribute("loginBean", log);
        getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
      } else {
        getServletContext().getRequestDispatcher("/loginFailed.jsp").forward(request, response);
      }
    } catch (SQLException ex) {
      logger.error(LoginControllerServlet.class.getName() + " " + ex);
    } 

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(LoginControllerServlet.class.getName() + " " + ex);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(LoginControllerServlet.class.getName() + " " + ex);
    }
  }

}
