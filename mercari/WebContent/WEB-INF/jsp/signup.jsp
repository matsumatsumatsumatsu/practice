<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>ユーザー登録</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<form method='post' action='signup'>
		ユーザー名<input type='text' name='userName' required><br>
		パスワード<input type='text' name='userPassword' required><br>
		 本名<input type='text' name='realName' required><br>
		 住所<input type='text' name='address' required><br>
		 電話番号<input type='text' name='tel' required><br>
		メールアドレス<input type='text' name='mail' required><br>
		<input type='submit' value='登録'>
	</form>
</body>
</html>