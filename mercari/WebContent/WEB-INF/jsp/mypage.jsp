<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<div class="search">
	<form name="itemsearch" method='post' action='search'
		onSubmit="return check()">
		<p>商品名検索</p>
		<input type='text' name='itemName'> <input type='submit'
			value='検索！'>
	</form>
</div>
</head>
<body>
	<table border="1">
		<tr>
			<th>ユーザー名</th>
			<th>ポイント</th>
		</tr>
		<c:forEach var="user" items="${data}">
			<tr>
				<td>${user.userName}</td>
				<td>${user.point}</td>
			</tr>
		</c:forEach>
	</table>

	<div id="buyer">
		<h4>取引中</h4>
		<h4>購入した商品</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>購入/出品</th>
				<th>画像</th>
			</tr>
			<c:forEach var="deal" items="${buyDeal}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${deal.dealId}&user_state=1" name="itemId">${deal.itemId}</a></td>
						<td>${deal.itemName}</td>
						<td>${deal.userState}</td>
						<td>${item.ItemImage}</td>
					</tr>
			</c:forEach>
		</table>

		<h4>出品した商品</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>購入/出品</th>
				<th>画像</th>
			</tr>
			<c:forEach var="deal" items="${sellDeal}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${deal.dealId}&user_state=2" name="itemId">${deal.itemId}</a></td>
						<td>${deal.itemName}</td>
						<!-- <td>${item.ItemImage}</td> -->
						<td>${deal.userState}</td>
					</tr>
			</c:forEach>
		</table>

		<h4>過去の取引</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${item}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="list-side">
		<ul>
			<li><a href="f_showOwnListingList">出品した商品</a></li>
			<li><a href="purchase">購入した商品</a></li>
			<li><a href="point">ポイント</a></li>
			<li><a href="f_editProfile">プロフィール</a></li>
			<li><a href="f_logout">ログアウト</a></li>
			<li><a href="f_withdraw">退会</a></li>
		</ul>
	</div>
</body>
</html>