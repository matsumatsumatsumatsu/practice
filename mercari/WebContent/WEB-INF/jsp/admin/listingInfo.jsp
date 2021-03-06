<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>ADMIN出品した商品の個別閲覧</title>
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
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemImage}</td>
				<td>${item.itemName}</td>
				<td>${item.itemExplanation}</td>
				<td>${item.hardwareId}</td>
				<td>${item.categoryId}</td>
				<td>${item.term}</td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br>


	<!-- forEach問題 -->
	<form action="showOpenChat" method="post">
		<input type="text" name="openChat"><br> <input
			type="submit" value="コメントする">
	</form>

	<p>
		<a href="userInfo">ユーザーの確認</a>
	</p>
	<p>
		<a href="category">カテゴリー検索</a>
	</p>
	<p>
		<a href="listingEdit">出品した商品の編集</a>
	</p>
	<script>
		$(document).on('keydown', function(e) {
			if ((e.which || e.keyCode) == 116) {
			//	alert("F5キーは無効化されています。");
				return false;
			}
		});
	</script>
</body>
</html>