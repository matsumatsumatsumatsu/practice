<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集</title>
</head>
<body>
		<form action="editProfile" method="post">
			<c:forEach var="user" items="${data}">
				<input type="text" name="name" value="${user.userName}" placeholder="ユーザーネームの変更">
			</c:forEach><br>
			<c:forEach var="user" items="${data}">
			<input type="text" name="pass" value=""${user.userPassword} placeholder="パスワードの変更">
			</c:forEach><br>
			<c:forEach var="user" items="${data}">
			<input type="text" name="real" value="${user.realName}" placeholder="本名の変更">
			</c:forEach><br>
			<c:forEach var="user" items="${data}">
			<input type="text" name="tel" value="${user.tel}" placeholder="電話番号の変更">
			</c:forEach><br>
			<c:forEach var="user" items="${data}">
			<input type="text" name="address" value="${user.address}" placeholder="住所の変更">
			</c:forEach><br>
			<c:forEach var="user" items="${data}">
			<input type="text" name="prof" value="${user.profile}" placeholder="自己紹介文の変更">
			</c:forEach>
			<br>
			<input type="submit" value="変更">
		</form>
</body>
</html>