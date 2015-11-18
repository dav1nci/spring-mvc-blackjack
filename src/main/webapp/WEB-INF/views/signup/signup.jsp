<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script>
        function checkForm()
        {
            var password, confirmPassword, errorString;
            password = document.getElementById("password");
            confirmPassword = document.getElementById("confirmPassword");
            if (password != confirmPassword)
            {
                errorString = "Password must be the same";
                document.getElementById("confirmError").innerHTML = errorString;
            }
        }
    </script>
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
      <form class="form-horizontal" action="/signup" onsubmit="return checkForm()" method="post">
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
            <input type="email" class="form-control" name="email" placeholder="Enter your e-mail">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Password</label>
          <div class="col-xs-9">
              <input type="password" id = "password" class="form-control" name="password" placeholder="Enter your password">
          </div>
        </div>
          <div class="form-group">
              <label class="control-label col-xs-3">Confirm password</label>
              <div class="col-xs-9">
                  <p id="confirmError" class="control-label col-xs-3"></p>
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