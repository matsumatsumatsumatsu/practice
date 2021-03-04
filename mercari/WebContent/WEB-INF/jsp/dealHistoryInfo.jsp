<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取引履歴</title>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
</head>
<body>
	<h4>取引が完了しました</h4>
	<table border="1">
		<c:forEach var="user" items="${data}">
			<tr>
				<a href="">
					<td>${user.itemImage}</td>
				</a>
				<!-- 複数の表から持ってこれるのか？ -->
				<td>${user.itemName}</td>
				<td>${user.price}</td>
				<td>${user.date}</td>
				<td>${user.address}</td>
				<td>${user.itemId}</td>
				<a href="">
					<td>${user.sellerId}</td>
				</a>
				<a href="">
					<td>${user.buyerId}</td>
				</a>
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