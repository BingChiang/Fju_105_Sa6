<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>worktime</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<div class="col-md-12">
			<h2>打卡記錄查詢</h2>
			<hr>
			<form action="#" method="post">
				<input type="date" name="searchTime" class="form-control"
					style="text-align: center;">
				<button type="submit" class="btn btn-primary"
					style="margin-left: 45%">確認</button>
			</form>
			<hr>
			<br>
		</div>
		<table class="table table-striped">
			<tr>
				<th>員工編號</th>
				<th>員工名稱</th>
				<th>上班時間</th>
				<th>下班時間</th>
			</tr>
			<c:forEach items="${worktime}" var="worktime">
				<tr>
					<td>${worktime.staffNum}</td>
					<td>${worktime.staffName}</td>
					<td>${worktime.onwork}</td>
					<td>${worktime.offwork}</td>

				</tr>
			</c:forEach>

		</table>
	</div>
	</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>