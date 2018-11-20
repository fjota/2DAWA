<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <%--Table employee searched
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
      %> --%>      
      
      <%--Table employees list--%>      
      <h1>Lista Empleados</h1>      
      <table>
        <tr> 
          <th>Nº</th>
          <th>Nombre</th>
          <th>Fecha Namcimiento</th>
          <th>Fecha contrato</th>
          <th>   ---   </th> 
        </tr>             
        <c:forEach items="${employeeList}" var="employee">
          <tr>
            <td> ${employee.getEmp_no()}</td>
            <td> ${employee.getFirst_name()}</td>
            <td> ${employee.getBirth_date()}</td>
            <td> ${employee.getHire_date()}</td>  
            <td> <a href="${pageContext.request.contextPath}/verNominas?empNo=${employee.getEmp_no()}">Ver nominas</a> </td>
          </tr>               
        </c:forEach>
      </table>
      <form method='POST' action='EmployeeController'>
        <input type='submit' value='Primero' name='boton'/>
        <input type='submit' value='Anterior' name='boton'/>
        <input type='submit' value='Siguiente' name='boton'/>
        <input type='submit' value='Ultimo' name='boton'/>
      </form>  
</body>
</html>
