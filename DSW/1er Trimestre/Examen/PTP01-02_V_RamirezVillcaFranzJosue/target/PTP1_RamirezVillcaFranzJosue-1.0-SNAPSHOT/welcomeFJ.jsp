<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario Astro</title>
  </head>
  <body>
    <form action="misastros" method="GET">
      <h3>Elegir entre una de las opciones: </h3>
      <label for="nada">Nada</label>
      <input id="nada" type="radio" name="universo" value="nada"><br><br>
      <label for="planeta">Planeta</label>
      <input id="planeta" type="radio" name="universo" value="pl"><br><br>
      <label for="galaxia">Galaxia</label>
      <input id="galaxia" type="radio" name="universo" value="ga"><br><br>
      <label for="satelite">Satelite</label>
      <input id="satelite" type="radio" name="universo" value="sa"><br><br>
      <input type="submit" value="Enviar">
    </form>
  </body>
</html>
