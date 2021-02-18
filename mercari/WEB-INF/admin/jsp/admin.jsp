<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>管理者用ページ</title>
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
	<h1>メルカリ管理者</h1>


	<table border="1">
		<tr>
			<th>itemid</th>
			<th>商品名</th>
			<th>価格</th>
			<th>画像</th>
			<th>説明</th>
		</tr>
		<c:forEach var="item" items="${itemlist}">
			<tr>
				<td>${item.itemId}</td>
				<td><a href="adminshowiteminfo?item_id=${item.itemId}">${item.itemName}</a></td>
				<td>${item.price}</td>
				<td>${item.itemImage}</td>
				<td>${item.itemExplanation}</td>

			</tr>
			<!-- urlをf_showiteminfoにすると一応飛びます -->

		</c:forEach>
	</table>

	<p>
		<a href="show">ユーザ一覧</a>
	</p>
	<p>
		<a href="paymentLogList">全ユーザーの取引履歴の閲覧</a>
	</p>
</body>
</html>

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->

