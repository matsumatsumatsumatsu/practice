<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
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
	<div id="user">
		<table border="1">
			<tr>
				<th>ポイント</th>
			</tr>
			<c:forEach var="user" items="${data}">
				<tr>
					<td>${user.point}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="point" method="post">
		ポイントくれ：<input type="text" name="userpoint" /><br> <input
			type='submit' value='くれ'>
	</form>

	<div id="l-side">
		<ul>
			<li><a href="listings">出品した商品</a></li>
			<li><a href="purchase">購入した商品</a></li>
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