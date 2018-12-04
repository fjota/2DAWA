<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="ingredientes" class="es.cifpcm.data.IngredientesDAOImpl" scope="request"/>
<jsp:useBean id="tipoBases" class="es.cifpcm.data.TipoBasesDAOImpl" scope="request"/>
<!DOCTYPE html>
<html>
  <head>
    <title>Ordenar pizza</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <form action="pizzaOrden" method="POST">
      <fieldset>
        <legend>Pizzas</legend>        
        <label>Ingredientes: </label>
        <c:forEach items="${ingredientes.selectAll()}" var="ingrediente">
          <label>${ingrediente.getDescripcion()} </label>
          <input type="checkbox" name="ingredientes" value="${ingrediente.getIdIngrediente()}">
        </c:forEach>
        <br><br>
        <label>Tipo de Base </label>
        <select name="TipoBase">
          <c:forEach items="${tipoBases.selectAll()}" var="tipoBase">
            <option value="${tipoBase.getIdTipoBase()}">${tipoBase.getDescripcion()}</option>            
          </c:forEach>
        </select>
        <br>
        <button>Aceptar</button>
      </fieldset>

    </form>
  </body>
</html>

