<%@page pageEncoding="WIndows-31J"
	contentType="text/html;charset=Windows-31J"%>

<html>
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="loginAdmin" method="post">
		名前：<input type="text" name="adminName" /><br> パスワード：<input
			type="text" name="adminPassword" /><br>
		<br> <input type="submit" value="ログイン">
	</form>
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