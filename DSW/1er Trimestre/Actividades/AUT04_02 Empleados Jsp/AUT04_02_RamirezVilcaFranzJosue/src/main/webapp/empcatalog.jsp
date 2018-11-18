<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
      td, th {
        border: 1px solid black;
        padding: .5em;
      }

      tr th {
        background-color: green;
        color: white;
      }

      a {
        text-decoration: none;
      }

    </style>
    <title>JSP Page</title>
  </head>
  <body>
    <%
      String name = request.getParameter("nameToSearch");
    %>

    <%
      int DEFAULT_PAGESIZE = 8;
      ResourceBundle rb = ResourceBundle.getBundle("empleados");
      String dbUrl = rb.getString("database.url");
      String dbUser = rb.getString("database.user");
      String dbPassword = rb.getString("database.password");
      int dbPageSize = rb.getString("database.pageSize") == null ? DEFAULT_PAGESIZE : Integer.parseInt(rb.getString("database.pageSize"));
      String driverClassName = rb.getString("database.driver");
      Class.forName(driverClassName);

      StringBuilder sb = new StringBuilder();
      Connection connection = null;
      PreparedStatement preparedStm = null;
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      String sql = "SELECT * FROM employees";
      preparedStm = connection.prepareStatement(sql);
      preparedStm.setMaxRows(dbPageSize);
      ResultSet rs = preparedStm.executeQuery();
      sb.append("<table>");
      sb.append("<tr> <th>Nombre</th><th>Fecha Nacimiento Nombre</th><th>Fecha Contrato</th> </tr>");
      while (rs.next()) {
        sb.append("<tr>");
        sb.append("<td>" + rs.getString(3) + " " + rs.getString(4) + "</td>");
        sb.append("<td>" + rs.getDate(2) + "</td>");
        sb.append("<td>" + rs.getDate(6) + "</td>");
        sb.append("</tr>");
      }
      sb.append("</table>");
      preparedStm.close();
      connection.close();

    %>
    <%=sb.toString()%>
  </body>
</html>
