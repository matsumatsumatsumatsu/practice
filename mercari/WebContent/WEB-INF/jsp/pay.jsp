<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<tr><td>画像</td><td>商品名</td><td>値段</td><td>転送先</td></tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemImage}</td>
				<td>${item.itemName}</td>
				<td>${item.price}</td>
				<td>${item.address}</td><!-- user表 -->
			</tr>
		</c:forEach>
	</table>
	<a href="sellerdealingInfo">購入する</a><!-- 個別の取引ページ -->
</div>
</body>
</html>