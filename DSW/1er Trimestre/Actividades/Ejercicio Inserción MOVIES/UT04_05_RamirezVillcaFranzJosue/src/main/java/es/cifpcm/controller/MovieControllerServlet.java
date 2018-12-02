package es.cifpcm.controller;

import es.cifpcm.data.MoviesDAO;
import es.cifpcm.data.MoviesDAOImpl;
import es.cifpcm.model.Movies;
import es.cifpcm.utlis.ValidationForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Ramirez
 */
public class MovieControllerServlet extends HttpServlet {

  private final org.slf4j.Logger logger = LoggerFactory.getLogger(MovieControllerServlet.class);

  MoviesDAO moviesDAO;

  @Override
  public void init() {
    moviesDAO = new MoviesDAOImpl();
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet MovieControllerServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet MovieControllerServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    if (ValidationForm.isNullOrBlank(request.getParameter("titulo"))) {
      String messageErrorValidate = "";
      messageErrorValidate = "El titulo no puede estar vacio";
      request.setAttribute("error", messageErrorValidate);
      request.getRequestDispatcher("newMovie.jsp").forward(request, response);
      messageErrorValidate = "";
    } else {      
      String titulo = request.getParameter("titulo");
      int idCategoria = Integer.parseInt(request.getParameter("categorias"));
      try {
        moviesDAO.insert(new Movies(0, idCategoria, titulo));
         request.getRequestDispatcher("success.jsp").forward(request, response);
      } catch (SQLException ex) {
        logger.error(MovieControllerServlet.class.getName() + " " + ex.getMessage());
        request.getRequestDispatcher("error.jsp").forward(request, response);
      } 
    }

  }

}
