<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>スタート画面</title>
<div class="search">
	<form name="itemsearch" method='post' action='search'
		onSubmit="return check()">
		<p>商品名検索</p>
		<input type='text' name='keyword' placeholder="何かお探しですか？"> <input type='submit'
			value='検索！'>
	</form>
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
	<h1>メルカリもどき</h1>
	<p>
		<a href="f_signup">ユーザー登録画面へ</a>
	</p>
	<p>
		<a href="showprofile">マイページ</a>
	</p>
	<p>
		<a href="f_listing">出品画面へ</a>
	</p>
	<p>
		<a href="f_login">ログイン</a>
	</p>
	<p>
		<a href="f_logout">ログアウト</a>
	</p>

	<table border="1">
		<tr>
			<th>itemid</th>
			<th>商品名</th>
			<th>価格</th>
			<th>画像</th>
			<th>説明</th>
		</tr>
		<c:forEach var="item" items="${itemlist}">
			<tr>
				<td>${item.itemId}</td>
				<td><a href="showiteminfo?item_id=${item.itemId}" name="itemId">${item.itemName}</a></td>
				<td>${item.price}</td>
				<td>${item.itemImage}</td>
				<td>${item.itemExplanation}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->

