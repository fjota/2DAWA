<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pedido completado correctamente</title>
  </head>
  <body>
    <h1>Pedido correcto: ${requestScope.order.getTotal()} euros</h1>
    <div>
      <p>Tipo de base: ${requestScope.tipoBase}</p> 
      <c:if test="${requestScope.ingredientes.isEmpty()}">
        <p>No ha seleccionado nigun ingrediente</p>
      </c:if>
      <c:if test="${!requestScope.ingredientes.isEmpty()}">
        <p>Ingredientes</p>
      <ol>
        <c:forEach items="${requestScope.ingredientes}" var="ingrediente">
          <li>${ingrediente}</li>                         
          </c:forEach>
      </ol>
      </c:if>
      
    </div>
  </body>
</html>
