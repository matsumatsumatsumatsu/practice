<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売り手の商品取引画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>itemId</td>
			<td>itemName</td>
			<td>price</td>
		</tr>
		<c:forEach var="item" items="${item}">
			<tr>
				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<tr>
			<td>dealId</td>
			<td>itemId</td>
			<td>dealState</td>
		</tr>
		<c:forEach var="deal" items="${deal}">
			<tr>
				<td>${deal.dealId}</td>
				<td>${deal.itemId}</td>
				<td>${deal.dealState}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<tr>
			<td>chatId</td>
			<td>text</td>
			<td>date</td>
		</tr>
		<c:forEach var="chat" items="${chat}">
			<tr>
				<td>${chat.chatId}</td>
				<td>${chat.	text}</td>
				<td>${chat.date}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="showDealingInfo" method="post">
		<input type="submit" value="発送しました">
	</form>

	<c:forEach var="deal" items="${data}">
		<form action="sendPrivateChat?=deal_id=${deal.dealId}&user_state=${deal.userState}" method="post">
			<input type="text" name="text"><br> <input
				type="submit" value="コメントする">
		</form>
	</c:forEach>

	<p>
		<a href="cancel">取引をキャンセルする</a>
	</p>
	<p>
		<a href="f_start">TOPページへ</a>
	</p>

</body>
</html>