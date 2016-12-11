<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>index</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<%@include file="navbar.jspf"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="margin-top: 30px;">
		<h2>請選擇登入員工</h2>
		<c:forEach items="${staffList}" var="staff">

			<a href="login?staffNum=${staff.staffNum }" role="button">
				<div class="col-sm-3 btn-lg btn-primary" id="staffName">
					<p>${staff.staffName}</p>
				</div>
			</a>

		</c:forEach>
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
	<script src="js/bootstrap.min.js"></script>
</body>

</html>