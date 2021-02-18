<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーの個別表示</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>出品者</th>
			<c:forEach var="user" items="${user}">
				<td>${user.userName}</td>
			</c:forEach>
		</tr>
	</table>

	<table border="1">
		<tr>
			<th>この出品者の商品</th>
			<c:forEach var="item" items="${item}">
					<td><a href="showiteminfo?item_id=${item.itemId}">${item.itemName}</a></td>
			</c:forEach>
		</tr>
	</table>

</body>
</html>