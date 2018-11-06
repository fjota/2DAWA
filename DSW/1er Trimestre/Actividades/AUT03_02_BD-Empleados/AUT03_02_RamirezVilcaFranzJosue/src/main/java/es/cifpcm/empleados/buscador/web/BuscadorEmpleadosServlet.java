package es.cifpcm.empleados.buscador.web;

import es.cifpcm.empleados.buscador.web.model.Employee;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
public class BuscadorEmpleadosServlet extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(BuscadorEmpleadosServlet.class);

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
      logger.error(ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    List<Employee> listEmployee = new ArrayList<Employee>();
    Connection conexion = null;
    try {
      conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      Statement s = conexion.createStatement();
      s.setMaxRows(dbPageSize);
      ResultSet rs = s.executeQuery("select * from employees");
      while (rs.next()) {
        Employee employee = new Employee();
        employee.setEmpNo(rs.getInt(1));
        employee.setFirstName(rs.getString(3));
        employee.setLastName(rs.getString(4));
        listEmployee.add(employee);
      }

    } catch (SQLException e) {
      logger.error(e.getMessage());
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet BuscadorEmpleadosServlet</title>");
      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\" " + request.getContextPath().concat("/css").concat("/styles.css") +"\">");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet BuscadorEmpleadosServlet at " + request.getContextPath() + "</h1>");
      out.println("<table border='1'>");
      out.println("</tr>");
      out.println("<th>Id Cliente</th>");
      out.println("<th>Nombre</th>");
      out.println("<th>Apellido</th>");      
      out.println("<tr>");
      for (int i = 0; i < 10; i++) {
        out.println("<tr>");
        out.println("<td>" + listEmployee.get(i).getEmpNo() + "</td>");
        out.println("<td>" + listEmployee.get(i).getFirstName() + "</td>");
        out.println("<td>" + listEmployee.get(i).getLastName() + "</td>");
        out.println("</tr>");
      }
      out.println("<table>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
      conexion.close();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(BuscadorEmpleadosServlet.class.getName() + " " + ex.getMessage());      
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(BuscadorEmpleadosServlet.class.getName() + " " + ex.getMessage());      
    }
  }

}
