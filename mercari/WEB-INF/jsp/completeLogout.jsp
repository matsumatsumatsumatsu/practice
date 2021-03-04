<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<meta charset="UTF-8">
<title>ログアウト</title>
<%@include file="../css/style.css"%>
</head>
<body>
<div class="center">
	<p>ログアウトしました</p>
	<div class="topOuter">
	<a href="f_start" class="button">ok</a>
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