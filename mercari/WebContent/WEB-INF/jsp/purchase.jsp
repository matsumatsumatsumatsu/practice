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
	<div id="buyer">
		<h4>購入した商品</h4>
		<h4>取引中</h4>
		<table border="1">
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
		<table border="1">
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

	<div id="l-side">
		<ul>
			<li><a href="showOwnListingList">出品した商品</a></li>
			<li><a href="point">ポイント</a></li>
			<li><a href="showprofile">プロフィール</a></li>
			<li><a href="logout">ログアウト</a></li>
			<li><a href="f_withdraw">退会</a></li>
		</ul>
	</div>
</body>
</html>