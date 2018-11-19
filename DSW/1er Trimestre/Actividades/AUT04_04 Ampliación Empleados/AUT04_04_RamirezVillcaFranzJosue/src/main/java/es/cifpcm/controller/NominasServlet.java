package es.cifpcm.controller;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.EmployeeSalary;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
  private final Logger logger = LoggerFactory.getLogger(NominasServlet.class);
  
  ConnectionDB databaseConn;

  @Override
  public void init() throws ServletException {
    super.init();
    try {
      databaseConn = new ConnectionDB();
    } catch (Exception ex) {
      logger.error(NominasServlet.class.getName() + " " + ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    try {
      if (request.getParameter("empNo").isEmpty()) {
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
      } else {
        int numEmployee = Integer.parseInt(request.getParameter("empNo"));
        String pageRouteStyle = request.getContextPath().concat("/css").concat("/styles.css");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Nomina</title>");
          out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\" " + pageRouteStyle + "\">");
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>" + GetNameById(numEmployee) + "</h1>");
          out.println("<h1>Nominas</h1>");
          out.println(ShowEmployeeSalary(numEmployee));
          out.println("</body>");
          out.println("</html>");
        } finally {
          out.close();
        }
      }
    } catch (IOException | NumberFormatException | SQLException | ServletException e) {
      logger.error(NominasServlet.class.getName() + " " + e.getMessage());
    } finally {
      getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }

  /**
   * Contruct table HTML with all information about salary employee
   *
   * @param employee
   * @return String
   */
  private String ShowEmployeeSalary(int employee) throws SQLException {
    List<EmployeeSalary> employeeList = SearchEmployeeSalary(employee);
    StringBuilder sb = new StringBuilder();
    sb.append("<table>");
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

  /**
   * Search salary of employee
   *
   * @param numEmployee
   * @return List<EmployeeSalary>
   */
  private List<EmployeeSalary> SearchEmployeeSalary(int numEmployee) throws SQLException {    
    PreparedStatement preparedStm = null;
    List<EmployeeSalary> employeeList = new ArrayList<EmployeeSalary>();
    EmployeeSalary employee = null;
    try {      
      String sql = "SELECT salary, from_date, to_date FROM salaries WHERE emp_no = ?";
      preparedStm = databaseConn.Connect().prepareStatement(sql);
      preparedStm.setInt(1, numEmployee);
      preparedStm.setMaxRows(databaseConn.getDbPageSize());
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        employee = new EmployeeSalary(rs.getInt(1), rs.getDate(2), rs.getDate(3));
        employeeList.add(employee);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
    } finally {
      databaseConn.Close();
    }
    return employeeList;
  }

  /**
   * Search employee by ID
   *
   * @param numEmployee
   * @return String
   */
  private String GetNameById(int numEmployee) throws SQLException { 
    PreparedStatement preparedStm = null;
    String nameEmployee = "";
    try {      
      String sql = "SELECT first_name, last_name FROM employees WHERE emp_no = ?";
      preparedStm = databaseConn.Connect().prepareStatement(sql);
      preparedStm.setInt(1, numEmployee);
      preparedStm.setMaxRows(databaseConn.getDbPageSize());
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        nameEmployee = rs.getString(1) + " " + rs.getString(2);
      }
    } catch (SQLException e) {
      logger.error(NominasServlet.class.getName() + " " + e.getMessage());
    } finally {
      databaseConn.Close();
    }
    return nameEmployee;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(NominasServlet.class.getName() + " " + ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(NominasServlet.class.getName() + " " + ex.getMessage());
    }
  }

}
