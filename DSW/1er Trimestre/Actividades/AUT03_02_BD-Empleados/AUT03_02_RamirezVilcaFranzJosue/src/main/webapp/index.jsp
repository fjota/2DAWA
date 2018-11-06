<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aplicacion Empleados - Buscador</title>
  </head>
  <body>

    <h1>Buscador de empleados</h1>
    <form action="buscadorempleados" method="GET">
      <fieldset>
        <legend>Datos empleado</legend>
        <label for="txtNombre">Nombre</label>
        <input id="txtNombre" type="text" name="nameToSearch"/>
        <input type="submit" value="Enviar"/>
      </fieldset>
    </form>

  </body>
</html>
