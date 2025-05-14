<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #87ceeb 0%, #7f8c8d 100%);
            margin: 0;
            padding: 0;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .logout-btn {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 10px 18px;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
        }

        .logout-btn:hover {
            background-color: #c0392b;
        }

        .container {
            text-align: center;
            margin-top: 100px;
            color: #2c3e50;
        }

        .welcome-msg {
            font-size: 28px;
            margin-bottom: 30px;
        }

        .data-btn {
            padding: 12px 25px;
            font-size: 16px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        .data-btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

    <div class="header">
        <div><h2>Home Page</h2></div>
        <form method="post" action="logout">
        
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <div class="container">
        <div class="welcome-msg">Welcome to the Dashboard!</div>

            <a href="list"><button class="data-btn" type="submit">View Data List</button></a>
    </div>

</body>
</html>
