<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取引履歴の閲覧</title>
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
	<h4>取引中</h4>
	<table border="1">
		<tr>
			<th>itemid</th>
			<th>商品名</th>
			<th>画像</th>
		</tr>
		<c:forEach var="item" items="${data}">

			<tr>
				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemImage}</td>
			</tr>
	</table>
	<form action="terminate" method='post'>
		<input type='submit' value='削除'>
	</form>
	</c:forEach>
	</table>
	<h4>過去の取引</h4>
	<table border="1">
		<tr>
			<th>itemid</th>
			<th>商品名</th>
			<th>画像</th>
		</tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemImage}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>