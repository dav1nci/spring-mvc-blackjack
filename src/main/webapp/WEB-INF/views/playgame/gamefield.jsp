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
    <title>Game</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <img src="../../../resources/images/cards/deck.jpg">
                <div class="row" style="margin-top: 30px">
                    <a id="hit" class="btn btn-success" style="margin-left: 90px; padding: 10px 30px 10px 30px" href="+">Hit</a>
                    <a id="stand" class="btn btn-success" style="margin-left: 20px; padding: 10px 30px 10px 30px" href="+">Stand</a>
                </div>

            </div>
            <div class="col-md-8">
                <div class="row" style="margin-top: 50px">
                    <div class="col-md-1">
                        <p id="scoreDealer"></p>
                    </div>
                    <div class="col-md-4">
                        <p>cards</p>
                    </div>
                    <div class="col-md-7">
                        <p>other cards</p>
                    </div>
                </div>
                <a id="start" class="btn btn-danger" style="margin-top: 200px">Start Game</a>
                <div class="row" style="margin-top: 120px">
                    <div class="col-md-1">
                        <p id="scorePlayer">score</p>
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
    <script type="text/javascript">
        $(document).ready(function() {
            $("#start").click(function()
            {
                startGame();
            });
            $("#hit").click(function()
            {

            });
            $("#stand").click(function()
            {

            });
        });

        function startGame()
        {
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/start",
                data : JSON.stringify("start"),
                dataType : 'json',
                timeout : 100000,
                success: function(data){
                    setStartHand(data)
                },
                error : function(e) {
                    display(e);
                },
                done : function(e) {
                    /*enableSearchButton(true);*/
                }
            })
        }

        function setStartHand(data)
        {
            $(data).each(function()
            {
                $("#scoreDealer").text(this.lear);

            });
        }

        function searchViaAjax() {

            var search = {};
            search["someData"] = "Some Data";

            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/show",
                data : JSON.stringify(search),
                dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    display(data);
                },
                error : function(e) {
                    display(e);
                },
                done : function(e) {
                    /*enableSearchButton(true);*/
                }
            });

        }

        function hideButton() {
            $("#showContent").hide();
        }

        function display(data) {
            var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
            showForum(data);
        }
    </script>
    <script type="text/javascript">
        function showForum(data)
        {
            var row = "<tr><td><a href='/forum/{0}'>{1}</a></td><td>{2}</td><td>{3}</td></tr>";
            $(data).each(function()
            {
                $("#table-body").append(row.format(this.id, this.title, this.author, this.date));

            });
        }

        String.prototype.format = function() {
            var args = arguments;
            return this.replace(/{(\d+)}/g, function(match, number) {
                return typeof args[number] != 'undefined'
                        ? args[number]
                        : match
                        ;
            });
        };
    </script>
</body>
</html>
