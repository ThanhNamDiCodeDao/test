<%-- 
    Document   : header
    Created on : Dec 13, 2023, 8:45:09 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruit Shop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/CSS/main.css">
    <script>

            function getNumberOfProdutct(index) {
                var block = document.getElementById('numberOfProdutctBlock');
                console.log(block);
                var id = document.getElementById("index");
                id.setAttribute("value",index+1);
                block.style.display = (block.style.display === 'none' || block.style.display === '') ? 'block' : 'none';
                console.log(block.style.display);
                
            }
        </script>   
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Fruit Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link border" href="http://localhost:8080/FruitShop/login.jsp">Login</a>
                </li>
            </ul>
        </div>
    </nav>
