<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入内容の確認</title>
</head>
<body>
<div>
	<h4>購入内容の確認</h4>
<table border="1">
		<tr><td>画像</td><td>商品名</td><td>値段</td></tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemImage}</td>
				<td>${item.itemName}</td>
				<td>${item.price}</td>

			</tr>
		</table>
		<table border="1">
		<tr><td>残高</td><td>住所</td></tr>
		<c:forEach var="user" items="${user}">
			<tr>
				<td>${user.point}</td>
				<td>${user.address}</td>
			</tr>
		</c:forEach>
	</table>
	<a href = "pay?item_id=${item.itemId}">購入する</a><!-- 個別の取引ページ -->
		</c:forEach>
</div>
</body>
</html>