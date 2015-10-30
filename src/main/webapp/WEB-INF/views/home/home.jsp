<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <%--<c:if test="${!empty content}">
            <table class="data">
                <tr>
                    <th><spring:message code="label.firstname" /></th>
                    <th><spring:message code="label.email" /></th>
                    <th><spring:message code="label.telephone" /></th>
                    <th>&nbsp;</th>
                </tr>--%>
                <c:forEach items="${content}" var="row">
                    <p>${row.content}</p>
                </c:forEach>
       <%-- </c:if>--%>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
