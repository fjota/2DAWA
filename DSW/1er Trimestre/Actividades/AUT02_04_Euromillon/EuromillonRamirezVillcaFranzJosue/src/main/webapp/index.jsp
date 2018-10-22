<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>!Bienvenido a tu EuroMilon!</h1>
    <form action="resultados" method="POST">
      <h4>Introduce la combinación ganadora y pulsa el boton enviar</h4>             
      <label for="textoNumero1">Número 1</label>
      <input id="textoNumero1" name="numero" type="text" />
      <br><br>      
      <label for="textoNumero2">Número 2</label>
      <input id="textoNumero2" name="numero" type="text" />
      <br><br>
      <label for="textoNumero3">Número 3</label>
      <input id="textoNumero3" name="numero" type="text" />
      <br><br>
      <label for="textoNumero4">Número 4</label>
      <input id="textoNumero4" name="numero" type="text" />
      <br><br>
      <label for="textoNumero5">Número 5</label>
      <input id="textoNumero5" name="numero" type="text" />      
      <p>Ahora las estrellas:</p>      
      <label for="textoEstrella1">Estrella 1</label>
      <input id="textoEstrella1" name="estrella" type="text" />
      <br><br>
      <label for="textoEstrella2">Estrella 2</label>
      <input id="textoEstrella2" name="estrella" type="text" />
      <br><br>
      <input type="submit" value="Enviar"/>
      <input type="reset" value="Borrar"/>
      
    </form>
  </body>
</html>
