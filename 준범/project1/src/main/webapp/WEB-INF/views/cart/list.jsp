<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" 	tagdir="/WEB-INF/tags" %>

<layoutTag:layout>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장바구니 목록 보기</title>

<style>
	.navbar-inverse .navbar-nav > .active > a, 
	.navbar-inverse .navbar-nav > .active > a:focus, 
	.navbar-inverse .navbar-nav > .active > a:hover {
	    color: rgb(255, 255, 255);
	    background-color: red
	}
	</style>
</head>
<body>

<div class="container">
	<h2>장바구니 목록</h2>
	
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>No</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>일자</th>
				<th>삭제</th>
			</tr>
		</thead>
			<c:forEach var="cart" items="${list}">
			<tr>
				<td>${cart.cartno}</td>
				<td>${cart.productimagefile}</td>
				<td>${cart.productname}</td>
				<td>${cart.productprice}</td>
				<td>
					<input type="number" style="width:40px" name="amount" value="${row.amount}" min="1">
					<input type="hidden" name="productId" value="${row.productId}">
				</td>
				<td><button type="button" class="btn btn-danger" onclick="location.href='/cart/list/${cart.cartno}'">삭제</button></td>
				<td><fmt:formatDate value="${cart.cartdate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/></td>
				
			</tr>
			</c:forEach>
		<tbody>
		</tbody>
	</table>

</div>

</body>

<!-- layoutTag를 적용하므로 bootstrap.jsp 파일이 필요 없어졌다. -->
</html>

</layoutTag:layout>





















