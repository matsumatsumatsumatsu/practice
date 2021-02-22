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

.login_out_withdraw {
	margin-left: auto;
	margin-right: auto;
	height: auto;
	background-color: white;
	width: 300px;
}

.logoutBtn {
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

.logoutBtn:active {
	border-bottom: solid 2px #fd9535;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}
</style>
<title>ログアウト</title>
</head>
<body>
	<div class="login_out_withdraw">
		<h1>ログアウト</h1>
		<div class="center">
			<form action="logout" method="post">
				<button type="submit" class="logoutBtn">ログアウト</button>
			</form>
		</div>
	</div>

</body>
</html>
