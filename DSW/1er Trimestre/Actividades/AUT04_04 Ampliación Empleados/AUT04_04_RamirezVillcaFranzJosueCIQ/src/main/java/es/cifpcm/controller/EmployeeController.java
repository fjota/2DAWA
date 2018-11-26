package es.cifpcm.controller;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Employee;
import es.cifpcm.utils.ServletUtils;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
  static String firsName = "";
  static String lastName = "";

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
    String message = "";
    try {
      //Page Size input
      if (!request.getParameter("tamanoPgina").isEmpty()) {
        try {
          databaseConn.setDbPageSize(Integer.parseInt(request.getParameter("tamanoPgina")));
          if (ServletUtils.getCookie(request, "pageSize") == null) {
            Cookie pageSizeCookie = new Cookie("pageSize",
                    Integer.toString(databaseConn.getDbPageSize()));
            pageSizeCookie.setMaxAge(24 * 60 * 60 * 365);
            pageSizeCookie.setPath(request.getContextPath());
            response.addCookie(pageSizeCookie);
          } else {
            Cookie pageSizeCookie = ServletUtils.getCookie(request, "pageSize");
            pageSizeCookie.setValue(Integer.toString(databaseConn.getDbPageSize()));
            response.addCookie(pageSizeCookie);
          }
          request.setAttribute("employeeList", ListEmployees());
        } catch (NumberFormatException ex) {
          logger.error(EmployeeController.class.getName() + " " + ex.getMessage());
          message += "Has tried to pass a data other than a number<br>";
        }
      } else {
        Cookie pageSizeCookie = ServletUtils.getCookie(request, "pageSize");
        if (pageSizeCookie != null) {
          databaseConn.setDbPageSize(Integer.parseInt(pageSizeCookie.getValue()));
          request.setAttribute("employeeList", ListEmployees());
        } else {
          message += "You did not write any value for the page size<br>";
        }
      }
      //Input names               
      List<String> parameterList = Collections.list(request.getParameterNames());
      if (parameterList.contains("firstName")) {
        if (request.getParameter("firstName").isEmpty()) {
          message += "Input name are empty<br>";
        }
      }
      if (parameterList.contains("lastName")) {
        if (request.getParameter("lastName").isEmpty()) {
          message += "Input last name are empty<br>";
        }
      }

      if (!request.getParameter("firstName").isEmpty() && !request.getParameter("lastName").isEmpty()) {
        request.setAttribute("employeeBean", SearchEmployee(request.getParameter("firstName"),
                request.getParameter("lastName")));
        firsName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
      }
      //When page size change for url
      String buttonSearched = request.getParameter("searchedButton");
      if (buttonSearched == null) {
        if (request.getParameter("firstName").isEmpty() && request.getParameter("lastName").isEmpty()) {
          if (!firsName.isEmpty() || !lastName.isEmpty()) {
            request.setAttribute("employeeBean", SearchEmployee(firsName, lastName));
          }
        }
      }      
      request.setAttribute("errorInput", message);
    } catch (NumberFormatException | SQLException ex) {
      logger.error(EmployeeController.class.getName() + " " + ex.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request, response);
    } finally {
      if (message.isEmpty()) {
        request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("emptyData.jsp").forward(request, response);
      }
      message = "";
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);

    } catch (SQLException ex) {
      logger.error(EmployeeController.class
              .getName() + " " + ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      request.setAttribute("employeeBean", SearchEmployee(firsName, lastName));

    } catch (SQLException ex) {
      logger.error(EmployeeController.class
              .getName() + " " + ex.getMessage());
    }
    if (request.getParameter("boton").contains("Anterior")) {
      try {
        PreviousPage();
        request.setAttribute("employeeList", ListEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException ex) {
        logger.error(EmployeeController.class
                .getName() + " " + ex.getMessage());
      }
    }
    if (request.getParameter("boton").contains("Siguiente")) {
      try {
        NextPage();
        request.setAttribute("employeeList", ListEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException ex) {
        logger.error(EmployeeController.class
                .getName() + " " + ex.getMessage());
      }
    }
    if (request.getParameter("boton").contains("Primero")) {
      try {
        FirstPage();
        request.setAttribute("employeeList", ListEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException ex) {
        logger.error(EmployeeController.class
                .getName() + " " + ex.getMessage());
      }
    }
    if (request.getParameter("boton").contains("Ultimo")) {
      try {
        LastPage();
        request.setAttribute("employeeList", ListEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException ex) {
        logger.error(EmployeeController.class
                .getName() + " " + ex.getMessage());
      }
    }

  }

  /**
   * Seach Employee
   *
   * @param firstName
   * @param lastName
   * @return Employee
   * @throws SQLException
   */
  private Employee SearchEmployee(String firstName, String lastName)
          throws SQLException {
    PreparedStatement preparedStm = null;
    Employee employee = null;
    try {
      String sql = "SELECT * FROM employees WHERE first_name = ? and last_name = ?";
      preparedStm = databaseConn.Connect().prepareStatement(sql);
      preparedStm.setString(1, firstName);
      preparedStm.setString(2, lastName);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        employee = new Employee(rs.getInt(1), rs.getDate(2),
                rs.getString(3), rs.getString(4),
                rs.getString(5).charAt(0), rs.getDate(6));

      }
    } catch (SQLException e) {
      logger.error(EmployeeController.class
              .getName() + " " + e.getMessage());
    } finally {
      databaseConn.Close();
    }
    return employee;
  }

  private List<Employee> ListEmployees()
          throws SQLException {
    PreparedStatement preparedStm = null;
    List<Employee> listEmployee = new ArrayList<>();
    Employee employee = null;
    try {
      String sql = "SELECT * FROM employees LIMIT ?,?";
      preparedStm = databaseConn.Connect().prepareStatement(sql);
      preparedStm.setInt(1, databaseConn.getMinPageSize());
      preparedStm.setInt(2, databaseConn.getDbPageSize());
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        employee = new Employee(rs.getInt(1), rs.getDate(2),
                rs.getString(3), rs.getString(4),
                rs.getString(5).charAt(0), rs.getDate(6));
        listEmployee.add(employee);

      }
    } catch (SQLException e) {
      logger.error(EmployeeController.class
              .getName() + " " + e.getMessage());
    } finally {
      databaseConn.Close();
    }
    return listEmployee;
  }

  public void NextPage()
          throws SQLException {
    databaseConn.setMinPageSize(databaseConn.getMinPageSize() + databaseConn.getDbPageSize());
    if (databaseConn.getMinPageSize() > (GetLastPage() - databaseConn.getDbPageSize())) {
      databaseConn.setMinPageSize(GetLastPage() - databaseConn.getDbPageSize());
    }
    databaseConn.setDbPageSize(databaseConn.getDbPageSize());
  }

  public void PreviousPage() {
    databaseConn.setMinPageSize(databaseConn.getMinPageSize() - databaseConn.getDbPageSize());
    if (databaseConn.getMinPageSize() < 0) {
      databaseConn.setMinPageSize(0);
    }
    databaseConn.setDbPageSize(databaseConn.getDbPageSize());
  }

  public void FirstPage() {
    databaseConn.setMinPageSize(0);
    databaseConn.setDbPageSize(databaseConn.getDbPageSize());
  }

  public void LastPage()
          throws SQLException {
    databaseConn.setMinPageSize(GetLastPage() - databaseConn.getDbPageSize());
    databaseConn.setDbPageSize(databaseConn.getDbPageSize());
  }

  /**
   * Count all data of employees and return the number for pagination
   *
   * @return
   * @throws SQLException
   */
  private int GetLastPage()
          throws SQLException {
    int lastPage = 0;
    PreparedStatement preparedStm = null;
    try {
      String sqlCount = "SELECT COUNT(*) FROM employees";
      preparedStm = databaseConn.Connect().prepareStatement(sqlCount);
      ResultSet rs = preparedStm.executeQuery();
      while (rs.next()) {
        lastPage = rs.getInt(1);

      }
      /*lastPage -= databaseConn.getDbPageSize();*/
    } catch (SQLException e) {
      logger.error(EmployeeController.class
              .getName() + " " + e.getMessage());
    } finally {
      databaseConn.Close();
    }
    return lastPage;
  }

}
