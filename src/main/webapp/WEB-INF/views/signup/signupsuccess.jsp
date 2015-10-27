<%--
  Created by IntelliJ IDEA.
  User: dav1nci
  Date: 27.10.15
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    <%@include file="../../../resources/css/bootstrap.min.css"%>
  </style>
    <title>Success!</title>
</head>
<body>
<div class="container">
  <div class="constructor">
    <div class="jumbotron">
      <h1>Registration success!!</h1>
      <h2>Your welcome ${user.name}</h2>
      <h2>Your welcome ${user.surname}</h2>
      <h2>Your welcome ${user.email}</h2>
      <h2>Your welcome ${user.password}</h2>
      <h2>Your welcome ${confrimpass}</h2>
      <p><a class="btn btn-lg btn-success" href="/" role="button">Home</a></p>
    </div>
  </div>
</div>
</body>
</html>
