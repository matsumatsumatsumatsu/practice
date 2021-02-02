<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href = "css/ThreadStyle.css" rel = "stylesheet">

<title>商品閲覧</title>

</head>

<body>
	<table border="1">
		<c:forEach var = "Item" items = "${data}">
		<tr>
			<td>Item.itemImage</td>
			<td>Item.itemName</td>
			<td>Item.itemExplanation</td>
			<td>Item.hardwareId</td>
			<td>Item.categoryId</td>
			<td>Item.term</td>
			<td>Item.price</td>
		</tr>>
		</c:forEach>
	</table>

	<!-- 仮 -->>
	<c:form action = "" method = "post">
		<input type = "text" name = "openChat"><br>
		<input type = "submit" value = "コメントする">
	</c:form>

	<p><a href = "/pay/">商品購入</a></p>
	<p><a href = "/listingEdit/">出品物の編集</a></p>
	<p><a href = "/userInfo/">ユーザーの確認</a></p>
	<p><a href = "/category/">カテゴリー検索</a></p>
</body>
</html>