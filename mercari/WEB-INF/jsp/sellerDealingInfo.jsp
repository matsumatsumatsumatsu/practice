<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売り手の商品取引画面</title>
<%@include file="../css/sellerDealInfo.css"%>
</head>
<body>
<div class="center">
<div class="left">
	<table border="1">
		<c:forEach var="item" items="${item}">
			<tr>
			<th>ItemID</th>
				<td>${item.itemId}</td>
			</tr>
			<tr>
				<th>商品名</th>
				<td>${item.itemName}</td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<c:forEach var="deal" items="${deal}">
			<tr>
				<th>取引ID</th>
				<td>${deal.dealId}</td>
			</tr>
			<tr>
				<th>商品ID</th>
				<td>${deal.itemId}</td>
			</tr>
			<tr>
				<th>取引状況</th>
				<td>${deal.dealState}</td>
			</tr>
			<c:set var="stateCheck" value="${deal.dealState}"></c:set>
		</c:forEach>
	</table>
	</div>
	<div class="right">
	<c:forEach var="deal" items="${deal}">
		<div id = "dispatch">
			<form action="dispatch?deal_id=${deal.dealId}&user_state=2" method="post">
				<input type="submit" value="発送しました" class="button">
			</form>
		</div>
	</c:forEach>

	<table border="1">
		<tr>
			<td>チャットID</td>
			<td>本文</td>
			<td>投稿日時</td>
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
		<form action="sendPrivateChat?deal_id=${deal.dealId}&user_state=2" method="post">
			<input type="text" name="text" class="textBox"><br> <input
				type="submit" value="コメントする" class="button">
		</form>
</div>
<div class="left">
<div id = "cancel">
			<p>
				<a href="canceldeal?deal_id=${deal.dealId}&user_state=1"" class="button">取引をキャンセルする</a>
			</p>
			</div>
	</c:forEach>
	<div class="top">
	<p>
		<a href="f_start" class="button">TOPページへ</a>
	</p>
	</div>
	</div>
	</div>

	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		<!-- 1→取引中（取引開始）、2→取引キャンセル、3→取引完了（受け取り終了）、4→商品発送 -->
		if (<c:out value="${stateCheck}" /> == 4) {
			$("#dispatch").empty();
			$("#dispatch").html('<p>商品の発送が完了しました。</p>');
			<!-- document.getElementById("stockCheck").style.color = "gray"; -->
		}

		if (<c:out value="${stateCheck}" /> == 2) {
			$("#dispatch").empty();
			$("#dispatch").html('<p>取引がキャンセルされました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 3) {
			$("#dispatch").empty();
			$("#dispatch").html('<p>商品の受け取りが完了しました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2 ||<c:out value="${stateCheck}" /> == 4) {
			$("#cancel").empty();
		}
	</script>

</body>
</html>
