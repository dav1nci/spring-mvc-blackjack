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
    <%@include file="../../../resources/css/mystyle.css"%>
  </style>
  <title>Home</title>
</head>
<body>
<div>
  <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
  <h1>${post.title}</h1>
</div>
    <div class="container">
      <div class="row">
          <div class="col-md-3">
            <h4>${post.author}</h4>
            <p>${post.date}</p>
          </div>
          <div class="col-md-7 col-border">
            <p>${post.body}</p>
          </div>
          <div class="col-md-2 col-border">
            <p>This is place for likes / unlikes</p>
          </div>
      </div>
    </div>

<c:forEach items="${post.comments}" var="comment">
  <div class="container">
    <div class="row">
      <div class="my-row">
        <div class="col-md-3">
          <h4>${comment.author}</h4>
          <p>${comment.date}</p>
        </div>
        <div class="col-md-7 col-border">
          <p>${comment.body}</p>
        </div>
        <div class="col-md-2 col-border">
          <p>This is place for likes / unlikes</p>
        </div>
      </div>
    </div>
  </div>
</c:forEach>

    <div class="container">
        <div class="my-row"> </div>
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <form class="form-signin" action="/forum/${post.id}/comment" method="post">
                    <fieldset>
                        <textarea rows="7" class="form-control" name="body" placeholder="Enter your comment"></textarea>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Add comment for user</button>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <a class="btn btn-lg btn-primary btn-block" href="/signin">Add comment for anon</a>
                        </sec:authorize>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
