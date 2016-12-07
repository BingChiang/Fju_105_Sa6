<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">


<title>worktimelate</title>
</head>
<body>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron">
			 <h1>補打卡</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="worktimelate" id="insertForm">

					<div class="form-group">
						<label>員工:</label> <input type="text" name="desc" placeholder="員工"
							required>
					</div>
					<div class="form-group">
						<label>時間:</label> <input type="text" name="desc" placeholder="時間"
							required>

					</div>
					<div class="form-group">
						<label>上下班:</label> <select id=type name="type"
							onchange="updateData(this)">
							<option value="">請選擇</option>
							<option value="1">上班</option>
							<option value="2">下班</option>

						</select>
					</div>


					<button type="submit" class="btn btn-default">新增</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div>
	<!-- /.container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
	<script src="<c:url value="/resources/js/jsadditional-methods.js" />"></script>
	<script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>

	<script>
		$("#insertForm").validate();
	</script>
</body>
</html>
