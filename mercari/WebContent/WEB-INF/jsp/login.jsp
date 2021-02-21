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
		.login_out_withdraw{
			margin-left: auto;
			margin-right: auto;
			height: auto;
			background-color: white;
			width: 300px;
		}

	</style>
<title>ログイン</title>
</head>
<body>
	<div class="login_out_withdraw">
	<h1>ログイン</h1>
	<div class = "center">
	<form action="login" method="post">
		<input type="text" name="userName" placeholder="名前"/><br>
		<input type="text" name="userPassword" placeholder="パスワード"/>
		<br><br><input type="submit" value="ログイン">
	</form>
</div>
</div>
</body>
</html>
