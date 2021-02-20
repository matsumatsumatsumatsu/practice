<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>出品物の編集</title>
</head>
<body>



	<form action="editListing" method="post">
		<c:forEach var="item" items="${data}">
			<input type="hidden" name="itemId" value="${item.itemId}">
		</c:forEach>
		<input type="file" name="image" placeholder="商品画像の変更">
		<br>
		<input type="text" name="name" placeholder="商品名の変更">
		<br>
		<input type="text" name="explanation" placeholder="商品説明の変更">
		<br>
		<input type="text" name="category" placeholder="ゲームのジャンルの変更">
		<br>
		<input type="text" name="hardware" placeholder="ハードの変更">
		<br>
		<input type="text" name="term" placeholder="発送までの期間の変更">
		<br>
		<input type="text" name="price" placeholder="値段の変更">
		<br>
		<input type="submit" value="変更">

	</form>
</body>
</html>