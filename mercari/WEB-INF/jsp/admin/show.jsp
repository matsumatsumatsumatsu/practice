<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINユーザー一覧</title>
</head>
<body>
	<div class="search">
		<form name="usersearch" method='post' action='search'
			onSubmit="return check()">

			<input type='text' name='userName'> <input type='submit'
				value='検索！'>
		</form>
	</div>

	<h1>ユーザー一覧</h1>
	<table border="1">
		<tr>
			<th>userid</th>
			<th>ユーザー名</th>
		</tr>
		<c:forEach var="user" items="${data}">
			<tr>
				<td><a href="userInfo?user_id=${user.userId }">${user.userId}</a></td>

				<!-- リンク -->
				<td>${user.userName}</td>
				<td><a href="banuser?user_id=${user.userId}">削除</a></td>
			</form></td>
			</tr>

		</c:forEach>
	</table>
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