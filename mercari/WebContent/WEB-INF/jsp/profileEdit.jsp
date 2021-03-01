<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集</title>
<%@include file="../../css/profileEdit.css"%>
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
	<div class="center">
		<h1>プロフィールを編集する</h1>
		<form action="editProfile" method="post">
			<c:forEach var="user" items="${data}">
				<p>ユーザーネームの変更</p>
				<input type="text" name="name" value="${user.userName}"
					class="textsize" required size="60">
			</c:forEach>
			<br>
			<c:forEach var="user" items="${data}">
				<p>パスワードの変更</p>
				<input type="password" name="pass" value="${user.userPassword}"
					class="textsize" required size="60" id="js-password"><br>
				<label for="js-passcheck">パスワードを表示する</label>
				<input type="checkbox" id="js-passcheck"/><br>
			</c:forEach>
			<br>
			<c:forEach var="user" items="${data}">
				<p>パスワードの確認</p>
				<input type="password" name="pass2" value="${user.userPassword}"
					class="textsize" required size="60" id="js-password2"><br>
				<label for="js-passcheck">パスワードを表示する</label>
				<input type="checkbox" id="js-passcheck2"/><br>
			</c:forEach>
			<c:forEach var="user" items="${data}">
				<p>本名の変更</p>
				<input type="text" name="real" value="${user.realName}"
					class="textsize" required size="60">
			</c:forEach>
			<br>
			<c:forEach var="user" items="${data}">
				<p>電話番号の変更</p>
				<input type="text" name="tel" value="${user.tel}" class="textsize" required size="60">
			</c:forEach>
			<br>
			<c:forEach var="user" items="${data}">
				<p>住所の変更</p>
				<input type="text" name="address" value="${user.address}"
					class="textsize" required size="60">
			</c:forEach>
			<br>
			<c:forEach var="user" items="${data}">
				<p>自己紹介文の変更</p>
				<!-- <input type="text" name="prof" value="${user.profile}"
					class="textsize"> -->
					 <textarea  rows ="10" cols="45" name="prof" maxlength="500"></textarea>
			</c:forEach>
			<br> <input type="submit" value="変更" class="button">
		</form>
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
	<script>
		$(function() {
		    var password  = '#js-password';
		    var passcheck = '#js-passcheck';

		    changeInputtype(password, passcheck);
		});


		function changeInputtype(password, passcheck) {
		    $(passcheck).change(function() {
		        if ($(this).prop('checked')) {
		            $(password).attr('type','text');
		        } else {
		            $(password).attr('type','password');
		        }
		    });
	}
	</script>
	<script>
		$(function() {
		    var password  = '#js-password2';
		    var passcheck = '#js-passcheck2';

		    changeInputtype(password, passcheck);
		});


		function changeInputtype(password, passcheck) {
		    $(passcheck).change(function() {
		        if ($(this).prop('checked')) {
		            $(password).attr('type','text');
		        } else {
		            $(password).attr('type','password');
		        }
		    });
	}
	</script>
</body>
</html>