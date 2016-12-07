<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<title>產品管理</title>
</head>
<body>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron">
			<h1>打卡紀錄</h1>
		</div>


		<div class="container">
			<div class="row">


				<div class="form-group">
					<label>年月日:</label> <input type="text" name="desc"
						placeholder="輸入年月日" required>

				</div>

				<button type="submit" class="btn btn-default">確認</button>



				<div class="col-md-12">
					<table class="table">
						<tr>
							<th>員工</th>
							<th>時間</th>
							<th>類型</th>
							<th></th>
						</tr>

						<tr class="odd gradeX">
							<td></td>
							<td></td>
							<td></td>
							<th></th>

						</tr>
						<c:forEach items="${worktime}" var="worktime">
							<tr>
								<td>${worktime.name}</td>
								<td>${worktime.time}</td>
								<td>${worktime.onoffwork}</td>
							</tr>
						</c:forEach>
					</table>
				</div>


			</div>
		</div>
	</div>

	

	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>