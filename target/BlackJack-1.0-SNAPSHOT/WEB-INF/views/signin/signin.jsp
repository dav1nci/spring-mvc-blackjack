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
            <h2>Sign in</h2>
            <form class="form-horizontal" action="/signin" method="post">
                <div class="form-group">
                    <label class="control-label col-xs-3">Name</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" name="email" placeholder="Enter your email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Password</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" name="email" placeholder="Enter your password">
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