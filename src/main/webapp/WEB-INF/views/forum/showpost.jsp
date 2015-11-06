<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <h1>Theme</h1>
    <h3>${post.title}</h3>
    <h1>Body</h1>
    <p>${post.body}</p>
  </div>
</div>
<div>
  <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
