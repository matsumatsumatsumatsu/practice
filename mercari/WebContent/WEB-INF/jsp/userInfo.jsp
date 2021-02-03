<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーの個別表示</title>
</head>
<body>
	<table border = "1">
		<tr>
		<th>出品者の名前</th>
		<th>プロフィール</th>
		<th>出品物</th>
		<c:forEach var = "user" items = "${data}">
			<td>${user.userName}</td>
			<td>${user.profile}</td>
			<!-- ここでループさせたい -->
			<a href = "">
			<td>${user.listingInfo}</td>
			</a>
		</c:forEach>
		</tr>
	</table>
</body>
</html>