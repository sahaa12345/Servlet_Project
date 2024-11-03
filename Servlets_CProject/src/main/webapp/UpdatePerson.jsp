<%@page import="com.jsp.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Person p=(Person)request.getAttribute("per"); %>
<form action="updateperson" method="post">
Id:<input type="number" name="id" placeholder="enter ur id" value="<%=p.getId()%>" readonly="readonly"><br><br>
Name:<input type="text" placeholder="enter ur name" name="name" value="<%=p.getName()%>"><br><br>
Age:<input type="number" placeholder="enter ur age" name="age" value="<%=p.getAge()%>"><br><br>
Email:<input type="email" placeholder="enter ur email" name="email" value="<%=p.getEmail()%>"><br><br>
Password:<input type="password" placeholder="enter ur password" name="password" value="<%=p.getPassword()%>"><br><br>
<input type="submit" value="Update"><br><br>
</form>
</body>
</html>