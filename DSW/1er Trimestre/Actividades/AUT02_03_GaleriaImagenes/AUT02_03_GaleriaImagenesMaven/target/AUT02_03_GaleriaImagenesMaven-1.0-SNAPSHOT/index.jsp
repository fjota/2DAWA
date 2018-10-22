<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Subir Imagenes</h1>
    <form method="POST" action="ImageManagerServlet" enctype="multipart/form-data">
      Selecciona la imagen a subir: <input type="file" name="uploadFile" />
      <input type="submit" value="Subir" />
    </form>
  </body>
</html>
