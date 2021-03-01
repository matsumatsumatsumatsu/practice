<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../css/mypage.css"%>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<p style="display:none;" id="flag">${flag}</p>
<div class="header">

	<div class="top">
		<a href="f_start" class="topBtn"><img src="images/caripaku.png" class="images"></a>
	</div>
	<div class="search" style="display:inline-flex">
			<form name="itemsearch" method='post' action='search' onSubmit="return check()" class="itemsearch">
					<input type='text' name='keyword' class="searchText" placeholder="何かお探しですか？">
					<input type='submit' value='検索！' class="searchBtn">
			</form>

	</div>

	<!-- 非login→ログインjsp、登録 login→マイページjsp、通知 -->
	<div class="headerColumn">
		<p id = "signup">
			<a href="f_signup" class="headerBtn">ユーザー登録画面へ</a>
		</p>
		<!-- 後々コメントアウト -->
		<p id = "login">
			<a href="f_login" class="headerBtn">ログイン</a>
		</p>
		<p id = "mypage">
			<a href="showprofile" class="headerBtn">マイページ</a>
		</p>
		<p id = "notice">
			<a href="showNoticeList" class="headerBtn">通知</a>
		</p>

	</div>
</div>
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
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${buyDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=1"
										name="itemId">${deal.itemName}</a></td>
									<td><img src="images/${deal.itemImage}" /></td>
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
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${sellDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=2"
										name="itemId">${deal.itemName}</a></td>
									<td><img src="images/${deal.itemImage}" /></td>
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
									<th>商品名</th>
									<th>画像</th>
								</tr>
								<c:forEach var="history" items="${buyHistory}">
									<tr>
										<td><a
											href="showDealingInfo?deal_id=${history.dealId}&user_state=1"
											name="itemId">${history.itemName}</a></td>
										<td><img src="images/${history.itemImage}" /></td>
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
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="history" items="${sellHistory}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${history.dealId}&user_state=2"
										name="itemId">${history.itemName}</a></td>
									<td><img src="images/${history.itemImage}" /></td>
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
				<li><a href="f_editProfile">プロフィール編集</a></li>
				<li><a href="f_logout">ログアウト</a></li>
				<li><a href="f_withdraw">退会</a></li>
			</ul>
		</div>
	</div>

	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		var flag=document.getElementById("flag").innerText;
		if (flag == "OK") {
			$("#login").css("display","none");
			$("#signup").css("display","none");
			<!--$("#login").html('<a href="showprofile" class="headerBtn">マイページ</a>');-->
			<!--
			document.getElementById("stockCheck").style.color = "gray";
			-->
		}else{
			$("#mypage").css("display","none");
			$("#notice").css("display","none");
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