<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String token = (String)session.getAttribute("flag");
	session.setAttribute("token2",token);
%>
<html>

<head>
	<%@include file="../../css/start.css"%>
<style>
<!-- 共通ヘッダー -->
</style>
<title>スタート画面</title>
<!-- <div class="search">
			<c:forEach var="hardware" items="${hardware}">
				<input type="radio" name="hardware" value="${hardware.hardwareId}">${hardware.hardware}
			</c:forEach>
			<br>
			<p>カテゴリ</p>
			<input type="radio" name="category" value="0" checked>すべて
			<c:forEach var="category" items="${category}">
				<input type="radio" name="category" value="${category.categoryId}">${category.category}
			</c:forEach>
	</div> -->
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
	<div class="start">
		<h1>メルカリもどき</h1>
		<p>
			<a href="f_listing" class="listingButton">出品画面へ</a>
		</p>
		<!-- 後々コメントアウト -->
		<!--
		<p>
			<a href="f_logout">ログアウト</a>
		</p>
		-->
		<div class="itemlist">
			 <!-- 商品一覧 -->
			<div id="column" class="column05">
				<h3>商品一覧</h3>
				<ul>
					<c:forEach var="item" items="${itemlist}">
						<li>
							<a href="showiteminfo?item_id=${item.itemId}" name="itemId">

								<div class="itemimage">
								<!-- ここで横幅指定するの良くない（修正案件） -->
								<img src="images/${item.itemImage}"   width="152.396px" />
									<div class="itemName">
									<p>${item.itemName}</p>
										<div class="out">
											<script>
										    	var sold1=`<img src="images/soldoutjpeg_transparent.png"  width="152.396px"/>`
												if(${item.stock }==0){
												document.write(sold1)
												}else{}
											</script>
										</div>
									</div>
								</div>
							<span>&yen;${item.price}</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
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

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->
