<%@page import="java.util.List"%>
<%@page import="es.cifpcm.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
    <title>List Employees</title>
  </head>
  <body>   
    <%--Table employee searched--%>
    <%
      Employee employee = (Employee) request.getAttribute("employee");
      out.println("<h1>Esta Buscando a: " + employee.getFirst_name() + " " + employee.getLast_name() + "</h1>");
      out.println("<table border='1'>");
      out.println("<tr> <th>Numero Empleado</th><th>Fecha Cumpleaños</th><th>Primer Nombre</th><th>Segundo Nombre</th><th>Genero</th><th>Fecha Contrato</th> </tr>");
      out.println("<tr>");
      out.println("<td>" + employee.getEmp_no() + "</td>");
      out.println("<td>" + employee.getBirth_date() + "</td>");
      out.println("<td>" + employee.getFirst_name() + "</td>");
      out.println("<td>" + employee.getLast_name() + "</td>");
      out.println("<td>" + employee.getGender() + "</td>");
      out.println("<td>" + employee.getHire_date() + "</td>");
      out.println("</tr>");
      out.println("</table>");
    %>

    <%--Table employees list--%>
    <%
      List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
      out.println("<h1>Lista empleados</h1>");
      out.println("<table border='1'>");
      out.println("<tr> <th>Nº</th><th>Nombre</th><th>Fecha Namcimiento</th><th>Fecha contrato</th><th>   ---   </th> </tr>");
      for (Employee objEmployee : employeeList) {
        out.println("<tr>");
        out.println("<td>" + objEmployee.getEmp_no() + "</td>");
        out.println("<td>" + objEmployee.getFirst_name() + " " + objEmployee.getLast_name() + "</td>");
        out.println("<td>" + objEmployee.getBirth_date() + "</td>");
        out.println("<td>" + objEmployee.getHire_date() + "</td>");
        out.println("<td><a href='" + request.getContextPath() + "/verNominas?empNo=" + objEmployee.getEmp_no() + "'>Ver Nomina</a></td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<div>");
      out.println("<button><<</button><button><</button><button>></button><button>>></button>");
      out.println("</div>");
    %>
  </body>
</html>
