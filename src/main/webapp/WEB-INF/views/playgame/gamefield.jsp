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
                    <a id="hit" class="btn btn-success" style="margin-left: 90px; padding: 10px 30px 10px 30px">Hit</a>
                    <a id="stand" class="btn btn-success" style="margin-left: 20px; padding: 10px 30px 10px 30px" >Stand</a>
                </div>

            </div>
            <div class="col-md-8">
                <div class="row" style="margin-top: 50px">
                    <div class="col-md-1">
                        <p>score</p><br>
                        <p id="scoreDealer"></p>
                    </div>
                    <div class="col-md-4">
                        <p>cards</p><br>
                        <p id="cardsDealer"></p>
                    </div>
                    <div class="col-md-7">
                        <p>other cards</p><br>
                        <p id="otherCardsDealer"></p>
                    </div>
                </div>
                <a id="start" class="btn btn-danger" style="margin-top: 200px">Start Game</a>
                <div class="row" style="margin-top: 120px">
                    <div class="col-md-1">
                        <p>score</p><br>
                        <p id="scorePlayer"></p>
                    </div>
                    <div class="col-md-4">
                        <p>cards</p><br>
                        <p id="cardsPlayer"></p>
                    </div>
                    <div class="col-md-7">
                        <p>other cards</p><br>
                        <p id="otherCardsPlayer"></p>
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
                hit();
            });
            $("#stand").click(function()
            {

            });
        });

        function resetFields()
        {
            $("#cardsDealer").text("");
            $("#scoreDealer").text("");
            $("#cardsPlayer").text("");
            $("#scorePlayer").text("");
            $("#otherCardsPlayer").text("");
            $("#otherCardsDealer").text("");
        }

        function startGame()
        {
            resetFields();
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
                    alert(e);
                },
                done : function(e) {
                    /*enableSearchButton(true);*/
                }
            })
        }

        function hit()
        {
            var request = {};
            var cardsPlayer = $("#cardsPlayer").text();
            request["scorePlayer"] = $("#scorePlayer").text();
            if (cardsPlayer.indexOf("A") != -1)
                request["isAce"] = 1;
            else
                request["isAce"] = 0;


            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/hit",
                data : JSON.stringify(request),
                dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    alert(JSON.stringify(data, null, 4));
                    afterHit(data);
                },
                error : function(e) {
                    alert("Error in hit");
                },
                done : function(e) {
                    alert("Done in hit");
                    /*enableSearchButton(true);*/
                }
            });
        }

        function afterHit(data)
        {
            $("#otherCardsPlayer").append(data.cards[0].value + " " + data.cards[0].lear + "\n");
            $("#scorePlayer").text(data.scorePlayer);
            if (data.win == -1)
                alert("You Loose");
        }

        function setStartHand(data)
        {
            $("#cardsDealer").text(data.cards[0].value + " " + data.cards[0].lear + "\n" + data.cards[1].value + " " + data.cards[1].lear);
            $("#scoreDealer").text(data.scoreDealer);
            $("#cardsPlayer").text(data.cards[2].value + " " + data.cards[2].lear + "\n" + data.cards[3].value + " " + data.cards[3].lear);
            $("#scorePlayer").text(data.scorePlayer);
            if (data.win == 1)
                alert("You WIN!!!!!");
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
