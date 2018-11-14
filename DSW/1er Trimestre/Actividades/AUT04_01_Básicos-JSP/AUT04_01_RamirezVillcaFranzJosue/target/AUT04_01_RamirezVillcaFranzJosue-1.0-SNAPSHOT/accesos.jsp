<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Accesos JSP Page</title>
  </head>
  <body>
    <%! int count= 1; %>   
    <%      
      if (count == 10) {
        out.println("<p>Ha entrado por decima vez, eres un afortunado: </p>");
      } else {
        out.println("<p>has entrado: " + count++  + " veces </p>"); 
      }    
    %>    
  </body>
</html>
