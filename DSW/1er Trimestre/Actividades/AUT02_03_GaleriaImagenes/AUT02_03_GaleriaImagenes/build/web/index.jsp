<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Galeria de Imagenes</title>
  </head>
  <body>
    
    <h1>Subir Imagenes</h1>
    <form method="POST" action="ImageManagerServlet" enctype="multipart/form-data">
      Selecciona la imagen a subir: <input type="file" name="uploadFile" />
      <input type="submit" value="Subir" />
    </form>
    
  </body>
</html>
