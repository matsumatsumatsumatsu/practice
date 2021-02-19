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
		<tr>
			<input type="text" name="" placeholder="ユーザーネームの変更">
			<br>
			<input type="text" name="" placeholder="自己紹介文の変更">
			<br>
			<input type="text" name="" placeholname="" der="本名の変更">
			<br>
			<input type="text" name="" placeholder="電話番号の変更">
			<br>
			<input type="text" name="" placeholder="住所の変更">
			<br>
			<input type="submit" value="変更">
			<input type="submit" value="キャンセル">
		</tr>
	</form>
</body>
</html>