<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String token = (String)session.getAttribute("flag");
%>

<html>

<head>
<style>
.header {
	background-color: white;

	height: 150px;
	border-bottom: 2px solid black;
}

.search {
	display: inlone-block;
	text-align: center;
	float: right;
		margin-left: 10%;
	margin-right: 10%;

}

body {
	background-color: #F8F8FF;
}

.center {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	height: auto;
	background-color: white;
	width: 500px;
}

.headerColumn {
	display: inline-block;
	width: auto;
	position: relative;
	top: 5px;
	left: 800px;
}

.headerColumn p {
	display: inline-block;
	width: auto;
	margin-right: 20px;
}

.start {
	margin-left: auto;
	margin-right: auto;
	height: auto;
	background-color: white;
	width: auto;
}

.listingButton {
	display: inline-block;
	text-decoration: none;
	background: #FF3333;
	color: #FFF;
	font-size: 20px;
	font-weight: bold; width : 150px;
	height: 150px;
	line-height: 150px;
	border-radius: 50%;
	text-align: center;
	overflow: hidden;
	transition: .4s;
	position: fixed;
	bottom: 50px;
	right: 50px;
	width: 150px;
}

.listingButton:hover {
	background: #668ad8;
}

.headerBtn {
	position: relative;
	display: inline-block;
	padding: 0.25em 0.5em;
	text-decoration: none;
}



a.headerBtn {
  border-radius: 0;

}

a.headerBtn:hover {
  color:#8EF1FF;

}
.itemsearch{
  float: right;
}
.topBtn{
margin-top: 5%;
float: left;
}
}

</style>
<title>スタート画面</title>
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
<!-- <div class="search">
			<c:forEach var="hardware" items="${hardware}">
				<input type="radio" name="hardware" value="${hardware.hardwareId}">${hardware.hardware}
			</c:forEach>
			<br>
			<p>カテゴリ</p>
			<input type="radio" name="category" value="0" checked>すべて
			<c:forEach var="category" items="${category}">
				<input type="radio" name="category" value="${category.categoryId}">${category.category}
			</c:forEach>
	</div> -->
</head>

<body>
	<div class="start">
		<h1>メルカリもどき</h1>

		<p>
			<a href="f_listing" class="listingButton">出品画面へ</a>
		</p>
		<!-- 後々コメントアウト -->
		<p>
			<a href="f_logout">ログアウト</a>
		</p>

		<div class="center">
			<table border="1">
				<tr>
					<th>itemid</th>
					<th>商品名</th>
					<th>価格</th>
					<th>画像</th>
					<th>説明</th>
					<th>在庫</th>
				</tr>
				<c:forEach var="item" items="${itemlist}">
					<tr>
						<td>${item.itemId}</td>
						<td><a href="showiteminfo?item_id=${item.itemId}"
							name="itemId">${item.itemName}</a></td>
						<td>${item.price}</td>
						<td>${item.itemImage}</td>
						<td>${item.itemExplanation}</td>
						<td>${item.stock}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
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

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->
