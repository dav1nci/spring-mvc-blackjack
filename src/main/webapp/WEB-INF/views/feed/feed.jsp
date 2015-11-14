<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${feed}" var="unit">
  <div>
    <h2>${unit.title}</h2>
    <h2>${unit.link}</h2>
  </div>
</c:forEach>
</body>
</html>
