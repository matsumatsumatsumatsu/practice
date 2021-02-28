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
			<div id="errorMessage"></div>
				<input type='text' name='userName' required placeholder="ユーザー名" size="60"><br> <br>
				<input type='password' name='userPassword' required placeholder="パスワード" size="60" id="userPassword" ><br>
				<div id="passwordcheck"><input type="checkbox" id="password-check">パスワードを表示する <br><br></div>
				<input type='password' name='userPasswordConfirm' required placeholder="確認用パスワード" size="60" id="userPasswordConfirm"  oninput="CheckPassword(this)"><br>
				<div id="passwordcheck"><input type="checkbox" id="password-check2">パスワードを表示する <br><br></div>
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
<script>
	function CheckPassword(confirm){
		// 入力値取得
		var input1 = userPassword.value;
		var input2 = userPasswordConfirm.value;
		// パスワード比較
		if(input1 != input2){
			userPasswordConfirm.setCustomValidity("入力値が一致しません。");
		}else{
			userPasswordConfirm.setCustomValidity('');
		}
	}
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
 <script>
 const pwd2 = document.getElementById('userPasswordConfirm');
 const pwdCheck2 = document.getElementById('password-check2');
 pwdCheck2.addEventListener('change', function() {
     if(pwdCheck2.checked) {
         pwd2.setAttribute('type', 'text');
     } else {
         pwd2.setAttribute('type', 'password');
     }
 }, false);
 </script>
</body>
</html>
