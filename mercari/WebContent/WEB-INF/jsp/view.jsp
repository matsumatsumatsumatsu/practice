<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>ユーザー一覧</title>
</head>
<body>
<h1>ユーザー一覧</h1>
<table border="1">
	<tr><th>ユーザー番号</th><th>ユーザー名</th><th>本名</th></tr>
	<c:forEach var="user" items="${date}">
		<tr><td>${user.user_id}</td><td>${user.user_name}</td><td>${user.real_name}</td></tr>
	</c:forEach>
</table>
<p><a href="/mercari/">スタートへ</a></p>

</body>
</html>

