<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.Employees" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>
<%Employees es= (Employees)request.getAttribute("e"); %>
<form action="save" method="post">
    <label for="id">User ID:</label><br>
    <input type="text" id="id" name="id" value="<%=es.getId() %>" readonly><br><br>

    <label for="name">Username:</label><br>
    <input type="text" id="name" name="name" value="<%=es.getUsername() %>" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" value="<%=es.getEmail() %>" required><br><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" value="<%=es.getPassword() %>" required><br><br>

    <input type="submit" value="Save">
</form>

</body>
</html>
