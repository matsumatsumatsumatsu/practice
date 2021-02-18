<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<div class="search">
	<form name="itemsearch" method='post' action='search'
		onSubmit="return check()">
		<p>商品名検索</p>
		<input type='text' name='itemName'> <input type='submit'
			value='検索！'>
	</form>
</div>
</head>
<body>

	<div id="buyer">
		<h4>出品した商品</h4>
		<table border="1">
			<tr>
				<th>商品名</th>
				<th>Image</th>
			</tr>
			<c:forEach var="item" items="${item}">
				<tr>
					<td><a href="showiteminfo?item_id=${item.itemId}">${item.itemName}</a></td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="list-side">
		<ul>
			<li><a href="purchase">購入した商品</a></li>
			<li><a href="point">ポイント</a></li>
			<li><a href="profile">プロフィール</a></li>
			<li><a href="logout">ログアウト</a></li>
		</ul>
	</div>


</body>
</html>