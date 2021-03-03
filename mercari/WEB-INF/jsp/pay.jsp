<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../css/pay.css"%>
<meta charset="UTF-8">
<title>購入内容の確認</title>
</head>
<body>
	<div class="pay">
		<h1>購入内容の確認</h1>
		<div class="center">
			<table border="1" class="itemImage">
				<tr>
					<td>商品画像</td>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td><img src="images/${item.itemImage}" /></td>
					</tr>
				</c:forEach>
			</table>
			<table border="1" class="wantItem">
				<tr>
					<td>商品名</td>
					<td>値段</td>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td>${item.itemName}</td>
						<td>${item.price}</td>
						<c:set var="price" value="${item.price }"></c:set>
					</tr>
				</c:forEach>
			</table>
			<table border="1" class="mypoint_address">
				<tr>
					<th>残高</th>
					<th>住所</th>
				</tr>
				<c:forEach var="user" items="${user}">
					<tr>
						<td>${user.point}</td>
						<td>${user.address}</td>
						<c:set var="point" value="${user.point }"></c:set>
					</tr>
				</c:forEach>
			</table>

			<c:forEach var="item" items="${data}">
				<a id="pointCheck" href="pay?item_id=${item.itemId}">購入する</a>
				<!-- 個別の取引ページ -->
			</c:forEach>
		</div>
	</div>

	<script>
		if (<c:out value="${price}" /> > <c:out value="${point}" />) {
			alert("ポイントが足りません");
			document.getElementById("pointCheck").removeAttribute("href");
			document.getElementById("pointCheck").style.color = "gray";
		}
	</script>
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
