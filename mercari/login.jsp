<%@page pageEncoding="WIndows-31J"
	contentType="text/html;charset=Windows-31J"%>

<html>
<head>
<title>���O�C��</title>
</head>
<body>
	<h1>���O�C��</h1>
	<form action="loginAdmin" method="post">
		���O�F<input type="text" name="adminName" /><br> �p�X���[�h�F<input
			type="text" name="adminPassword" /><br>
		<br> <input type="submit" value="���O�C��">
	</form>
	<script>
		$(document).on('keydown', function(e) {
			if ((e.which || e.keyCode) == 116) {
			//	alert("F5�L�[�͖���������Ă��܂��B");
				return false;
			}
		});
	</script>
</body>
</html>