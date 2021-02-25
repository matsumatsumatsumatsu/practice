<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.header {
	background-color: white;
	margin-bottom: 30px;
	height: 150px;
	border-bottom: 2px solid black;
}

.search {
	display: inlone-block;
	text-align: center;
	float: right;
	margin-right: 100px;
}
/* .top{
			text-align: right;
			float: left;

		} */
.notify {
	color: black;
	text-align: right;
	display: inline-block;
	margin-left: 920px;
}

.mypage {
	/*color: black;
	text-align: right;
	margin-left: 20px;*/
	display: inline-block;
	margin-left: 130px;
	height: auto;
	background-color: white;
	width: auto;
}

body {
	background-color: #F8F8FF;
}

.right {
	display: inline-block;
	float: right;
	width: 650px;
}

#list-side {
	display: inline-block;
	float: left;
	width: 300px;
	margin-right: 50px;
	margin-left: 10px;
	margin-top: 40px;
}

.list {
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	margin: 0 auto;
	padding: 0 0 0 0 !important;
}

.list li {
	color: #2d8fdd;
	border-left: solid 6px #f4b364;
	background: #fdf2e3;
	margin-bottom: 15px;
	line-height: 1.5;
	padding: 0.5em;
	border-bottom: solid 2px #dadada;
	list-style-type: none;
}

.userName_Point {
	margin-left: 30px;
	margin-right: auto;
	margin-top: 20px;
	border-collapse: collapse;
}

.userName_Point tr:last-child {
	border-bottom: solid 1px #ddd;
}

.userName_Point th {
	text-align: center;
	padding: 10px 0;
	border-right: solid 1px #ddd;
	border-left: solid 1px #ddd;
	width: 155px;
	font-size: 16px;
}

.userName_Point th:nth-child(1) {
	background-color: grey;
	color: white;
}

.userName_Point th:nth-child(2) {
	background-color: grey;
	color: white;
}

.userName_Point tr:nth-child(2) td {
	font-size: 25px;
	font-weight: bold;
	padding-top: 10px;
}

.userName_Point td {
	text-align: center;
	padding-top: 10px;
	border-right: solid 1px #ddd;
	border-left: solid 1px #ddd;
}

.hidden_box {
	margin: 2em 0;
	padding: 0;
}

.hidden_box label {
	padding: 15px;
	font-weight: bold;
	border: solid 2px black;
	cursor: pointer;
}

.hidden_box label:hover {
	background: #efefef;
}

.hidden_box input {
	display: none;
}

.hidden_box .hidden_show {
	height: 0;
	padding: 0;
	overflow: hidden;
	opacity: 0;
	transition: 0.8s;
}

.hidden_box input:checked ~ .hidden_show {
	padding: 10px 0;
	height: auto;
	opacity: 1;
}

label {
	display: block;
	width: 450px;
	margin-right: 20px;
}

.dealing {
	display: inline-block;
}
</style>
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
						<table border="1">
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


						<table border="1">
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
							<table border="1">
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
						<table border="1">
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