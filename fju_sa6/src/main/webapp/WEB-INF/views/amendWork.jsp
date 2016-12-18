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
<title></title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<div class="col-md-12">
			<h2>補打卡</h2>
			<hr>
			<form action="amend" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">選擇員工</label>
					<div class="col-sm-10">
						<select name="staffNum" class="form-control">
							<c:forEach items="${staffList}" var="staff">
								<option value="${staff.staffNum}">${staff.staffName}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<input type="datetime-local" name="date" class="form-control"
							style="text-align: center;"> <br>
					</div>

				</div>
				<button type="submit" name="submit" value=1 class="btn btn-success"
					style="margin-left: 40%">補上班</button>
				<button type="submit" name="submit" value=2 class="btn btn-success"
					style="margin-left: 5%">補下班</button>
			</form>
			<hr>
			<br>
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