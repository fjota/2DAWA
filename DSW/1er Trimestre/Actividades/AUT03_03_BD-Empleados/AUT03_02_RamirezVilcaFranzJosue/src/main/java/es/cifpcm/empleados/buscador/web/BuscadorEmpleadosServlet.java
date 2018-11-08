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

  //Logger
  private final Logger logger = LoggerFactory.getLogger(BuscadorEmpleadosServlet.class);

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
        Employee employee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
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
      out.println("<title>Buscador Empleados</title>");
      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\" " + request.getContextPath().concat("/css").concat("/styles.css") + "\">");
      out.println("</head>");
      out.println("<body>");
      out.println("<h2>Esta buscando a: " + request.getParameter("nameToSearch") + "</h2>");
      out.println(ShowEmployee(request.getParameter("nameToSearch")));
      out.println("<br><br>");
      out.println("<h2>Ver nomina de empleados</h2>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("<th>Id Cliente</th>");
      out.println("<th>Nombre</th>");
      out.println("<th>Fecha Nacimiento</th>");
      out.println("<th>Fecha Contrato.</th>");
      out.println("<th>   -   </th>");
      out.println("<tr>");
      for (Employee employee : listEmployee) {
        out.println("<tr>");
        out.println("<td>" + employee.getEmpNo() + "</td>");
        out.println("<td>" + employee.getFirstName() + "</td>");
        out.println("<td>" + employee.getBirthDate() + "</td>");
        out.println("<td>" + employee.getHireDate() + "</td>");
        out.println("<td> <a href='" + request.getContextPath().concat("/verNominas").concat("?empNo=").concat(employee.getEmpNo().toString()) + "'>Ver nomina</a> </td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
      conexion.close();
    }
  }

  /**
   * Show All Employees
   * @param employee
   * @return Table Html with all employees 
   */
  private String ShowEmployee(String employee) {
    List<Employee> listEmployee = SearchEmployee(employee);
    if (listEmployee.isEmpty()) {
      return "Empleado no encontrado";
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("<table border='1'>");
      sb.append("<tr> <th>Numero Empleado</th><th>Fecha Cumpleaño</th><th>Primer Nombre</th><th>Segundo Nombre</th><th>Genero</th><th>Fecha Contrato</th> </tr>");
      for (Employee object : listEmployee) {
        sb.append("<tr>");
        sb.append("<td>").append(object.getEmpNo()).append("</td>");
        sb.append("<td>").append(object.getBirthDate()).append("</td>");
        sb.append("<td>").append(object.getFirstName()).append("</td>");
        sb.append("<td>").append(object.getLastName()).append("</td>");
        sb.append("<td>").append(object.getGender()).append("</td>");
        sb.append("<td>").append(object.getHireDate()).append("</td>");
        sb.append("</tr>");
      }
      sb.append("</table>");
      return sb.toString();
    }
  }

  /**
   * Search a employee by name
   * @param employee
   * @return A list of employee
   */
  private List<Employee> SearchEmployee(String employee) {
    Connection connection = null;
    PreparedStatement preparedStm = null;
    List<Employee> listEmployee = new ArrayList<Employee>();
    try {
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String sql = "SELECT * FROM employees WHERE first_name = ?";
      preparedStm = connection.prepareStatement(sql);
      preparedStm.setString(1, employee);
      preparedStm.setMaxRows(dbPageSize);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        Employee modelEmployee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
        listEmployee.add(modelEmployee);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
    }
    return listEmployee;
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
