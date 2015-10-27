<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <h2>Sign up</h2>
      <form class="form-horizontal" action="/signup" method="post">
        <div class="form-group">
          <label class="control-label col-xs-3">Name</label>
          <div class="col-xs-9">
            <input type="text" class="form-control" name="name" placeholder="Enter your name">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Surname</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" name="surname" placeholder="Enter your surname">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">E-mail</label>
          <div class="col-xs-9">
            <input type="text" class="form-control" name="email" placeholder="Enter your e-mail">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Password</label>
          <div class="col-xs-9">
              <input type="password" class="form-control" name="password" placeholder="Enter your password">
          </div>
        </div>
          <div class="form-group">
              <label class="control-label col-xs-3">Confirm password</label>
              <div class="col-xs-9">
                  <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm your password">
              </div>
          </div>
        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Sign up">
            <input type="reset" class="btn btn-default" value="Clear form">
          </div>
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