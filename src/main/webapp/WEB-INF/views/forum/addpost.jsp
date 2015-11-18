<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dav1nci
  Date: 06.11.15
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <title></title>
</head>
<body>
<div class="container">
  <div class="constructor">
    <div class="alert alert-success">
      <h2>CREATE NEW POST</h2>
      <form class="form-horizontal" action="/add" method="post">
        <div class="form-group">
          <label class="control-label col-xs-3">Title</label>
          <div class="col-xs-9">
            <input type="text" class="form-control" name="title" placeholder="Enter post title">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Body</label>
          <div class="col-xs-9">
            <input type="text" class="form-control" name="body" placeholder="Enter post body">
          </div>
        </div>
          <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Add Post">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
