<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div>
    <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container" style="min-height: 500px">
    <div class="starter-template">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Date</th>
                <th>Rating</th>
            </tr>
            </thead>
            <tbody id="table-body"></tbody>     <%--для будущег отображения постов форума--%>
        </table>
    </div>
    <div class="col-md-4 center-block">
        <button type="button" id="showContent" class="btn btn-primary btn-lg center-block">GET FORUM CONTENT WITH AJAX</button>
    </div>
    <div id="feedback">

    </div>
</div>

<script>
    $(document).ready(function() {
        $("#showContent").click(function() {
            hideButton();
            searchViaAjax();
        });

    });

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