<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>ログイン</title>
<%@include file="../../css/style.css"%>
</head>
<body>
	<div class="login_out_withdraw">

		<div class="center">
		<h1>ログイン</h1>
			<form action="login" method="post">
				<input type="text" name="userName" placeholder="名前" /><br> <input
					type="text" name="userPassword" placeholder="パスワード" /> <br>
				<br>
				<input type="submit" value="ログイン" class="button">
			</form>
		</div>
	</div>
</body>
</html>
