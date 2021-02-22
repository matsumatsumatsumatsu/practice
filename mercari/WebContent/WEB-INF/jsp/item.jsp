<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>商品表示</title>

</head>

<body>
	<table border="1">
		<tr>
			<th>画像</th>
			<th>商品名</th>
			<th>商品説明</th>
			<th>ハード</th>
			<th>ジャンル</th>
			<th>発送期間</th>
			<th>値段</th>
			<th>ユーザID</th>
		</tr>
		<c:forEach var="item" items="${item}">
			<tr>
				<td><img src="../mercari/images/${item.itemImage}"width="300"></td>
				<td>${item.itemName}</td>
				<td>${item.itemExplanation}</td>
				<td>${item.hardware}</td>
				<td>${item.category}</td>
				<td>${item.term}</td>
				<td>${item.price}</td>
				<td>${item.sellerId}</td>
				<c:set var="stockCheck" value="${item.stock }"></c:set>
			</tr>
			</c:forEach>
	</table>
	<br>

		<div class="openChatTable">
		<table border="1">
			<c:forEach var="chat" items="${open}">
				<tr>
					<td>${chat.text}</td>
					<td>${chat.date}</td>
				</tr>
			</c:forEach>
		</table>

		<c:forEach var="item" items="${item}">
			<form action="sendopenchat?item_id=${item.itemId}" method="post">
				<input type="text" name="text"><br>
				<input type="submit" value="コメントする">
			</form>
		</c:forEach>
	</div>

	<p>
		<c:forEach var="item" items="${item}">
			<a id="stockCheck" href="confirmpay?item_id=${item.itemId}">商品購入</a>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="item" items="${item}">
			<a href="showuserinfo?user_id=${item.sellerId}">ユーザーの確認</a>
		</c:forEach>
	</p>
	<p>
		<a href="/category/">カテゴリー検索</a>
	</p>

	<script>
		if (<c:out value="${stockCheck}" /> == 0) {
			document.getElementById("stockCheck").innerText = "売り切れ";
			document.getElementById("stockCheck").removeAttribute("href");
			document.getElementById("stockCheck").style.color = "gray";
		}
	</script>

</body>
</html>