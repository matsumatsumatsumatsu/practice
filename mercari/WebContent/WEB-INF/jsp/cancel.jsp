<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
</head>
<body>
	<h1>取引キャンセル</h1>
	<form name="cancel" method='post' action='cancel'>
		<input type="submit" value="キャンセル">
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