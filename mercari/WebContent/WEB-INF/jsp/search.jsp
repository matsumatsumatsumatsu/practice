<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String token = (String)session.getAttribute("flag");
	session.setAttribute("token2",token);
%>

<html>

<head>
	<%@include file="../../css/search.css"%>
	<meta charset="UTF-8">
	<title>商品検索結果</title>

	<!-- ログインセッションの取得 -->
	<!--  <p style="display:none;" id="flag"><%= token %></p>-->
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
			<a href="showprofile" class="headerButton">マイページ</a>
		</p>
		<p id = "notice">
			<a href="showNoticeList" class="headerButton">通知</a>
		</p>

	</div>
</div>
	<div class="start">
		<h1>メルカリもどき</h1>

		<p>
			<a href="f_listing" class="listingButton">出品画面へ</a>
		</p>

		<!-- 詳細検索画面（のちにサイドバー）-->
		<div class="searchinfo">
			<form name="itemsearch" method='post' action='narrow' onSubmit="return check()">
				<p>キーワード</p>
				<input type='text' name='keyword' style="width: 80%; height: 40px; margin-top: 30px" placeholder="何かお探しですか？">
				<!--
				<p>ハードウェア</p>
				<div id="hardwaresearch">
					<select name="hardware">
						<option value="">選択してください</option>
						<c:forEach var="hardware" items="${hardware}">
							<option value="${hardware.hardwareId}">${hardware.hardware}</option>
						</c:forEach>
					</select>
				</div>
				<p>ジャンル</p>
				<div id="categorysearch">
					<select name="category">
						<option value="">選択してください</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.categoryId}">${category.category}</option>
						</c:forEach>
					</select>
				</div>
				-->

				<p>ハードウェア</p>
				<div id="categorysearch">
					<input type="radio" name="hardware" value="0" checked>すべて
					<c:forEach var="hardware" items="${hardware}">
						<input type="radio" name="hardware" value="${hardware.hardwareId}">${hardware.hardware}
					</c:forEach>
					<br>
					<p>カテゴリ</p>
					<input type="radio" name="category" value="0" checked>すべて
					<c:forEach var="category" items="${category}">
						<input type="radio" name="category" value="${category.categoryId}">${category.category}
					</c:forEach>
					<br>

				</div>

				<!-- 値段の絞り込み用のテキストボックス -->
				<div id="pricesearch">
				<br>
					値段下限：<input type="text" name="minprice"><br>
					値段上限：<input type="text" name="maxprice">
				</div>
				<div id="stocksearch">
					<br>
					<input type="radio" name="stock" value="0" checked>すべて
					<input type="radio" name="stock" value="sale">販売中
					<input type="radio" name="stock" value="sold">売りきれ
				</div>
				<button type='submit' value='検索！'>検索</button>
			</form>
		</div>

		<!-- 商品一覧 -->
		<div class="itemlist">
			 <!-- 商品一覧 -->
			<div id="column" class="column04">
				<h3>検索結果</h3>
				<ul>
					<c:forEach var="item" items="${data}">
						<li>
							<a href="showiteminfo?item_id=${item.itemId}" name="itemId">
							<img src="images/${item.itemImage}" />
							<p>${item.itemName}</p>
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