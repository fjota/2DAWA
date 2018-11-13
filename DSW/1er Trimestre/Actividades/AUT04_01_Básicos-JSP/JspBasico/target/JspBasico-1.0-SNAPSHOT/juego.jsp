<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Juego JSP Page</title>
  </head>
  <body>
    <%! String mensaje = ""; %>
    
    <%! Random rnd = new Random(); %>
    <%! int number = 0; %>
    <%= number = rnd.nextInt(2)%>

    <%! String dinero = ""; %>
    <%! String eleccion = ""; %>
    <%= dinero = request.getParameter("dinero")%>
    <%= eleccion = request.getParameter("eleccion")%>
    
    <% if (Integer.parseInt(eleccion) == number) { %>
    <% mensaje = "Has ganado"; } %>
    
  </body>
</html>
