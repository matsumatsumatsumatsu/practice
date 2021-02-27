<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知の閲覧</title>
<%@include file="../../css/style.css" %>
</head>
<body>
<div class="notifications">

<div class="center">
<h1>お知らせ</h1>

		<table border="1">
			<c:forEach var="notice" items="${notice}">
				<tr>
					<td height="50px">${notice.comment}</td>
					<td>${notice.date}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<a href="f_start" class="button">TOPページへ</a>
	</p>
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