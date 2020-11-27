<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="../module/top.jsp"/>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2">
			<jsp:include page="intro.jsp"/>
		</div>
		<div class="col-sm-8">
			<jsp:include page="intro.jsp"/>
		</div>
		<div class="col-sm-2">
			<jsp:include page="intro.jsp"/>
		</div>
		<div class="col-sm-12">
			<jsp:include page="intro.jsp"/>
		</div>
	</div>
</div>

<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="myCarousel" data-slide-to="1"></li>
			<li data-target="myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img class="img-responsive center-block" src="../imageFile/다운로드 (1).jfif">
					<div class="carousel-caption">
						<h3>별마당 도서관</h3>
					</div>
			</div>
			<div class="item">
					<img class="img-responsive center-block" src="../imageFile/다운로드 (2).jfif"/>
					<div class="carousel-caption">
						<h3>별마당 내부</h3>
						
					</div>
				</div>
			<div class="item">
					<img class="img-responsive center-block" src="../imageFile/다운로드 (3).jfif"/>
					<div class="carousel-caption">
						<h3>별마당 도서관 외부</h3>
						
					</div>
				</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
	
	</div>
</div>
		

<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
