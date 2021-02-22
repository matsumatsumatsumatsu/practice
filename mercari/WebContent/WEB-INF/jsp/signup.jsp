<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<style>
body {
	background-color: #F8F8FF;
}

h1 {
	text-align: center;
}

.center {
	text-align: center;
}

.signup {
	margin-left: auto;
	margin-right: auto;
	height: auto;
	background-color: white;
	width: 500px;
}

.signupBtn {
	position: relative;
	display: inline-block;
	padding: 0.25em 0.5em;
	text-decoration: none;
	color: #FFF;
	background: #fd9535; /*背景色*/
	border-bottom: solid 2px #d27d00; /*少し濃い目の色に*/
	border-radius: 4px; /*角の丸み*/
	box-shadow: inset 0 2px 0 rgba(255, 255, 255, 0.2), 0 2px 2px
		rgba(0, 0, 0, 0.19);
	font-weight: bold;
	border-style: solid;
	width: 120px;
	margin-bottom: 10px;
}

.signupBtn:active {
	border-bottom: solid 2px #fd9535;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
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
				<input type='text' name='userName' required placeholder="ユーザー名"
					size="60"><br> <br> <input type='text'
					name='userPassword' required placeholder="パスワード" size="60"><br>
				<br> <input type='text' name='realName' required
					placeholder="本名" size="60"><br> <br> <input
					type='text' name='address' required placeholder="住所" size="60"><br>
				<br> <input type='text' name='tel' required placeholder="電話番号"
					size="60"><br> <br> <input type='text'
					name='mail' required placeholder="メールアドレス" size="60"><br>
				<br> <input type='submit' value='登録' class="signupBtn">
			</form>
		</div>
	</div>
</body>
</html>
