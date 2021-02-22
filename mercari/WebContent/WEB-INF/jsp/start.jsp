<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<style>
.header {
	background-color: white;
	margin-bottom: 30px;
	height: 150px;
	border-bottom: 2px solid black;
}

.search {
	display: inlone-block;
	text-align: center;
	float: right;
	margin-right: 100px;
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
	color: #FFF;
	background: #fd9535; /*背景色*/
	border-bottom: solid 2px #d27d00; /*少し濃い目の色に*/
	border-radius: 4px; /*角の丸み*/
	box-shadow: inset 0 2px 0 rgba(255, 255, 255, 0.2), 0 2px 2px
		rgba(0, 0, 0, 0.19);
	font-weight: bold;
}

.headerBtn:active {
	border-bottom: solid 2px #fd9535;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}
</style>
<title>スタート画面</title>
<div class="header">
	<div class="search">
		<form name="itemsearch" method='post' action='search'
			onSubmit="return check()">
			<input type='text' name='itemName'
				style="width: 800px; height: 40px; margin-top: 30px"
				placeholder="商品名検索"> <input type='submit' value='検索！'
				style="height: 40px">
		</form>
	</div>
	<div class="headerColumn">
		<p>
			<a href="f_signup" class="headerBtn">ユーザー登録画面へ</a>
		</p>
		<!-- 後々コメントアウト -->
		<p>
			<a href="f_login" class="headerBtn">ログイン</a>
		</p>
		<p>
			<a href="showprofile" class="headerBtn">マイページ</a>
		</p>
		<!-- 非login→ログインjsp、login→マイページjsp -->

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
		if (<c:out value="${loginCheck}" /> != null) {
			$("#login").empty();
			$("#login").html('<a href="showprofile">マイページ</a>');
			<!--
			document.getElementById("stockCheck").style.color = "gray";
			-->
		}
	</script>

</body>
</html>

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->

