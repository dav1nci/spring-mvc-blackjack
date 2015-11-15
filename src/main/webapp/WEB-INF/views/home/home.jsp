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
    <script type="text/javascript" src="../../../resources/js/jquery-2.1.4.js">
        
    </script>
    <title>Home</title>
</head>
<body>
<div>
    <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
    <div class="constructor">
        <div class="jumbotron" style="margin-top: 20px;">
            <img src="../../../resources/images/1.jpg" alt="black jack" id="myimage" onclick="changeImage()" height="100px" width="100px">
            <p id="demo">Hello World!</p>
            <button type="button" onclick="document.getElementById('demo').innerHTML = 'Changed string'">Click me</button>
        </div>

                <c:forEach items="${content}" var="row">
                    <p>${row.content}</p>
                </c:forEach>

    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
