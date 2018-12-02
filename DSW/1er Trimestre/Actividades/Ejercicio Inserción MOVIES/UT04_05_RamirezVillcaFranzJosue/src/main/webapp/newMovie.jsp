<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="categoriesList" class="es.cifpcm.data.CategoriesDAOImpl" scope="request"/>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nueva pelicula</title>
  </head>
  <body>
    <h1>Nueva peliculas</h1>
    
    <c:if test="${requestScope.error.length() > 0}">
      <p>El titulo no puede estar vacio</p>
    </c:if>
    <form action="movieController" method="POST">
      <fieldset>
        <legend>Datos de la pelicula</legend>
        <label for="titulo">Titulo</label>
        <input id="titulo" name="titulo" type="text"/>
        <label for="categoria">Categoria</label>
        <select name="categorias">
          <c:forEach items="${categoriesList.selectAll()}" var="category">
            <option value="${category.getIdCategory()}">${category.getCategory()}</option>           
          </c:forEach>          
        </select>
      </fieldset>
      <input type="submit" value="Enviar"/>
    </form>
  </body>
</html>
