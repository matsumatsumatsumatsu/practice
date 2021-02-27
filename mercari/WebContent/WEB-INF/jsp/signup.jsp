<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="../../css/style.css"%>
<title>ユーザー登録</title>
</head>
<body>
<a href="f_start" class="topButton">TOPページへ</a>
	<div class="signupPage">

		<div class="center">
		<h1>ユーザー登録</h1>
			<form method='post' action='signup'>
				<input type='text' name='userName' required placeholder="ユーザー名" size="60"><br> <br>
				<input type='text' name='userPassword' required placeholder="パスワード" size="60"><br><br>
				<input type='text' name='realName' required placeholder="本名" size="60"><br> <br>
				<input type='text' name='address' required placeholder="住所" size="60"><br><br>
				<input type='text' name='tel' required placeholder="電話番号" size="60"><br> <br>
				<input type='text' name='mail' required placeholder="メールアドレス" size="60"><br><br>
				<input type='submit' value='登録' class="button">
			</form>
		</div>
	</div>
	<script>
		$(document).on('keydown', function(e) {
			if ((e.which || e.keyCode) == 116) {
			//	alert("F5キーは無効化されています。");
				return false;
			}
		});
	</script>
</body>
</html>
