<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String token = (String)session.getAttribute("flag");
%>
<html>
<head>
<%@include file="../../css/item.css"%>
<title>商品表示</title>
<p style="display:none;" id="flag"><%= token %></p>
<div class="header">


	<div class="search">

		<form name="itemsearch" method='post' action='search' onSubmit="return check()" class="itemsearch">

				<input type='text' name='keyword' style="width: 800px; height: 40px; margin-top: 30px" placeholder="何かお探しですか？">
				<input type='submit' value='検索！' style="height: 40px">
		</form>
		<a href="f_start" class="topBtn">TOPページへ</a>
	</div>
	<!-- 非login→ログインjsp、登録 login→マイページjsp、通知 -->
	<div class="headerColumn">
		<p id = "signup">
			<a href="f_signup" class="headerBtn">ユーザー登録画面へ</a>
		</p>
		<!-- 後々コメントアウト -->
		<p id = "login">
			<a href="f_login" class="headerBtn">ログイン</a>
		</p>
		<p id = "mypage">
			<a href="showprofile" class="headerBtn">マイページ</a>
		</p>
		<p id = "notice">
			<a href="showNoticeList" class="headerBtn">通知</a>
		</p>

	</div>
</div>
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

			document.getElementById("stockCheck").style.backgroundColor = "ButtonShadow";
			document.getElementById("stockCheck").style.color = "white";
		}
	</script>
		<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		var flag=document.getElementById("flag").innerText;
		if (flag == "OK") {
			$("#login").css("display","none");
			$("#signup").css("display","none");
			<!--$("#login").html('<a href="showprofile" class="headerBtn">マイページ</a>');-->
			<!--
			document.getElementById("stockCheck").style.color = "gray";
			-->
		}else{
			$("#mypage").css("display","none");
			$("#notice").css("display","none");
		}
	</script>

</body>
</html>