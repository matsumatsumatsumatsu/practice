<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>���i�\��</title>

</head>

<body>
	<table border="1">
		<tr><td>�摜</td><td>���i��</td><td>���i����</td><td>�n�[�h</td><td>�W������</td><td>��������</td><td>�l�i</td></tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemImage}</td>
				<td>${item.itemName}</td>
				<td>${item.itemExplanation}</td>
				<td>${item.hardwareId}</td>
				<td>${item.categoryId}</td>
				<td>${item.term}</td>
				<td>${item.price}</td>
			</tr>

	</table>
	<br>

	<!-- forEach��� -->
	<form action = "showItemInfo" method = "post">
		<input type = "text" name = "openChat"><br>
		<input type = "submit" value = "�R�����g����">
	</form>

	<p><a href = "pay?item_id=${item.itemId}">���i�w��</a></p>
	</c:forEach>
	<form action = "banItem" method = "post">
		<input type = "submit" name = "�폜">
	</form>
	<p><a href = "/userInfo/">���[�U�[�̊m�F</a></p>
	<p><a href = "/category/">�J�e�S���[����</a></p>

</body>
</html>