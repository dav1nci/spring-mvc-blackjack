<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%--<%@include file="../../../resources/css/bootstrap.min.css"%>--%>
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Black Jack</h1>
        <div class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <%--<a class="navbar-brand" href="http://127.0.0.1:8080/Manchkin/ChooseContent?page=home"></a>--%>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li><a href="/rules">Rules</a></li>
                        <li><a href="/secrets">Secrets</a></li>
                        <li><a href="/forums">Forums</a></li>
                        <li><a href="/faq">FAQ</a></li>
                    </ul>
                    <div class="pull-right">
                        <a class="btn btn-success" data-toggle="modal" href="/signin">Sign in</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
