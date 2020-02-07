<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is user detail page</h1>
<h3>Name=<%= request.getAttribute("name") %></h3>
<h3>Email=<%= request.getAttribute("email") %></h3>
</body>
</html>