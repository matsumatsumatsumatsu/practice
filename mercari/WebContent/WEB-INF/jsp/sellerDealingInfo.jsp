<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売り手の商品取引画面</title>
<%@include file="../../css/sellerDealInfo.css"%>
</head>
<body>
<p style="display:none;" id="flag">${flag}</p>
<div class="header">

	<div class="top">
		<a href="f_start" class="topBtn">TOPページへ</a>
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
<div class="center">
<div class="left">
	<table border="1">
		<c:forEach var="item" items="${item}">
			<tr>
			<th>ItemID</th>
				<td>${item.itemId}</td>
			</tr>
			<tr>
				<th>商品名</th>
				<td>${item.itemName}</td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<c:forEach var="deal" items="${deal}">
			<tr>
				<th>取引ID</th>
				<td>${deal.dealId}</td>
			</tr>
			<tr>
				<th>商品ID</th>
				<td>${deal.itemId}</td>
			</tr>
			<tr>
				<th>取引状況</th>
				<td>${deal.dealState}</td>
			</tr>
			<c:set var="stateCheck" value="${deal.dealState}"></c:set>
		</c:forEach>
	</table>
	</div>
	<div class="right">
	<c:forEach var="deal" items="${deal}">
		<div id = "dispatch">
			<form action="dispatch?deal_id=${deal.dealId}&user_state=2" method="post">
				<input type="submit" value="発送しました" class="button">
			</form>
		</div>
	</c:forEach>

	<table border="1">
		<tr>
			<td>チャットID</td>
			<td>本文</td>
			<td>投稿日時</td>
		</tr>
		<c:forEach var="chat" items="${chat}">
			<tr>
				<td>${chat.chatId}</td>
				<td>${chat.	text}</td>
				<td>${chat.date}</td>
			</tr>
		</c:forEach>
	</table>

	<c:forEach var="deal" items="${deal}">
		<form action="sendPrivateChat?deal_id=${deal.dealId}&user_state=2" method="post">
			<input type="text" name="text" class="textBox"><br> <input
				type="submit" value="コメントする" class="button">
		</form>
</div>
<div class = "leftBtn">
			<p>
				<a href="canceldeal?deal_id=${deal.dealId}&user_state=1"" class="button">取引をキャンセルする</a>
			</p><br>

	</c:forEach>

	<p>
		<a href="f_start" class="button">TOPページへ</a>
	</p>
	</div>
	</div>

	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		<!-- 1→取引中（取引開始）、2→取引キャンセル、3→取引完了（受け取り終了）、4→商品発送 -->
		if (<c:out value="${stateCheck}" /> == 4) {
			$("#dispatch").empty();
			$("#dispatch").html('<p class="button">商品の発送が完了しました。</p>');
			<!-- document.getElementById("stockCheck").style.color = "gray"; -->
		}

		if (<c:out value="${stateCheck}" /> == 2) {
			$("#dispatch").empty();
			$("#dispatch").html('<p class="button">取引がキャンセルされました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 3) {
			$("#dispatch").empty();
			$("#dispatch").html('<p class="button">商品の受け取りが完了しました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2 ||<c:out value="${stateCheck}" /> == 4) {
			$("#cancel").empty();
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
