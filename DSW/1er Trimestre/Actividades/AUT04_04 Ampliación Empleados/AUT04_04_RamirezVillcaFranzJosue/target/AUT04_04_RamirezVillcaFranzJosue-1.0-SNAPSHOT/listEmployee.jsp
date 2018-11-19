<%@page import="java.util.List"%>
<%@page import="es.cifpcm.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>    
    <%      
      List<Employee> listEmployee = (List<Employee>) request.getAttribute("employeeList");
      out.println("<h1>Esta Buscando a: " + listEmployee.get(0).getFirst_name() + " " + listEmployee.get(0).getLast_name()  +"</h1>");
      out.println("<table border='1'>");
      out.println("<tr> <th>Nº</th><th>Nombre</th><th>Fecha Namcimiento</th><th>Fecha contrato</th> </tr>");
      for (Employee employee : listEmployee) {   
        out.println("<tr>");
        out.println("<td>" + employee.getEmp_no() + "</td>");
        out.println("<td>" + employee.getFirst_name() + " " + employee.getLast_name() + "</td>");
        out.println("<td>" + employee.getBirth_date() + "</td>");
        out.println("<td>" + employee.getHire_date() + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
    %>
  </body>
</html>
