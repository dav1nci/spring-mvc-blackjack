<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Spring 4 MVC Ajax Hello World</a>
    </div>
  </div>
</nav>

<div class="container" style="min-height: 500px">

  <div class="starter-template">
    <h1>Search Form</h1>
    <br>



    <table class="table table-hover">
      <thead>
      <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Date</th>
        <th>Rating</th>
      </tr>
      </thead>
      <tbody id="table-body">
        <%--<tr>
          <td><a href="/forum/${post.id}">${post.title}</a></td>
          <td>${post.author}</td>
          <td>${post.date}</td>
          <td>
              <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
          </td>
        </tr>--%>
      </tbody>
    </table>

    <div id="feedback"></div>

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
    <form class="form-horizontal" id="search-form">
      <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label">Username</label>
        <div class="col-sm-10">
          <input type=text class="form-control" id="username">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" id="bth-search" class="btn btn-primary btn-lg">Search</button>
        </div>
      </div>
    </form>

  </div>

</div>

<div class="container">
</div>

<script>
  /*jQuery*/$(document).ready(function($) {

    $("#search-form").submit(function(event) {

      // Disble the search button
      enableSearchButton(false);

      // Prevent the form from submitting via the browser.
      event.preventDefault();

      searchViaAjax();

    });

  });

  function searchViaAjax() {

    var search = {};
    search["username"] = $("#username").val();

    $.ajax({
      type : "POST",
      contentType : "application/json",
      url : "/ajax",
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
        enableSearchButton(true);
      }
    });

  }

  function enableSearchButton(flag) {
    $("#btn-search").prop("disabled", flag);
  }

  function display(data) {
    var json = "<h4>Ajax Response</h4><pre>"
            + JSON.stringify(data, null, 4) + "</pre>";
    $('#feedback').html(json);
    showForum(data);
  }
</script>

</body>
</html>