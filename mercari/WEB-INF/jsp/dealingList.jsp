<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
<meta charset="UTF-8">
<title>取引中の一覧表示</title>
<div class="search">
	<form name="itemsearch" method='post' action='search'
		onSubmit="return check()">
		<p>商品名検索</p>
		<input type='text' name='itemName'> <input type='submit'
			value='検索！'>
	</form>
</div>
<ul class="category">
	<li><a>カテゴリから探す</a>
		<ul>
			<li><a href="category">DS</a>
				<ul>

					<li><a href="category">アクション</a></li>
					<li><a href="category">Child2</a></li>
					<li><a href="category">Child3</a></li>
					<li><a href="category">Child4</a></li>
					<li><a href="category">Child5</a></li>
				</ul></li>

		</ul></li>

</ul>
</head>
<body>
	<div id="seller">
		<h4>購入した商品</h4>
		<h4>取引中</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
		<h4>過去の取引</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="buyer">
		<h4>購入した商品</h4>
		<h4>取引中</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
		<h4>過去の取引</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
		<h4>売却済み</h4>
		<table border="1">
			<tr>
				<th>itemid</th>
				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.itemImage}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="l-side">
		<ul>
			<li><a href="profileEdit">取引中の一覧表示</a></li>
			<li><a href="point">ポイント</a></li>
			<li><a href="profile">プロフィール</a></li>
			<li><a href="logout">ログアウト</a></li>
		</ul>
	</div>
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