<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">		
		<h3>Cart</h3>
		<hr>
		<div class="row">
			<table class="table">
				<thead class="thead-dark">
					<th class="text-center">Image</th>
					<th class="text-center">ProductName</th>
					<th class="text-center">Quantity</th>
					<th class="text-center"></th>
				</thead>
				<tbody>
					<tr>
					 	<td class="text-center">
					 		<a href="image.jsp" >
					 			<img width="50px" alt="picture"/>
					 		</a>
					 	</td>
					 	<td class="text-center">
					 		<a><p>ProductName</p></a>
					 	</td>
					 	<td class="text-center">
					 		<a><p>Quantity</p></a>
					 	</td>
					 	<td class="text-center">
					 		<button class="btn btn-sm btn-primary">Add to Cart</button>
					 	</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>