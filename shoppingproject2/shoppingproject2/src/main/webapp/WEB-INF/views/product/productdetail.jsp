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

		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>제품명</th>
					<th>가 격</th>
					<th>수 량</th>
				</tr>
			</thead>
			<tr>
				<td>${productdetail.productname}</td>
				<td>${productdetail.productprice}</td>
				<td>${productdetail.productsalescnt}</td>
			</tr>
		</table>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>이미지</th>
					<th width="65">조회수</th>
				</tr>
			</thead>
				<tr>
					<td><img src="/static/upload/${productdetail.productimageName}" alt="이미지 업로드" ><td>
				</tr>
		</table>
		<c:if test = "${member != null}">
		<button class="btn btn-warning"
			onclick="location.href='/product/Update/${productdetail.productno}'">수정</button>
		<button class="btn btn-danger"
			onclick="location.href='/product/delete/${productdetail.productno}'">삭제</button>
		</c:if>
		<c:if test = "${member == null}">
		<button type="submit" class="btn btn-primary"
			onclick="button1_click()">댓글</button>
		<button class="btn btn-warning"
			onclick="button1_click()">수정</button>
		<button class="btn btn-danger"
			onclick="button1_click()">삭제</button>
		</c:if>
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


































