<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Black Jack</h1>
        <div class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <%--<a class="navbar-brand" href="http://127.0.0.1:8080/Manchkin/ChooseContent?page=home"></a>--%>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a class="navbar-brand" href="/">Home</a></li>
                        <li><a class="navbar-brand" href="/rules">Rules</a></li>
                        <li><a class="navbar-brand" href="/rss">Feeds</a></li>
                        <li><a class="navbar-brand" href="/forum">Forums</a></li>
                        <li><a class="navbar-brand" href="/faq">FAQ</a></li>
                    </ul>
                    <div class="pull-right">
                        <%--<a href="/logout"/>">Logout</a>--%>
                        <sec:authorize access="!isAuthenticated()">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                                <li><a href="/signin"><span class="glyphicon glyphicon-log-in"></span> Sign in</a></li>
                            </ul>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a>Hello <sec:authentication property="principal.username"/>!</a></li>
                                <li><a href="/signout"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
                            </ul>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
