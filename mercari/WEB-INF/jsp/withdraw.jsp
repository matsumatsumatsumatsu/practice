<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<title>退会</title>
<%@include file="../css/style.css" %>
</head>
<body>
<div class="topOuter">
<a href="f_start" class="topButton">TOPページへ</a>
</div>
	<div class="login_out_withdraw">

		<div class="center">
		<h1>退会</h1>
			<form action="withdraw" method="post">
				<label>パスワードを入力</label> <input type="text" name="userPassword" /><br>
				<br>
				<button type="submit" class="button">退会</button>
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
