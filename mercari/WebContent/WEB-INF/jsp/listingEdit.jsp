<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>出品物の編集</title>
<%@include file="../../css/listingEdit.css"%>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
</head>
<body>
<p style="display:none;" id="flag">${flag}</p>
<div class="header">

	<div class="top">
		<a href="f_start" class="topBtn">TOPページへ</a>
	</div>
	<div class="search" style="display:inline-flex">
			<form name="itemsearch" method='post' action='search' class="itemsearch">
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
<div class="center">
<h1>出品物の編集</h1>
	<form name="listing" action="editListing" method="post" onSubmit="return check()">
		<c:forEach var="item" items="${item}">
			<input type="hidden" name="itemId" value="${item.itemId}">
		</c:forEach>
		<div class="left">
		<c:forEach var="item" items="${item}">
		<p>商品画像</p>
			<img src="images/${item.itemImage}" width="300">
		</c:forEach><br>
		</div>
		<div class="right">
		<c:forEach var="item" items="${item}">
		<p>商品名の変更(40字以内)</p>
			<input type="text" name="name" maxlength="40" value="${item.itemName}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>商品説明の変更(500字以内)</p>
		<textarea rows ="10" cols="45" name="itemExplanation" maxlength="500"  class="textsize">${item.itemExplanation}</textarea>
		</c:forEach><br>
		<p>ハードの種類</p>
		<select name="hardwareId" class="textsize">
			<option value="">選択してください</option>
			<c:forEach var="hardware" items="${hardware}">
				<option value="${hardware.hardwareId}">${hardware.hardware}</option>
			</c:forEach>
		</select>
		<p> ゲームのジャンル</p>
		<select name="categoryId" class="textsize">
			<option value="">選択してください</option>
			<c:forEach var="category" items="${category}">
				<option value="${category.categoryId}">${category.category}</option>
			</c:forEach>
		</select>
		<c:forEach var="item" items="${item}">
		<p>発送までの期間の変更(半角数字)</p>
			<input type="text" name="term" pattern="[0-9]+" placeholder="(例：7)" value="${item.term}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>値段の変更(半角数字)</p>
			<input type="text" name="price" value="${item.price}" pattern="[0-9]+" placeholder="(例：5000)" class="textsize">
		</c:forEach><br>
		</div>
			<input type="submit" value="変更" class="button">
	</form>
	</div>
	<script>
	    function check() {
		    if(document.listing.hardwareId.value == "") {
		        alert("ハードを選択して下さい");
		        return false;
		    }
		    if(document.listing.categoryId.value == "") {
		        alert("ジャンルを選択して下さい");
		        return false;
		    }
		    if(document.listing.itemName.value == "") {
		        alert("名前を入力してください");
		        return false;
		    }
		    if(document.listing.itemExplanation.value == "") {
		        alert("説明を入力してください");
		        return false;
		    }
		    if(document.listing.term.value == "") {
		        alert("発送までの期間を入力してください");
		        return false;
		    }
		    if(document.listing.price.value == "") {
		        alert("値段を入力してください");
		        return false;
		    }

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
</body>
</html>