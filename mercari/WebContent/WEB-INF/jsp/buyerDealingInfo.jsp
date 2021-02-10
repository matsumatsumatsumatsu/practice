<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買い手の商品取引画面</title>
</head>
<body>
	<table border="1">
		<c:forEach var="user" items="${data}">
			<tr>
				<td>${user.itemImage}</td>
				<td>${user.itemName}</td>
				<td>${user.price}</td>
				<td>${user.data}</td>
				<td>${user.address}</td>
				<td>${user.realName}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="showDealingInfo" method="post">
		<input type="submit" value="受け取りました">
	</form>

	<form action="sendMessage" method="post">
		<input type="text" name="privateChat"><br> <input
			type="submit" value="コメントする">
	</form>

	<p>
		<a href="cancel">取引をキャンセルする</a>
	</p>
	<p>
		<a href="f_start">TOPページへ</a>
	</p>

</body>
</html>