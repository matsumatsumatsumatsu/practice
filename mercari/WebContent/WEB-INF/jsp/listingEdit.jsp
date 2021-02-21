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
		<c:forEach var="item" items="${item}">
			<input type="hidden" name="itemId" value="${item.itemId}">
		</c:forEach>
		<c:forEach var="item" items="${item}">
			<input type="file" name="image" value="${item.itemImage}" placeholder="商品画像の変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="name" value="${item.itemName}"placeholder="商品名の変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="explanation" value="${item.itemExplanation}" placeholder="商品説明の変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="category" value="${item.categoryId}" placeholder="ゲームのジャンルの変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="hardware" value="${item.hardwareId}" placeholder="ハードの変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="term" value="${item.term}" placeholder="発送までの期間の変更">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
			<input type="text" name="price" value="${item.price}" placeholder="値段の変更">
		</c:forEach><br>
		<input type="submit" value="変更">
	</form>
</body>
</html>