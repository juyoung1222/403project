<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<!--
	Caminar by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Caminar by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/static/assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="#">Fashionable <span>by ${productdetail.productname}</span></a></div>
			</header>

		<!-- Main -->
			<section id="main">
				<div class="inner">

				<!-- One -->
					<section id="one" class="wrapper style1">

						<div class="image fit flush">
							<img src="/static/images/pic02.jpg" alt="" />
						</div>
						<header class="special">
							<h2>아름다운 패션의 완성</h2>
							<p>다양한 구도의 자신있는 멋</p>
						</header>
						<div class="content">
							<p>Curabitur eget semper ante. Morbi eleifend ultricies est, a blandit diam vehicula vel. Vestibulum porttitor nisi quis viverra hendrerit. Suspendisse vel volutpat nibh, vel elementum lacus. Maecenas commodo pulvinar dui, at cursus metus imperdiet vel. Vestibulum et efficitur urna. Duis velit nulla, interdum sed felis sit amet, facilisis auctor nunc. Cras luctus urna at risus feugiat scelerisque nec sed diam. </p>
							<p>Nunc fringilla metus odio, at rutrum augue tristique vel. Nulla ac tellus a neque ullamcorper porta a vitae ipsum. Morbi est sapien, hendrerit quis mi in, aliquam bibendum orci. Vestibulum imperdiet nibh vitae maximus posuere. Aenean sit amet nibh feugiat, condimentum tellus eu, malesuada nunc. Mauris ac pulvinar turpis, sit amet pharetra est. Ut bibendum justo condimentum, vehicula ex vel, venenatis libero. Etiam vehicula urna sed justo bibendum, ac lacinia nunc pulvinar. Integer nec velit orci. Vestibulum pellentesque varius dapibus. Morbi ullamcorper augue est, sed luctus orci fermentum dictum. Nunc tincidunt, nisl consequat convallis viverra, metus nisl ultricies dui, vitae dapibus ligula urna sit amet nibh. Duis ut venenatis enim.</p>
						</div>
					</section>

				<!-- Two -->
					<section id="two" class="wrapper style2">
						<header>
							<h2>각양 각색의 제품</h2>
							<p>${productdetail.productname}</p>
						</header>
						<div class="content">
							<div class="gallery">
								<div>
									<div class="image fit flush">
										<a href="images/pic03.jpg"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></a>
									</div>
								</div>
								<div>
									<div class="image fit flush">
										<a href="images/pic01.jpg"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></a>
									</div>
								</div>
								<div>
									<div class="image fit flush">
										<a href="images/pic04.jpg"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></a>
									</div>
								</div>
								<div>
									<div class="image fit flush">
										<a href="images/pic05.jpg"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></a>
									</div>
								</div>
							</div>
						</div>
					</section>

				<!-- Three -->
					<section id="three" class="wrapper">
						<div class="spotlight">
							<div class="image flush"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></div>
							<div class="inner">
								<h3>착한 가격</h3>
								<p>가격 : ${productdetail.productprice}</p>
							</div>
						</div>
						<div class="spotlight alt">
							<div class="image flush"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></div>
							<div  class="inner">
								<h3>감각적의 제품</h3>
								<p>제품 명 : ${productdetail.productname}</p>
							</div>
						</div>
						<div class="spotlight">
							<div class="image flush"><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ></div>
							<div class="inner">
								<h3>폭주중인 주문 빠른 구매</h3>
								<p>판매량 : ${productdetail.productsalescnt}</p>
							</div>
						</div>
					</section>

				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
					</ul>
				</div>
				<div class="copyright">
					&copy; Untitled. All rights reserved. Images <a href="https://unsplash.com">Unsplash</a> Design <a href="https://templated.co">TEMPLATED</a>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="/static/assets/js/jquery.min.js"></script>
			<script src="/static/assets/js/jquery.poptrox.min.js"></script>
			<script src="/static/assets/js/skel.min.js"></script>
			<script src="/static/assets/js/util.js"></script>
			<script src="/static/assets/js/main.js"></script>

	</body>
</html>