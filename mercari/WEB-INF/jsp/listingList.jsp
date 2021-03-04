<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<%@include file="../css/listingList.css"%>
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
	<div class="main">
	<div id="list-side">
		<ul class="list">
			<li><a href="showprofile">マイページ</a></li>
			<li><a href="showNoticeList">通知</a></li>
			<li><a href="showOwnListingList">出品した商品</a></li>
			<li><a href="purchase">購入した商品</a></li>
			<li><a href="f_editProfile">プロフィール</a></li>
			<li><a href="f_logout">ログアウト</a></li>
			<li><a href="f_withdraw">退会</a></li>
		</ul>
	</div>
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
	</div>
	<script>
		$(document).on('keydown', function(e) {
			if ((e.which || e.keyCode) == 116) {
			//	alert("F5キーは無効化されています。");
				return false;
			}
		});
	</script>
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

</body>
</html>