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
			<th>userid</th>
			<th>ユーザー名</th>
			<th>住所</th>
			<th>本名</th>
			<th>電話番号</th>
			<th>メールアドレス</th>
			<th>パスワード</th>
		</tr>
		<c:forEach var="user" items="${data}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.realName}</td>
				<td>${user.address}</td>
				<td>${user.tel}</td>
				<td>${user.mail}</td>
				<td>${user.userPassword}</td>
				<td><a href="banuser?user_id=${user.userId}">削除</a></td>
			</tr>
		</c:forEach>
	</table>

	<form action="grantPoints" method='post'>
		<input type='text' placeholder='追加ポイント'> <input type='submit'
			value='追加'>
	</form>

</body>
</html>