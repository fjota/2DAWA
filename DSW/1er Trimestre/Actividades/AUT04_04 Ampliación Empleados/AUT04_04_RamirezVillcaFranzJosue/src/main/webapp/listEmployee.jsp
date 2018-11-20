<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<jsp:useBean id="employeeBean" class="es.cifpcm.model.Employee" scope="request"/>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
    <title>List Employees</title>
  </head>
  <body>           
    <%--Table employees searched--%>       
    <h1>Esta buscando a: <jsp:getProperty name="employeeBean" property="first_name"/> <jsp:getProperty name="employeeBean" property="last_name"/></h1> 
    <table>
      <tr> 
        <th>Nº</th>
        <th>Fecha Cumpleaños</th>
        <th>Prmer nombre</th>
        <th>Segundo nombre</th>
        <th>Genero</th>
        <th>Fecha contrato</th>
      </tr>  
      <tr>
        <td> <jsp:getProperty name="employeeBean" property="emp_no"/> </td>
        <td> <jsp:getProperty name="employeeBean" property="birth_date"/> </td>
        <td> <jsp:getProperty name="employeeBean" property="first_name"/> </td>
        <td> <jsp:getProperty name="employeeBean" property="last_name"/> </td>
        <td> <jsp:getProperty name="employeeBean" property="gender"/> </td>
        <td> <jsp:getProperty name="employeeBean" property="hire_date"/> </td>   
      </tr>                     
    </table>


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
