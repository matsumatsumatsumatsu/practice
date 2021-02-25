<%@page pageEncoding="WIndows-31J"
	contentType="text/html;charset=Windows-31J"%>

<html>
<head>
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="loginAdmin" method="post">
		名前：<input type="text" name="adminName" /><br> パスワード：<input
			type="text" name="adminPassword" /><br>
		<br> <input type="submit" value="ログイン">
	</form>
</body>
</html>