<%-- 
    Document   : index
    Created on : 09-oct-2018, 9:50:54
    Author     : Josué Ramírez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
      Select file to upload: <input type="file" name="uploadFile" />
      <input type="submit" value="Upload" />
    </form>
  </body>
</html>
