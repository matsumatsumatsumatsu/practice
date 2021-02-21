<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>出品した商品の個別閲覧</title>
</head>

<body>
	<table border="1">
		<tr>
			<td>画像</td>
			<td>商品名</td>
			<td>商品説明</td>
			<td>ハード</td>
			<td>ジャンル</td>
			<td>発送期間</td>
			<td>値段</td>
		</tr>
		<c:forEach var="item" items="${item}">
			<tr>
				<td>${item.itemImage}</td>
				<td>${item.itemName}</td>
				<td>${item.itemExplanation}</td>
				<td>${item.hardware}</td>
				<td>${item.category}</td>
				<td>${item.term}</td>
				<td>${item.price}</td>
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
				<input type="text" name="text"><br> <input
					type="submit" value="コメントする">
			</form>
		</c:forEach>
	</div>

	<p>
		<a href="showprofile">マイページへ</a>
	</p>
	<p>
		<a href="category">カテゴリー検索</a>
	</p>
	<p>
		<c:forEach var="item" items="${item}">
			<a href="showListingEdit?item_id=${item.itemId}">出品した商品の編集</a>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="item" items="${item}">
			<a href="remove?item_id=${item.itemId}">出品を取り消す</a>
		</c:forEach>
	</p>
	<p>
		<a href="f_start">TOP画面へ</a>
	</p>
</body>
</html>