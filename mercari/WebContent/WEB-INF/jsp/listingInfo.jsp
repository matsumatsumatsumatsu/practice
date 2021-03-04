<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String token = (String)session.getAttribute("flag");
%>
<html>
<head>
<%@include file="../../css/item.css"%>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<title>商品表示</title>
</head>
<body>
<p style="display:none;" id="flag">${flag}</p>
<p style="display:none;" id="userId">${userId}</p>
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
			<a href="showprofile" class="headerButton">マイページ</a>
		</p>
		<p id = "notice">
			<a href="showNoticeList" class="headerButton">通知</a>
		</p>

	</div>
</div>

	<div class="itemlist">

		<c:forEach var="item" items="${item}">

			<h1>${item.itemName}</h1>
			<div class="left">
				<img src="images/${item.itemImage}" width="300">
			</div>
			<table  border="1" style="border: 1px solid black; border-collapse: collapse;" class="item">

				<tr>
					<th>出品者</th>
					<c:forEach var="user" items="${user}">
						<td><a href="showuserinfo?user_id=${user.userId}">${user.userName}</a></td>
					</c:forEach>
				</tr>
				<tr>
					<th>ハード</th>
					<td><a
						href="narrow?hardware=${item.hardwareId}&keyword=&category=0&minprice=&maxprice=&stock=">${item.hardware}</a></td>
				</tr>
				<tr>
					<th>ジャンル</th>
					<td><a
						href="narrow?category=${item.categoryId}&keyword=&hardware=0&minprice=&maxprice=&stock=">${item.category}</a></td>
				</tr>
				<tr>
					<th>発送期間</th>
					<td>${item.term}日</td>
				</tr>
				<tr>
					<th>値段</th>
					<td>${item.price}円</td>
				</tr>
				<c:set var="stockCheck" value="${item.stock }"></c:set>
			</table>
		</c:forEach>
	<p>
		<c:forEach var="item" items="${item}">
			<a  class="button" href="showListingEdit?item_id=${item.itemId}">出品した商品の編集</a>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="item" items="${item}">
			<a class="button"  href="remove?item_id=${item.itemId}">出品を取り消す</a>
		</c:forEach>
	</p>

	<div class="itemExplanation">
	<c:forEach var="item" items="${item}">
		<p>${item.itemExplanation}</p>
	</c:forEach>

	</div>
	<br>

	<div class="openChatTable">
	<!-- 	<table border="1" class="chat"> -->
		<c:forEach var="chat" items="${open}">
			<script>
				var flag=document.getElementById("flag").innerText;
				var chatUserId = ${chat.userId};
				var userId = document.getElementById("userId").innerText;

				var sold1=`<p>${chat.userName}</p><div class="balloon1-left"><p>${chat.text}</p></div><br>${chat.date}<br>`
				var sold2=`<p id="right">${chat.userName}</p><div class="balloon1-right"><p>${chat.text}</p></div><br><p id="right">${chat.date}<br></p>`

				if(flag == "OK"){
					//ログイン時
					if(chatUserId == userId){
						//自分側
						document.write(sold2);
					}else{
						//相手側
						document.write(sold1);
					}
				}else{
					//非ログイン時
					document.write(sold1);
				}
			</script>
		</c:forEach>

		<c:forEach var="item" items="${item}" >
			<form action="sendopenchat?item_id=${item.itemId}" method="post"
				id="form1" class = "chatbutton">

				<!-- <input type="text" name="text" class="inputchat" required> -->
				<textarea  rows ="10" cols="45" name="text" maxlength="500" required="required"></textarea>
				<br>

				<input class="button" type="submit" value="コメントする">


			</form>
		</c:forEach>

	</div>
	<!-- 	<p>
		<a href="/category/">カテゴリー検索</a>
	</p> -->

	<script>
		if (<c:out value="${stockCheck}" /> == 0) {
			document.getElementById("stockCheck").innerText = "売り切れ";
			document.getElementById("stockCheck").removeAttribute("href");

			document.getElementById("stockCheck").style.backgroundColor = "ButtonShadow";
			document.getElementById("stockCheck").style.color = "white";
		}
	</script>
		<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		var flag=document.getElementById("flag").innerText;
		if (flag == "OK") {
			$("#login").css("display","none");
			$("#signup").css("display","none");
			<!--$("#login").html('<a href="showprofile" class="headerBtn">マイページ</a>');-->

		}else{
			$("#mypage").css("display","none");
			$("#notice").css("display","none");
		}
	</script>
	<script>
		var flag=document.getElementById("flag").innerText;
		if (flag == "OK") {


		}else{
			$(".chatbutton").css("display","none");
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