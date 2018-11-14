<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Juego JSP Page</title>
  </head>
  <body>        
    <%! Random rnd = new Random(); %>
    <%! int number = rnd.nextInt(2); %>

    <% 
      String  dinero = request.getParameter("dinero");
      String eleccion = request.getParameter("eleccion"); 
    %>


    <% 
      if (Integer.parseInt(eleccion) == number) {
        out.println("<p>Has ganado!!: " + (Integer.parseInt(dinero) * 2) + "</p>");
        out.println("<img src='https://misionfortuna.files.wordpress.com/2013/11/dinero.jpg' height='200' width='200' />");
      } else {
        out.println("<p>Has perdido: " + (Integer.parseInt(dinero) * 2) + "</p>");
        out.println("<img src='http://slowinver.com/wp-content/uploads/2014/11/arruinado-en-inversiones.jpg' height='200' width='200' />");
      }    
    %>

  </body>
</html>
