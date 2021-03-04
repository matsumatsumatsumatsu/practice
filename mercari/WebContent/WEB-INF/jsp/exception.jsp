<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>例外</title>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
</head>
<body>

	<p>例外が発生しました</p>
	<p>
		<a href="f_start">TOPページへ</a>
	</p>
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