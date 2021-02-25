<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../css/mypage.css"%>
<meta charset="UTF-8">
<title>マイページ</title>

<div class="header">
	<div class="search">
		<form name="itemsearch" method='post' action='search' onSubmit="return check()">
				<input type='text' name='keyword' style="width: 800px; height: 40px; margin-top: 30px" placeholder="何かお探しですか？">
				<input type='submit' value='検索！' style="height: 40px">
		</form>
	</div>
</div>
</head>
<body>
	<div class="mypage">
		<div class="right">
			<table border="1" class="userName_Point">
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

			<div class="dealing">
				<h4>取引中</h4>
				<div class="hidden_box">
					<label for="label1">購入した商品</label> <input type="checkbox"
						id="label1" />
					<div class="hidden_show">

						<h4>購入した商品</h4>
						<table border="1" class="innerTable">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${buyDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=1"
										name="itemId">${deal.itemId}</a></td>
									<td>${deal.itemName}</td>
									<td>${deal.itemImage}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>出品した商品</h4>
				<div class="hidden_box">
					<label for="label2">出品した商品</label> <input type="checkbox"
						id="label2" />
					<div class="hidden_show">


						<table border="1" class="innerTable">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${sellDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=2"
										name="itemId">${deal.itemId}</a></td>
									<td>${deal.itemName}</td>
									<td>${deal.itemImage}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>過去の取引</h4>
				<div class="hidden_box">
					<label for="label3">過去の取引</label> <input type="checkbox"
						id="label3" />
					<div class="hidden_show">
						<div id="history">

							<h4>購入した商品</h4>
							<table border="1" class="innerTable">
								<tr>
									<th>itemid</th>
									<th>商品名</th>
									<th>画像</th>
								</tr>
								<c:forEach var="history" items="${buyHistory}">
									<tr>
										<td><a
											href="showDealingInfo?deal_id=${history.dealId}&user_state=1"
											name="itemId">${history.itemId}</a></td>
										<td>${history.itemName}</td>
										<td>${history.itemImage}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>過去出品した商品</h4>
				<div class="hidden_box">
					<label for="label4">出品した商品</label> <input type="checkbox"
						id="label4" />
					<div class="hidden_show">
						<table border="1" class="innerTable">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="history" items="${sellHistory}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${history.dealId}&user_state=2"
										name="itemId">${history.itemId}</a></td>
									<td>${history.itemName}</td>
									<td>${history.itemImage}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div id="list-side">
			<ul class="list">
				<li><a href="showNoticeList">通知</a></li>
				<li><a href="showOwnListingList">出品した商品</a></li>
				<li><a href="purchase">購入した商品</a></li>
<!-- 				<li><a href="point">ポイント</a></li> -->
				<li><a href="f_editProfile">プロフィール</a></li>
				<li><a href="f_logout">ログアウト</a></li>
				<li><a href="f_withdraw">退会</a></li>
			</ul>
		</div>
	</div>
</body>
</html>