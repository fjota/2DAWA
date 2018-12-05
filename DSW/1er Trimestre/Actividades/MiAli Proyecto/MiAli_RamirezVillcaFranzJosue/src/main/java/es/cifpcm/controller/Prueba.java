package es.cifpcm.controller;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.miali.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Ramirez
 */
public class Prueba extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(Prueba.class);

  ConnectionDB cDB;

  @Override
  public void init() throws ServletException {
    super.init();
    try {
      cDB = new ConnectionDB();
    } catch (Exception ex) {
      logger.error(Prueba.class.getName() + " " + ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {

    List<Employee> listEmployee = new ArrayList<>();
    Employee employee = null;
    Statement s = cDB.Connect().createStatement();
    s.setMaxRows(cDB.getDbPageSize());
    ResultSet rs = s.executeQuery("select * from employees");
    while (rs.next()) {
      employee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
      listEmployee.add(employee);
    }

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Prueba</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Prueba at " + request.getContextPath() + "</h1>");
      out.println(listEmployee.get(0).getLast_name());
      out.println(listEmployee.get(4).getBirth_date());
      out.println("</body>");
      out.println("</html>");
    }
    
    cDB.Close();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      java.util.logging.Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      java.util.logging.Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
