<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
	<style>
	body {
		background-color: #F8F8FF;
	}
	h1{
		text-align:center;
	}
		.center{
			text-align: center;
		}
		.signup{
			margin-left: auto;
			margin-right: auto;
			height: auto;
			background-color: white;
			width: 500px;
		}

	</style>
	<!-- <link rel="stylesheet" type="text/css" href="css/style.css">  -->
<title>ユーザー登録</title>
</head>
<body>
	<div class="signup">
	<h1>ユーザー登録</h1>
	<div class="center">
	<form method='post' action='signup'>
		<input type='text' name='userName' required placeholder="ユーザー名" size="60"><br><br>
		<input type='text' name='userPassword' required placeholder="パスワード" size="60"><br><br>
		<input type='text' name='realName' required placeholder="本名" size="60"><br><br>
		<input type='text' name='address' required placeholder="住所" size="60"><br><br>
		<input type='text' name='tel' required placeholder="電話番号" size="60"><br><br>
		<input type='text' name='mail' required placeholder="メールアドレス" size="60"	><br><br>
		<input type='submit' value='登録'>
	</form>
</div>
</div>
</body>
</html>
