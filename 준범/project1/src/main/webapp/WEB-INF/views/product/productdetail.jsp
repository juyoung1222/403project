<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<layoutTag:layout>

	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 정보</title>
<style>
.container{
	margin-top: 5%;
}
#list1 {
	float: left;
	margin: 20px;
}
#Comment{
	margin-top: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<h2>게시글 상세 정보</h2>

	<form class="form-horizontal" method="post" action="/cart/insertCart">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>제품명</th>
					<th>가 격</th>
					<th>수 량</th>
					<th>아이디</th>
				</tr>
			</thead>
			<tr>
				<td>${productdetail.productname}</td>
				<td>${productdetail.productprice}</td>
				<td>${productdetail.productsalescnt}</td>
				<td>${member.userId}</td>
			</tr>
		</table>
				<input type="hidden" name="cartproductid" value="1"/>
				<input type="hidden" name="productname" value="${productdetail.productname}"/>
				<input type="hidden" name="cartno" value="${productdetail.productno}"/>
				<input type="hidden" name="cartuserid" value="${member.userId}"/>
				<input type="hidden" name="productimagefile" value="${productdetail.productimagefile}"/>
				<input type="hidden" name="productimageName" value="${productdetail.productimageName}"/>
				<input type="hidden" name="productimageOriName" value="${productdetail.productimageOriName}"/>
				<input type="hidden" name="productimageUrl" value="${productdetail.productimageUrl}"/>
				<input type="hidden" name="productprice" value="${productdetail.productprice}"/>
				<input type="hidden" name="productsalescnt" value="${productdetail.productsalescnt}"/>
				
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>이미지</th>
				</tr>
			</thead>
				<tr>
					<td><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ><td>
				</tr>
		</table>
		<c:if test = "${member != null}">
		<select name="수량~">
			<c:forEach begin="1" end="10" var="i">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<button class="btn btn-warning"
			onclick="location.href='#'">구매 하기</button>
		<button class="btn btn-danger"
			onclick="#">장바구니담기</button>
		</c:if>
		<c:if test = "${member == null}">
		<select name="수량~">
			<c:forEach begin="1" end="10" var="i">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<button class="btn btn-warning"
			onclick="button1_click()">구매 하기</button>
		<button class="btn btn-danger" type="submit" onClick="location.href='/cart/insertCart'">장바구니담기</button>
		
		</c:if>
	</form>
</div>

<script>
function button1_click() {
	alert("로그인 해주세요");
}
</script>

</body>
</html>
</layoutTag:layout>
<!-- layoutTag를 적용하므로 bootstrap.jsp 파일이 필요 업어졌다. -->


































