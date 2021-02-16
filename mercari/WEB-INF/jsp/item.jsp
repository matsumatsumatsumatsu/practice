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
				<c:set var="stockCheck" value="${item.stock }"></c:set>
			</tr>
			</c:forEach>
	</table>
	<br>

	<div class="openChatTable">
		<table border="1">
			<c:forEach var="chat" items="${open}">
				<tr>
					<td>${open.text}</td>
					<td>${open.date}</td>
				</tr>
			</c:forEach>
		</table>

		<form action="sendopenchat" method="post">
			<input type="text" name="openChatText"><br>
			<input type="submit" value="コメントする">
		</form>
	</div>

	<p>
		<a id="stockCheck" href="confirmpay?item_id=${item.itemId}">商品購入</a>
	</p>



	<p>
		<a href="/userInfo/">ユーザーの確認</a>
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