<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Jib" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Jib</title>
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
        form {
            display: flex;
            flex-direction: column;
        }
        input[type="text"] {
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <% Jib store = (Jib) session.getAttribute("store"); %>
        <h1>Edit Jib</h1>
        <form action="addNewStoreServlet">
            Name: <input type="text" name="storeName" value="<%= store.getName() %>"><br/>
            Type: <input type="text" name="storeType" value="<%= store.getType() %>"><br/>
            Price: <input type="text" name="storePrice" value="<%= store.getPrice() %>"><br/>
            <input type="submit" value="Update">
        </form>
        <% session.removeAttribute("correct"); %>
    </div>
</body>
</html>
