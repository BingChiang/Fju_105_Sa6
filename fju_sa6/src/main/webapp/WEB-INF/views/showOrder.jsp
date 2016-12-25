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
<title>showOrder</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<div class="col-md-12">
			<h2>查看訂單</h2>
			<hr>
			<br>
		</div>
		<table class="table table-striped">
			<tr>
				<th>訂單編號</th>
				<th>訂單日期</th>
				<th>訂單價格</th>
				<th>訂單狀態</th>
				<th>查看訂單詳情</th>
			</tr>
			<c:forEach items="${orderList}" var="ord">
				<tr>
					<td>${ord.orderlistNum}</td>
					<td>${ord.orderDate}</td>
					<td>${ord.orderTotal}</td>
					<c:if test="${ord.available==0}">
					<td>已結帳</td>
					</c:if>
					<c:if test="${ord.available==1}">
					<td style="color:red;">已銷退</td>
					</c:if>
					<td><a role="button"
						href="orderDetail?orderlistNum=${ord.orderlistNum}"
						class="btn btn-sm btn-primary">查看</a></td>
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