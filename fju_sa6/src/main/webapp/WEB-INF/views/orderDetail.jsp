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
		<div class="col-md-12 form-group">
			<h2>查看訂單詳情</h2>
			<hr>
			<h3>訂單編號：${orderList.orderlistNum}</h3>
		</div>
		<table class="table table-striped">
			<tr>
				<th>產品名稱</th>
				<th>產品價格</th>
			</tr>
			<c:forEach items="${order}" var="pro">
				<tr>
					<td>${pro.productName}</td>
					<td>${pro.productPrice}</td>
				</tr>
			</c:forEach>
		</table>
		<button class="btn btn-dafault" type="button"
			onClick="javascript:history.back(1)">按此返回上頁</button>
		<c:if test="${orderList.available==0}">
			<a class="btn btn-danger" role="button" type="button"
				href="orderRemove?orderlistNum=${orderList.orderlistNum}">銷退此筆訂單</a>
		</c:if>
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