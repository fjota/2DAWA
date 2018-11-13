<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! int count = 1;%>
<%! int day = 3; %> 
<%! int day2 = 3;%> 
<%@page import="java.util.Enumeration"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Ejemplo 1</h1>
    Hello World!<br/>
    <%
      out.println("Your IP address is " + request.getRemoteAddr());
    %>

    <br><br><br>
    <h1>Ejemplo 2</h1>

    Ha entrado
    <%= count++%>
    <% if (count == 1) { %>
    vez<% } else { %>
    veces <% }%>

    <br><br><br>
    <h1>Ejemplo 3</h1>

    <% if (day == 1 | day == 7) { %>
    <p> Today is weekend</p>
    <% } else { %>
    <p> Today is not weekend</p>
    <% }%>

    <br><br><br>
    <h1>Ejemplo 4</h1>

    <%
      switch (day2) {
        case 0:
          out.println("It\'s Sunday.");
          break;
        case 1:
          out.println("It\'s Monday.");
          break;
        case 2:
          out.println("It\'s Tuesday.");
          break;
        case 3:
          out.println("It\'s Wednesday.");
          break;
        case 4:
          out.println("It\'s Thursday.");
          break;
        case 5:
          out.println("It\'s Friday.");
          break;
        default:
          out.println("It's Saturday.");
      }
    %>

    <br><br><br>
    <h1>Ejemplo 5</h1>

    <b>Http headers:</b><br/>
    <%-- primero --%>
    <%
      for (Enumeration<String> e = request.getHeaderNames();
              e.hasMoreElements();) {
        String header = e.nextElement();
        out.println(header + ": " + request.getHeader(header) + "<br/>");
      }
      String message = "Eso eso todo";
    %>
    <hr/>
    <%-- segundo --%>
    <%out.println(message);%>
    
  </body>
</html>
