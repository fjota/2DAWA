<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aplicacion Empleados - Buscador MVC</title>
  </head>
  <body>

    <h1>Buscador de empleados</h1>    
    <form action="EmployeeController" method="GET">      
      <fieldset>
        <legend>Configurar Servlet</legend>
        <label for="tamanoPgina">Tamaño pagina: </label>
        <c:if test="${!empty cookie.pageSize.value}">
          <input id="tamanoPgina" type="text" name="tamanoPgina" value="${cookie.pageSize.value}"/> 
          <span>Cookie value</span>
        </c:if>
        <c:if test="${empty cookie.pageSize.value}">
          <input id="tamanoPgina" type="text" name="tamanoPgina""/>
        </c:if>           
      </fieldset>
      <fieldset>
        <legend>Datos empleado</legend>
        <label for="txtNombre">Nombre: </label>
        <input id="txtNombre" type="text" name="firstName"/>
        <br><br>
        <label for="txtApellido">Apellido: </label>        
        <input id="txtApellido" type="text" name="lastName"/>
        <br><br>        
      </fieldset>
      <br>            
      <input type="submit" value="Enviar" name="searchedButton"/>

    </form>

  </body>
</html>
