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
<title>mainpag</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<div class="col-md-7 col-md-offset-1">
			<h2>新增產品</h2>
		</div>

		<div class="col-md-12">
			<br>
			<form class="form-horizontal" role="form" action="productAdd" method="post">

				<div class="form-group">
					<label class="col-sm-2 control-label">產品名稱</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="productName"
							placeholder="產品名稱" value="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">產品類型</label>
					<div class="col-sm-8">
						<select name="typeNum" class="form-control">
						<c:forEach items="${typeList}" var="typeList">
							<option value=${typeList.typeNum}>${typeList.typeName}</option>
							</c:forEach>
							
						</select> <a role="button" href="productTypeAdd" class="btn btn-success">新增類別</a>

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">產品價格</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="productPrice"
							placeholder="產品價格" value="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">產品成本</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="productCost"
							placeholder="產品成本" value="">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">確認</button>
						<button class="btn btn-dafault" type="button"
							onClick="javascript:history.back(1)">按此返回上頁</button>
					</div>


				</div>
			</form>
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