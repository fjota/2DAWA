<%-- 
    Document   : LoginSuccess
    Created on : 16-nov-2018, 9:10:14
    Author     : Josué Ramírez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="loginBean" class="es.cifpcm.model.Login" scope="request"/>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Use</title>
  </head>
  <body>
    <h1>Bienvenido <jsp:getProperty name="loginBean" property="login"/></h1>
  </body>
</html>
