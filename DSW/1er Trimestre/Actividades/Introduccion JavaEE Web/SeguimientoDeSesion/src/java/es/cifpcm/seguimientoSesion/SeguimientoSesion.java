package es.cifpcm.seguimientoSesion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josué Ramírez
 */
public class SeguimientoSesion extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // Create a session object if it is already not created.
    HttpSession session = request.getSession(true);

    // Get session creation time.
    Date createTime = new Date(session.getCreationTime());

    // Get last access time of this web page.
    Date lastAccessTime = new Date(session.getLastAccessedTime());
    String title = "Welcome Back to my website";
    int visitCount = 0;
    String visitCountKey = "visitCount";
    String userIDKey = "userID";
    String userID = "ABCD";
    // Check if this is new comer on your web page.
    if (session.isNew()) {
      title = "Welcome to my website";
      session.setAttribute(userIDKey, userID);
    } else {
      visitCount = Integer.parseInt(session.getAttribute(visitCountKey).toString());
      visitCount = visitCount + 1;
      userID = session.getAttribute(userIDKey).toString();
    }
    session.setAttribute(visitCountKey, visitCount);
    // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType
            = "<!doctype html public \"-//w3c//dtd html 4.0 "
            + "transitional//en\">";
    out.println(docType
            + "<html>"
            + "<head><title>" + title + "</title></head>"
            + "<body bgcolor = \"#f0f0f0\">"
            + "<h1 align = \"center\">" + title + "</h1>"
            + "<h2 align = \"center\">Session Infomation</h2>"
            + "<table border = \"1\" align = \"center\">"
            + "<th>Session info</th><th>value</th></tr>"
            + "<tr>"
            + "<td>id</td>"
            + "<td>" + session.getId() + "</td></tr>"
            + "<tr>"
            + "<td>Creation Time</td>"
            + "<td>" + createTime + " </td>"
            + "</tr>"
            + "tr>"
            + "<td>Time of Last Access</td>"
            + "<td>" + lastAccessTime + " </td>"
            + "</tr>"
            + "<tr>"
            + "<td>User ID</td>"
            + "<td>" + userID + " </td>"
            + "</tr>"
            + "<tr>"
            + "<td>Number of visits</td>"
            + "<td>" + visitCount + "</td>"
            + "</tr>"
            + "</table> "
            + "</body>"
            + "</html>"
    );

    out.close();

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    /*processRequest(request, response);*/
  }

}
