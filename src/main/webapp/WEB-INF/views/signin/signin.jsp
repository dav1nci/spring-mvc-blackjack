<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
  <style>
      <%@include file="../../../resources/css/bootstrap.min.css"%>
      <%--<%@include file="../../../resources/css/mystyle.css"%>--%>
  </style>

  <title>Home</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <form class="form-signin" action="/signin" method="post">
                <fieldset>
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <%--<div th:if="${param.error}" class="alert alert-error">
                        Invalid username and password.
                    </div>
                    <div th:if="${param.logout}" class="alert alert-success">
                        You have been logged out.
                    </div>--%>
                    <label for="email" class="sr-only">Email address</label>
                    <input type="email" id="email" class="form-control" name = "email" placeholder="Email address">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" class="form-control" name = "password" placeholder="Password" >
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    <h3>New Here?</h3>
                    <a href="/signup" class="btn btn-lg btn-primary btn-block" >Sign up</a>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>