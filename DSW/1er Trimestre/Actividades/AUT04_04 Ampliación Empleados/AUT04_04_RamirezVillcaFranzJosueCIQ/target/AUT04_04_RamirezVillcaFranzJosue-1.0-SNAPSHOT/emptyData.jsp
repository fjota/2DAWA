<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <title>Error Page</title>
  </head>
  <body>    
    <div>
      <h1>Oops!!</h1>
      ${requestScope.errorInput};
    </div>
  </body>
</html>
