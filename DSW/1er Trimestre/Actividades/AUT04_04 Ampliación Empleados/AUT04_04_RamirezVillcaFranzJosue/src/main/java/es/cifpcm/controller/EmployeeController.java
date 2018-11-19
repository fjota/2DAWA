package es.cifpcm.controller;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
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
public class EmployeeController extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  ConnectionDB databaseConn;

  @Override
  public void init() throws ServletException {
    super.init();
    try {
      databaseConn = new ConnectionDB();
    } catch (Exception ex) {
      logger.error(EmployeeController.class.getName() + " " + ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    
    request.setAttribute("employeeList", SearchEmployee(request.getParameter("firstName"),
            request.getParameter("lastName")));
    RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
    dispatcher.forward(request, response);
    /*
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet EmployeeController</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet EmployeeController at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }*/
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(EmployeeController.class.getName() + " " + ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      logger.error(EmployeeController.class.getName() + " " + ex.getMessage());
    }
  }

  //Logic
  private List<Employee> SearchEmployee(String firstName, String lastName)
          throws SQLException {
    PreparedStatement preparedStm = null;
    List<Employee> listEmployee = new ArrayList<>();
    Employee employee = null;
    try {
      String sql = "SELECT * FROM employees WHERE first_name = ? and last_name = ?";
      preparedStm = databaseConn.Connect().prepareStatement(sql);
      preparedStm.setString(1, firstName);
      preparedStm.setString(2, lastName);
      preparedStm.setMaxRows(databaseConn.getDbPageSize());
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        employee = new Employee(rs.getInt(1), rs.getDate(2),
                rs.getString(3), rs.getString(4),
                rs.getString(5).charAt(0), rs.getDate(6));
        listEmployee.add(employee);
      }
    } catch (SQLException e) {
      logger.error(EmployeeController.class.getName() + " " + e.getMessage());
    } finally {
      databaseConn.Close();
    }    
    return listEmployee;
  }

}
