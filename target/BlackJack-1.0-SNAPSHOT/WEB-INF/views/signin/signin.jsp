<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <style>
      <%@include file="../../../resources/css/bootstrap.min.css"%>
  </style>
  <title>Home</title>
</head>
<body>
<div>
    <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
    <div class="constructor">
        <div class="alert alert-success">
            <h2>Sign in</h2>
            <c:url value="/j_spring_security_check" var="loginUrl"/>
            <form class="form-horizontal" action="/signin" method="post">
                <div class="form-group">
                    <label class="control-label col-xs-3">Name</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" name="j_username" placeholder="Enter your email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Password</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" name="j_password" placeholder="Enter your password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <input type="submit" class="btn btn-primary" value="Sign up">
                        <input type="reset" class="btn btn-default" value="Clear form">
                    </div>
                </div>
                <div class="col-lg-offset-2 col-lg-10">
                    <h3>New here?</h3>
                    <a class="btn btn-success" data-toggle="modal" href="/signup">Sign up</a>
                </div>
            </form>
        </div>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>