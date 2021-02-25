<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%
	String token = (String)session.getAttribute("flag");
%>

<html>

<head>
	<%@include file="../../css/search.css"%>
	<meta charset="UTF-8">
	<title>商品検索結果</title>

	<!-- ログインセッションの取得 -->
	<p style="display:none;" id="flag"><%= token %></p>
</head>

<body>
	<div class="header">
		<div class="search">
			<form name="itemsearch" method='post' action='search' onSubmit="return check()">

					<input type='text' name='keyword' style="width: 800px; height: 40px; margin-top: 30px" placeholder="何かお探しですか？">
					<input type='submit' value='検索！' style="height: 40px">
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

		<!-- 詳細検索画面（のちにサイドバー）-->
		<div class="searchinfo">
			<form name="itemsearch" method='post' action='search' onSubmit="return check()">
				<p>キーワード</p>
				<input type='text' name='keyword' style="width: 80%; height: 40px; margin-top: 30px" placeholder="何かお探しですか？">

				<p>ハードウェア</p>
				<div id="hardwaresearch">
					<select name="hardwareId">
						<option value="">選択してください</option>
						<c:forEach var="hardware" items="${hardware}">
							<option value="${hardware.hardwareId}">${hardware.hardware}</option>
						</c:forEach>
					</select>
				</div>
				<p>ジャンル</p>
				<div id="categorysearch">
					<select name="categoryId">
						<option value="">選択してください</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.categoryId}">${category.category}</option>
						</c:forEach>
					</select>
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
			<!-- テスト用のいらない子 -->

			 <!-- 商品一覧 -->
			<div id="column" class="column04">
				<h3>検索結果</h3>
				<ul>
					<c:forEach var="item" items="${data}">
						<li>
							<a href="showiteminfo?item_id=${item.itemId}" name="itemId">
							<img src="images/${item.itemImage}" />
							<p>${item.itemImage}</p>
							<p>${item.itemName}</p>
							<span>&yen;${item.price}</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<h6>メルカリ</h6>
		</div>

	</div>

	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
	<script>
		var flag=document.getElementById("flag").innerText;
		if (flag == "OK") {
			$("#login").css("display","none");
			$("#signup").css("display","none");
		}else{
			$("#mypage").css("display","none");
			$("#notice").css("display","none");
		}
	</script>

</body>
</html>