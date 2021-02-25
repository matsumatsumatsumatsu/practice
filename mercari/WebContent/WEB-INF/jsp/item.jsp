<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<%@include file="../../css/item.css"%>
<title>商品表示</title>

</head>

<body>
	<div class="itemlist">

		<c:forEach var="item" items="${item}">

			<h1>${item.itemName}</h1>
			<div class="left">
				<img src="images/${item.itemImage}" width="300">
			</div>
			<table border="1" class="item">

				<tr>
					<th>商品説明</th>
					<td>${item.itemExplanation}</td>
				</tr>
				<tr>
					<th>ハード</th>
					<td><a
						href="narrow?hardware=${item.hardwareId}&keyword=&category=0&minprice=&maxprice=&stock=">${item.hardware}</a></td>
				</tr>
				<tr>
					<th>ジャンル</th>
					<td><a
						href="narrow?category=${item.categoryId}&keyword=&hardware=0&minprice=&maxprice=&stock=">${item.category}</a></td>
				</tr>
				<tr>
					<th>発送期間</th>
					<td>${item.term}</td>
				</tr>
				<tr>
					<th>値段</th>
					<td>${item.price}</td>
				</tr>

				<c:set var="stockCheck" value="${item.stock }"></c:set>
				</c:forEach>
			</table>
			<p>
				<c:forEach var="item" items="${item}">
					<a id="stockCheck" href="confirmpay?item_id=${item.itemId}"
						class="button">商品購入</a>
				</c:forEach>
			</p>
	</div>
	<br>

	<div class="openChatTable">
	<!-- 	<table border="1" class="chat"> -->
			<c:forEach var="chat" items="${open}">

				<div class="balloon1-left">
					<p>${chat.text}</p>
				</div>

					${chat.date}

			</c:forEach>


		<c:forEach var="item" items="${item}">
			<form action="sendopenchat?item_id=${item.itemId}" method="post"
				id="form1">

				<input type="text" name="text" class="inputchat" required><br> <input
					class="button" type="submit" value="コメントする">
			</form>
		</c:forEach>



		<p>
			<c:forEach var="item" items="${item}">
				<a class="button" href="showuserinfo?user_id=${item.sellerId}">ユーザーの確認</a>
			</c:forEach>
		</p>
	</div>
	<!-- 	<p>
		<a href="/category/">カテゴリー検索</a>
	</p> -->

	<script>
		if (<c:out value="${stockCheck}" /> == 0) {
			document.getElementById("stockCheck").innerText = "売り切れ";
			document.getElementById("stockCheck").removeAttribute("href");
			document.getElementById("stockCheck").style.color = "white";
			document.getElementById("stockCheck").style.backgroundColor = "gray";
		}
	</script>

</body>
</html>