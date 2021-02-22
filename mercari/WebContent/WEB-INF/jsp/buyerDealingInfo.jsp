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
			<c:set var="stateCheck" value="${deal.dealState}"></c:set>
		</c:forEach>
	</table>

	<c:forEach var="deal" items="${deal}">
		<div id="receive">
			<form action="receive?deal_id=${deal.dealId}&user_state=1" method="post">
				<input type="submit" value="受け取りました">
			</form>
		</div>
	</c:forEach>

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

	<c:forEach var="deal" items="${deal}">
		<form action="sendPrivateChat?deal_id=${deal.dealId}&user_state=1" method="post">
			<input type="text" name="text"><br> <input
				type="submit" value="コメントする">
		</form>

		<div id = "cancel">
			<p>
				<a href="canceldeal?deal_id=${deal.dealId}&user_state=1">取引をキャンセルする</a>
			</p>
		</div>
	</c:forEach>

	<p>
		<a href="f_start">TOPページへ</a>
	</p>

	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		<!-- 1→取引中（取引開始）、2→取引キャンセル、3→取引完了（受け取り終了）、4→商品発送 -->
		if (<c:out value="${stateCheck}" /> == 1) {
			$("#receive").empty();
			$("#receive").html('<p>商品の発送をお待ちください。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2) {
			$("#receive").empty();
			$("#receive").html('<p>取引がキャンセルされました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 3) {
			$("#receive").empty();
			$("#receive").html('<p>商品の受け取りが完了しました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2 ||<c:out value="${stateCheck}" /> == 4) {
			$("#cancel").empty();
		}
	</script>

</body>
</html>