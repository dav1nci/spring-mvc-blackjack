<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function()

        {
            $("button").click(function()
            {
                $.get("/ajaxdemo", function(data, status)
                {
                    alert("Data: " + data + "\nStatus: " + status);
                })
            })
        });
    </script>
    <title>Game</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <img src="../../../resources/images/cards/deck.jpg">
                <div class="row" style="margin-top: 30px">
                    <a class="btn btn-success" style="margin-left: 90px; padding: 10px 30px 10px 30px" href="+">Hit</a>
                    <a class="btn btn-success" style="margin-left: 20px; padding: 10px 30px 10px 30px" href="+">Stand</a>
                </div>

            </div>
            <div class="col-md-8">
                <div class="row" style="margin-top: 50px">
                    <div class="col-md-1">
                        <p>score</p>
                    </div>
                    <div class="col-md-4">
                        <p>cards</p>
                    </div>
                    <div class="col-md-7">
                        <p>other cards</p>
                    </div>
                </div>
                <a class="btn btn-danger" style="margin-top: 200px">Start Game</a>
                <div class="row" style="margin-top: 120px">
                    <div class="col-md-1">
                        <p>score</p>
                    </div>
                    <div class="col-md-4">
                        <p>cards</p>
                    </div>
                    <div class="col-md-7">
                        <p>other cards</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


<div class="bottom-bar">
    <div class="bottombar-inner">
        <div class="container">
            <ul class="nav">
                <li><a href="#">Link 1</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
