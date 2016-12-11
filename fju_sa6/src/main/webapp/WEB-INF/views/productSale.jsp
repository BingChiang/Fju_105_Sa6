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
<title>product</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>

	<div class="col-md-10 col-md-offset-2 main" style="margin-top: 50px;">
		<div class="row">
			<div class="col-md-7">
				<c:forEach items="${typeList} var = "pro">
					<a href="addCart?productNum =${productNum}&typeNum=${pro.typeNum}">
						<div class="col-md-2  btn-lg btn-primary" id="product">
							<p>${pro.productName}</p>
						</div>
					</a>
				</c:forEach>

			</div>
			<div class="col-md-5">
				<c:forEach items="${typeProList}" var="type">
					<a href="productSale?typeNum=${type.typeNum}">
						<div id="productType" class="col-md-2  btn-lg btn-primary">
							<p>${type.typeName}</p>
						</div>
					</a>
				</c:forEach>

				<div>
					<table class="table">
						<tr>
							<th>項目</th>
							<th>價格</th>
							<th>刪除</th>
						</tr>
						<c:forEach items="${cart}" var="cart">
							<tr>
								<td>${cart.productName}</td>
								<td>${cart.productPrice}</td>
								<td><a href="#" role="button" class="btn btn-sm btn-danger"
									style="margin-top: -5px;">刪除</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3">
								<hr>
							</td>
						</tr>
						<tr>
							<td class="Checkout">小計</td>
							<td class="Checkout">${cartTotal}</td>
							<td class="Checkout"><a href="cartClean" role="button"
								class="btn btn-sm btn-default" style="margin-top: -5px;">清除</a>
								<a href="#" role="button" class="btn btn-sm btn-primary"
								style="margin-top: -5px;">結帳</a></td>
						</tr>
					</table>

				</div>
			</div>
		</div>
	</div>
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