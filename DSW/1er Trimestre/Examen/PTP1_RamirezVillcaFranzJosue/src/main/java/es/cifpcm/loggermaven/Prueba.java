package es.cifpcm.loggermaven;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Bomber
 */
public class Prueba extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(Prueba.class);
    
 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    logger.info("Entrando en el ProcessRequest: INFO " + request.getContextPath());
    logger.debug("Entrando en el ProcessRequest: DEBUG " + request.getContextPath());
    
    logger.warn("Entrando en el ProcessRequest: WARN " + request.getContextPath());
    logger.error("Entrando en el ProcessRequest: ERROR " + request.getContextPath());
    logger.info("DADS en el ProcessRequest: INFO " + request.getContextPath());
    logger.debug("EntrADSDASando en el ProcessRequest: DEBUG " + request.getContextPath());
    
    logger.warn("EntraDASADSndo en el ProcessRequest: WARN " + request.getContextPath());
    logger.error("EntraADSASDndo en el ProcessRequest: ERROR " + request.getContextPath());
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Prueba</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Prueba at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
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
    processRequest(request, response);
  }

}
