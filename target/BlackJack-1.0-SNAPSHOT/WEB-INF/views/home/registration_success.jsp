<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        <%@include file='../../../resources/css/bootstrap.min.css' %>
    </style>
    <title></title>
</head>
<body>

<div class="jumbotron">
    <h1>Registration success!!</h1>
    <h2>Your welcome ${greetingMessage}!</h2>
    <h3>Name: ${userEntity.userName}</h3>
    <h3>email: ${userEntity.email}</h3>
    <h3>Message: ${userEntity.message}</h3>
    <h3>Date: ${userEntity.date}</h3>
    <h3>Skills: ${userEntity.skills}</h3>
    <p><a class="btn btn-lg btn-success" href="/registration" role="button">Home</a></p>
</div>
</body>
</html>
