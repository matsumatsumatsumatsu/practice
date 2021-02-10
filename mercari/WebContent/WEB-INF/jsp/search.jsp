<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<div class="search">
	<form name="itemsearch" method='post' action='search'>
		<p>商品名検索</p>
		<input type='text' name='keyword' placeholder="何かお探しですか？"> <input type='submit'
			value='検索！'>
	</form>
</div>
</head>

<body>
	<div id="search">
		<form method='post' action="search">
			<div id="categorysearch">
			<c:forEach var="hardware" items="${hardware}">
				<input type="radio" name="hardware" value="${hardware.hardwareId}">${hardware.hardware}
			</c:forEach>
			
			<c:forEach var="category" items="${category}">
				<input type="radio" name="category" value="${category.categoryId}">${category.category}
			</c:forEach>
				
			</div>
			
			<!-- 値段の絞り込み用のテキストボックス -->
			<div id="pricesearch">
				<input type="text" name="minvalue" placeholder="minvalue" > <input type="text"
					name="maxvalue" placeholder="maxvalue">
			</div>
			<div id="stocksearch">
				<input type="checkbox" name="sale"><label for="sale">販売中</label>
				<input type="checkbox" name="sold"><label for="sold">売りきれ</label>
			</div>
			<button type='submit' value='検索！'></button>
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
				<td>${item.itemName}</td>
				<td>${item.price}</td>
				<td>${item.itemImage}</td>
				<td>${item.itemId}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>