package es.cifpcm.logger.web.ServletA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServletA extends HttpServlet {
  
  private final Logger logger = LoggerFactory.getLogger(ServletA.class);
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    
    logger.info("Entrando en ProcessRequest de la app: {} " + request.getContextPath() + "ESTO INFORMA");
    
    logger.debug("Parametro mes: {} " + request.getParameter("mes") + "ESTO DEBUGEA");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ServletA</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet ServletA at " + request.getContextPath() + "</h1>");
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
