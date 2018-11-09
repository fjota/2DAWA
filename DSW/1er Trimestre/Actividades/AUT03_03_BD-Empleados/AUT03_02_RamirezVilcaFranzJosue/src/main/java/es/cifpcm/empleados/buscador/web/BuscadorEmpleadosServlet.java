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
      logger.error(BuscadorEmpleadosServlet.class.getName() + " " + ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {

    /*if (request.getParameterMap().isEmpty()) {
      getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
    } else {*/
    try {
      if (request.getParameter("nameToSearch").isEmpty()) {
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
      } else {
        String nameToSearch = request.getParameter("nameToSearch");
        String pageRouteStyle = request.getContextPath().concat("/css").concat("/styles.css");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Buscador Empleados</title>");
          out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\" " + pageRouteStyle + "\">");
          out.println("</head>");
          out.println("<body>");
          out.println("<h2>Esta buscando a: " + nameToSearch + "</h2>");
          out.println(ShowEmployee(nameToSearch));
          out.println("<br><br>");
          out.println("<h2>Ver nomina de empleados</h2>");
          out.println(ListEmploye(request.getContextPath()));
          out.println("</body>");
          out.println("</html>");
        } finally {
          out.close();
        }
      }
    } catch (IOException e) {
      logger.warn(BuscadorEmpleadosServlet.class.getName() + " " + e.getMessage());      
    } catch (SQLException e) {
      logger.warn(BuscadorEmpleadosServlet.class.getName() + " " + e.getMessage());      
    } catch (ServletException e) {
      logger.warn(BuscadorEmpleadosServlet.class.getName() + " " + e.getMessage());
    } finally {
      getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }

  private List<Employee> GetAllEmployees() throws SQLException {
    List<Employee> listEmployee = new ArrayList<Employee>();
    Employee employee = null;
    Connection conexion = null;
    try {
      conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      Statement s = conexion.createStatement();
      s.setMaxRows(dbPageSize);
      ResultSet rs = s.executeQuery("select * from employees");
      while (rs.next()) {
        employee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
        listEmployee.add(employee);
      }
    } catch (SQLException e) {
      logger.error(BuscadorEmpleadosServlet.class.getName() + " " + e.getMessage());
    } finally {
      if (conexion != null) {
        conexion.close();
      }
    }
    return listEmployee;
  }

  /**
   * Create a table with employees for view data salary
   *
   * @param context
   * @return
   */
  private String ListEmploye(String context) throws SQLException {
    StringBuilder sb = new StringBuilder();
    List<Employee> listEmployee = GetAllEmployees();
    sb.append("<table>");
    sb.append("<tr> <th>Id Cliente</th><th>Nombre</th><th>Fecha Nacimiento</th><th>Fecha Contrato</th><th>   -   </th> </tr>");
    for (Employee object : listEmployee) {
      sb.append("<tr>");
      sb.append("<td>").append(object.getEmpNo()).append("</td>");
      sb.append("<td>").append(object.getFirstName()).append("</td>");
      sb.append("<td>").append(object.getBirthDate()).append("</td>");
      sb.append("<td>").append(object.getHireDate()).append("</td>");
      sb.append("<td> <a href='").append(context.concat("/verNominas").concat("?empNo=").concat(object.getEmpNo().toString())).append("'>Ver nomina</a> </td>");
      sb.append("</tr>");
    }
    sb.append("</table>");

    return sb.toString();
  }

  /**
   * Create a table HTML with all employees data
   *
   * @param employee
   * @return String
   */
  private String ShowEmployee(String employee) throws SQLException {
    List<Employee> listEmployee = SearchEmployee(employee);
    if (listEmployee.isEmpty()) {
      return "Empleado no encontrado";
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("<table>");
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
   *
   * @param employee
   * @return List<Employee>
   */
  private List<Employee> SearchEmployee(String employee) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStm = null;
    List<Employee> listEmployee = new ArrayList<Employee>();
    Employee modelEmployee = null;
    try {
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String sql = "SELECT * FROM employees WHERE first_name = ?";
      preparedStm = connection.prepareStatement(sql);
      preparedStm.setString(1, employee);
      preparedStm.setMaxRows(dbPageSize);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        modelEmployee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
        listEmployee.add(modelEmployee);
      }
    } catch (SQLException e) {
      logger.error(BuscadorEmpleadosServlet.class.getName() + " " + e.getMessage());
    } finally {
      if (connection != null) {
        connection.close();
      }
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
