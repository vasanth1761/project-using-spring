<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/update" method="post">
<input type="text" name="name" placeholder="Name"><br><br>
<input type="email" name="email"placeholder="Email"><br><br> 
<input type="password"name="password" placeholder="password"><br><br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="updateid" value="<%= request.getParameter("updateid") %>">
<button type="submit">Update</button>
</form>
</body>
</html>