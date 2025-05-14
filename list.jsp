<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.web.Employees" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 40px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .btn {
            padding: 6px 12px;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
        }
        .btn-edit {
            background-color: #28a745;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<h2 align="center">User List</h2>

<%
    List<Employees> userList = (List<Employees>) request.getAttribute("list");
    if (userList != null && !userList.isEmpty()) {
%>
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <%
            for (Employees user : userList) 
            {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getPassword() %></td>
            <td>
                <a href="edit?id=<%= user.getId() %>" class="btn btn-edit">Edit</a>
                <a href="delete?id=<%= user.getId() %>" class="btn btn-delete" 
             onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
<% 
    } else { 
%>
    <p style="text-align:center; color: red;">No users found.</p>
<% 
    } 
%>

</body>
</html>
