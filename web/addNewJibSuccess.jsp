<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Jib" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jib Added Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 300px;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Jib added successfully!</h1>
        <% Jib jib = (Jib) session.getAttribute("jib"); %>
        <p>Name: <%= jib.getName() %></p>
        <p>Type: <%= jib.getType() %></p>
        <p>Price: <%= jib.getPrice() %></p>
        <a href="addNewJib.html">Add another Jib</a>
    </div>
</body>
</html>
