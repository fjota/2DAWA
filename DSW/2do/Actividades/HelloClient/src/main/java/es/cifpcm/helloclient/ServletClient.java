package es.cifpcm.helloclient;

import es.cifpcm.helloclient.web.EchoService;
import es.cifpcm.helloclient.web.EchoService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josué Ramírez
 */
public class ServletClient extends HttpServlet {
 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    EchoService_Service echoSrvProxy = new EchoService_Service();
    EchoService echoService = echoSrvProxy.getEchoServicePort();
    String reply = echoService.hello("Hola mundo");
    int doble = echoService.doble(8);
    
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ServletClient</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Este servicio es de Josué  " + reply + "</h1>");
      out.println("<h1>Este servicio es   " + doble + "</h1>");
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
    processRequest(request, response);
  }
  
}
