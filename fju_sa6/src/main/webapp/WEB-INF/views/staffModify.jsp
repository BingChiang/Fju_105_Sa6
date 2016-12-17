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
<title>staffModify</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<div class="col-md-7 col-md-offset-1">
			<h2>修改員工</h2>
		</div>
		<div class="col-md-12">
			<br>
			<form class="form-horizontal" role="form" action="#" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">員工編號</label>
					<div class="col-sm-8">
						<p class="form-control-static">${staff.staffNum}</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">員工姓名</label>
					<div class="col-sm-8">
						<p class="form-control-static">${staff.staffName}</p>
						<%-- <input type="text" class="form-control" name="staffName"
							placeholder="員工姓名" value="${staff.staffName}"> <input
							type="hidden" name="staffNum" value="${staff.staffNum}"> --%>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">員工階級</label>
					<p class="form-control-static">${staff.level}</p>

					<!-- <label
						class="radio-inline" style="margin-left: 20px;"> <input
						type="radio" name="staffLevel" value="0"> 管理者
					</label> <label class="radio-inline"> <input type="radio"
						name="staffLevel" value="1" checked> 一般員工
					</label> -->
				</div>
				<div class="form-group">
					<br>
					<div class="col-sm-offset-2 col-sm-10">
						<a role="button" href="setLevel?staffNum=${staff.staffNum}"
							type="submit" class="btn btn-primary">修改員工階級</a>
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