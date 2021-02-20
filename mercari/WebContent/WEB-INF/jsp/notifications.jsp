<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知の閲覧</title>
</head>
<body>
	<div class="l-content">
		<table border="1">
			<c:forEach var="notice" items="${notice}">
				<tr>
					<td>${notice.comment}</td>
					<td>${notice.date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>