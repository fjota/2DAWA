<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome JSP Page</title>
  </head>
  <body>
    <h1>Bienvenido</h1>
    <p>
      Son las <%= (new java.util.Date().getHours()) %>:<%= (new java.util.Date().getMinutes()) %> horas del dia 
      <%= (new java.util.Date().getDate()) %> del <%= (new java.util.Date().getMonth()) %> de <%= (new java.util.GregorianCalendar().get(Calendar.YEAR)) %>
    </p>
    </body>
  </html>
