<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aplicacion Empleados - Buscador MVC</title>
  </head>
  <body>

    <h1>Buscador de empleados</h1>
    <form action="EmployeeController" method="POST">
      <fieldset>
        <legend>Configurar Servlet</legend>
        <label for="tamanoPgina">Tamaño pagina: </label>
        <input id="tamanoPgina" type="text" name="tamanoPgina"/>
        <input type="submit" value="Enviar"/>
      </fieldset>
    </form>
    <br>
    <form action="EmployeeController" method="GET">      
      <fieldset>
        <legend>Datos empleado</legend>
        <label for="txtNombre">Nombre: </label>
        <input id="txtNombre" type="text" name="firstName"/>
        <br><br>
        <label for="txtApellido">Apellido: </label>        
        <input id="txtApellido" type="text" name="lastName"/>
        <br><br>
        <input type="submit" value="Enviar"/>
      </fieldset>
    </form>

  </body>
</html>
