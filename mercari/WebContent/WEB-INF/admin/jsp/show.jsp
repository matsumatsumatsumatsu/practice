<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="search">
		<form name="usersearch" method='post' action='search'
			onSubmit="return check()">

			<input type='text' name='userName'> <input type='submit'
				value='検索！'>
		</form>
	</div>
	<table border="1">
		<tr>
			<th>userid</th>
			<th>ユーザー名</th>
		</tr>
		<c:forEach var="user" items="${data}">
			<tr>
				<a href=""><td>${user.userId}</td></a>
				<!-- リンク -->
				<td>${user.userName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>