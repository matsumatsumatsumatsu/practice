<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<div class="search">
	<form name="itemsearch" method='post' action='narrow'>
		<p>商品名検索</p>
		<input type='text' name='keyword' placeholder="何かお探しですか？"> <input
			type='submit' value='検索！'>
</div>
</head>

<body>
	<div id="search">

		<p>ハードウェア</p>
		<div id="categorysearch">
			<input type="radio" name="hardware" value="0" checked>すべて
			<c:forEach var="hardware" items="${hardware}">
				<input type="radio" name="hardware" value="${hardware.hardwareId}">${hardware.hardware}
			</c:forEach>
			<br>
			<p>カテゴリ</p>
			<input type="radio" name="category" value="0" checked>すべて
			<c:forEach var="category" items="${category}">
				<input type="radio" name="category" value="${category.categoryId}">${category.category}
			</c:forEach>
			<br>

		</div>

		<!-- 値段の絞り込み用のテキストボックス -->
		<div id="pricesearch">
		<br>
			値段下限：<input type="text" name="minprice"><br>
			値段上限：<input type="text" name="maxprice">
		</div>
		<div id="stocksearch">
			<br>
			<input type="radio" name="stock" value="0" checked>すべて
			<input type="radio" name="stock" value="sale">販売中
			<input type="radio" name="stock" value="sold">売りきれ
		</div>
		<button type='submit' value='検索！'>検索</button>
		</form>
	</div>
	<p>
		<a href="f_listing">出品画面へ</a>
	</p>

	<table border="1">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>画像</th>
			<th>itemid</th>
		</tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td><a href="showiteminfo?item_id=${item.itemId}" name="itemId">${item.itemName}</td>
				<td>${item.price}</td>
				<td>${item.itemImage}</td>
				<td>${item.itemId}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>