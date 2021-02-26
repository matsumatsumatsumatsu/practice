<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../css/listingList.css"%>
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
		<h4>出品した商品</h4>
		<h4>出品中</h4>
		<table border="1" class="tablelist">
			<tr>

				<th>商品名</th>
				<th>画像</th>

			</tr>
			<c:forEach var="item" items="${item}">
				<tr>
					<td><a href="showiteminfo?item_id=${item.itemId}">${item.itemName}</a></td>

					<td><img src="images/${item.itemImage}" /></td>
				</tr>
			</c:forEach>
		</table>

		<h4>取引中</h4>
		<table border="1" class="tablelist">
			<tr>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="deal" items="${sellDeal}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${deal.dealId}&user_state=2" name="itemId">${deal.itemName}</a></td>
						<td><img src="images/${deal.itemImage}" /></td>
					</tr>
			</c:forEach>
		</table>

		<h4>過去の取引</h4>
		<table border="1" class="tablelist">
			<tr>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="history" items="${sellHistory}">
					<tr>
						<td><a href="showDealingInfo?deal_id=${history.dealId}&user_state=2" name="itemId">${history.itemName}</a></td>
						<td><img src="images/${history.itemImage}" /></td>
					</tr>
			</c:forEach>
		</table>

	</div>

	<div id="list-side">
		<ul class="list">
			<li><a href="purchase">購入した商品</a></li>
			<li><a href="showprofile">プロフィール</a></li>
			<li><a href="logout">ログアウト</a></li>
		</ul>
	</div>


</body>
</html>