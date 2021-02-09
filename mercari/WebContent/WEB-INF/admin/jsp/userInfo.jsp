<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr><th>userid</th><th>ユーザー名</th></tr>
	<c:forEach var="user" items="${data}">
		<tr>
		<td>${user.userId}</td>
		<td>${user.userName}</td></tr>
	</c:forEach>
</table>

<form action="grantPoints" method='post'>
<input type='text' placeholder='追加ポイント'>
<input type='submit' value='追加'>
</form>
<form action="banUser" method='post'>
<input type='submit' value='削除'>
</form>
</body>
</html>