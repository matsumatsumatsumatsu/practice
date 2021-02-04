<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知の閲覧</title>
</head>
<body>
<div class="l-content">
<table border="1">
	<tr><th>notice_id</th><th>通知を受け取るユーザー</th><th>通知内容</th></tr>
	<c:forEach var="notice" items="${data}">
		<tr><td>${notice.noticeId}</td><td>${notice.noticeId}</td><td>${notice.comment}</td></tr>
	</c:forEach>
</table>
<div>
</body>
</html>