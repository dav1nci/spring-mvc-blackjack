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
        <div class="container">
            <%--<h2>Hover Rows</h2>--%>
            <sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')">
                <a class="btn btn-success" data-toggle="modal" href="/signup">Add new theme</a>
            </sec:authorize>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Date</th>
                    <th>Rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.title}</td>
                        <td>${post.author}</td>
                        <td>${post.date}</td>
                        <td>${post.rating}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <%--<div class="form-horizontal">
            <sec:authorize access="!isAuthenticated()">
                <a class="btn btn-success" data-toggle="modal" href="/signin">Sign in</a>
            </sec:authorize>
            <c:forEach items="${posts}" var="post">
                <div class="form-group">
                    <label class="control-label col-xs-3">${post.title}</label>
                    <label class="control-label col-xs-3">${post.author}</label>
                    <label class="control-label col-xs-3">${post.date}</label>
                    <label class="control-label col-xs-3">${post.rating}</label>
                </div>
            </c:forEach>
        </div>--%>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>