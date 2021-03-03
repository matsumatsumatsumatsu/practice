<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>ログアウト</title>
<%@include file="../css/style.css" %>
</head>
<body>
<div class="topOuter">
<a href="f_start" class="topButton">TOPページへ</a>
</div>
	<div class="login_out_withdraw">

		<div class="center">
		<h1>ログアウト</h1>
			<form action="logout" method="post">
				<button type="submit" class="button">ログアウト</button>
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
