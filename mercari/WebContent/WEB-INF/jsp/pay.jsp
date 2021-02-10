<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入内容の確認</title>
</head>
<body>
	<div>
		<h4>購入内容の確認</h4>
<<<<<<< HEAD
		<table border="1">
			<tr>
				<td>画像</td>
				<td>商品名</td>
				<td>値段</td>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemImage}</td>
					<td>${item.itemName}</td>
					<td>${item.price}</td>
					<c:set var="price" value="${item.price }"></c:set>

				</tr>
		</table>
=======

>>>>>>> stash
		<table border="1">
			<tr>
<<<<<<< HEAD
				<td>残高</td>
				<td>住所</td>
=======
				<td>画像</td>
				<td>商品名</td>
				<td>値段</td>
>>>>>>> stash
			</tr>
<<<<<<< HEAD
			<c:forEach var="user" items="${user}">
				<tr>
					<td>${user.point}</td>
					<td>${user.address}</td>
					<c:set var="point" value="${user.point }"></c:set>
				</tr>
			</c:forEach>
		</table>
		<a id="pointCheck" href="pay?item_id=${item.itemId}">購入する</a>
		<!-- 個別の取引ページ -->
		</c:forEach>
	</div>
=======
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemImage}</td>
					<td>${item.itemName}</td>
					<td>${item.price}</td>
					<c:set var="price" value="${item.price }"></c:set>
				</tr>
			</c:forEach>
		</table>

		<table border="1">
			<tr>
				<td>残高</td>
				<td>住所</td>
			</tr>
			<c:forEach var="user" items="${user}">
				<tr>
					<td>${user.point}</td>
					<td>${user.address}</td>
					<c:set var="point" value="${user.point }"></c:set>
				</tr>
			</c:forEach>
		</table>

		<c:forEach var="user" items="${user}">
		<a id="pointCheck" href="pay?item_id=${item.itemId}">購入する</a>
		<!-- 個別の取引ページ -->
		</c:forEach>
	</div>

>>>>>>> stash
	<script>
		if (<c:out value="${price}" /> > <c:out value="${point}" />) {
			document.getElementById("pointCheck").removeAttribute("href");
			document.getElementById("pointCheck").style.color = "gray";
		}
	</script>
</body>
</html>