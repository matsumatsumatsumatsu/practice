<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../css/purchase.css"%>
<meta charset="UTF-8">
<title>マイページ</title>




</head>
<body>
	<div id="buyer">

		<h4>購入した商品</h4>
		<h4>取引中</h4>
		<table border="1" class="tablelist">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="deal" items="${buyDeal}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${deal.dealId}&user_state=1" name="itemId">${deal.itemId}</a></td>
						<td>${deal.itemName}</td>
						<td>${deal.itemImage}</td>
					</tr>
			</c:forEach>
		</table>
		</table>
		<h4>過去の取引</h4>
		<table border="1"  class="tablelist">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="history" items="${buyHistory}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${history.dealId}&user_state=1" name="itemId">${history.itemId}</a></td>
						<td>${history.itemName}</td>
						<td>${history.itemImage}</td>
					</tr>
			</c:forEach>
		</table>
			</div>

		<div id="list-side">
			<ul class="list">
				<li><a href="showNoticeList">通知</a></li>
				<li><a href="showOwnListingList">出品した商品</a></li>
				<li><a href="purchase">購入した商品</a></li>
				<li><a href="point">ポイント</a></li>
				<li><a href="f_editProfile">プロフィール</a></li>
				<li><a href="f_logout">ログアウト</a></li>
				<li><a href="f_withdraw">退会</a></li>
			</ul>
		</div>


</body>
</html>