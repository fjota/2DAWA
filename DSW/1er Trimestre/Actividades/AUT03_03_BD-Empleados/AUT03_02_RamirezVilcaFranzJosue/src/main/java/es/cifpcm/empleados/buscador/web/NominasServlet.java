package es.cifpcm.empleados.buscador.web;

import es.cifpcm.empleados.buscador.web.model.EmployeeSalary;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class NominasServlet extends HttpServlet {

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
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet NominasServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>"+GetNameById(Integer.parseInt(request.getParameter("empNo")))+"</h1>");
      out.println("<h1>Nominas</h1>");
      out.println(ShowEmployeeSalary(Integer.parseInt(request.getParameter("empNo"))));
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  private String ShowEmployeeSalary(int employee) {
    List<EmployeeSalary> employeeList = SearchEmployeeSalary(employee);
    StringBuilder sb = new StringBuilder();
    sb.append("<table border='1'>");
    sb.append("<tr> <th>Salary</th><th>From Date</th><th>To Date</th> </tr>");
    for (EmployeeSalary object : employeeList) {
      sb.append("<tr>");
      sb.append("<td>").append(object.getSalary()).append("</td>");
      sb.append("<td>").append(object.getFromDate()).append("</td>");
      sb.append("<td>").append(object.getToDate()).append("</td>");
      sb.append("</tr>");
    }
    sb.append("</table>");
    return sb.toString();

  }

  private List<EmployeeSalary> SearchEmployeeSalary(int numEmployee) {
    Connection connection = null;
    PreparedStatement preparedStm = null;
    List<EmployeeSalary> employeeList = new ArrayList<EmployeeSalary>();
    try {
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String sql = "SELECT salary, from_date, to_date FROM salaries WHERE emp_no = ?";
      preparedStm = connection.prepareStatement(sql);
      preparedStm.setInt(1, numEmployee);
      preparedStm.setMaxRows(dbPageSize);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        EmployeeSalary employee = new EmployeeSalary(rs.getInt(1), rs.getDate(2), rs.getDate(3));
        employeeList.add(employee);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
    }
    return employeeList;
  }
  
  private String GetNameById(int numEmployee) {
    Connection connection = null;
    PreparedStatement preparedStm = null;
    String nameEmployee = "";
    try {
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String sql = "SELECT first_name, last_name FROM employees WHERE emp_no = ?";
      preparedStm = connection.prepareStatement(sql);
      preparedStm.setInt(1, numEmployee);
      preparedStm.setMaxRows(dbPageSize);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        nameEmployee = rs.getString(1) + " " + rs.getString(2);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
    }
    return nameEmployee;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

}
