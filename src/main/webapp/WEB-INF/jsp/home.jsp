<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Spring MVC is running</h1>
  <h3>Team</h3>
  <ul>
      <%
        String[] name=(String[])request.getAttribute("names");
        for(String x:name){
      %>
        <li> <%=x%></li>
       <%} %>
  </ul>
</body>
</html>