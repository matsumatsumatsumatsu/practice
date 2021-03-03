<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>ログイン</title>
<%@include file="../css/style.css"%>
</head>
<body>
<div class="topOuter">
<a href="f_start" class="topButton">TOPページへ</a>
</div>
	<div class="login_out_withdraw">

		<div class="center">
		<h1>ログイン</h1>
			<form action="login" method="post">
				<input type='text' name='userName' required placeholder="ユーザー名" size="30"><br>
				<br> <input type='password' name='userPassword' required placeholder="パスワード" size="30" id="userPassword" ><br>
				<div id="passwordcheck login"><input type="checkbox" id="password-check">パスワードを表示する <br><br></div> <br>
				<br>
				<input type="submit" value="ログイン" class="button">
			</form>
			<a href="f_signup" class="button">ユーザー登録画面へ</a>
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
	<script>
	 const pwd = document.getElementById('userPassword');
	 const pwdCheck = document.getElementById('password-check');
	 pwdCheck.addEventListener('change', function() {
	     if(pwdCheck.checked) {
	         pwd.setAttribute('type', 'text');
	     } else {
	         pwd.setAttribute('type', 'password');
	     }
	 }, false);
 </script>
</body>
</html>
