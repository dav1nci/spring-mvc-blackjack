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
        <div class="jumbotron" style="margin-top: 20px;">
            <h1>Devcolibri.com</h1>
            <p class="lead">
                Devcolibri - это сервис предоставляющий всем желающим возможность обучаться программированию.
            </p>
            <sec:authorize access="!isAuthenticated()">
                <p><a class="btn btn-lg btn-success" href="/signin" > Войти</a></p>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username" /></p>
                <p><a class="btn btn-lg btn-danger" href="/signout" role="button">Выйти</a></p>

            </sec:authorize>
        </div>
        <%--<c:if test="${!empty content}">
            <table class="data">
                <tr>
                    <th><spring:message code="label.firstname" /></th>
                    <th><spring:message code="label.email" /></th>
                    <th><spring:message code="label.telephone" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${content}" var="row">
                    <p>${row.content}</p>
                </c:forEach>
            ${content.name}
        </c:if>--%>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
