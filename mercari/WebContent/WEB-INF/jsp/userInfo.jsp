<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.header {
	background-color: white;
	margin-bottom: 30px;
	height: 150px;
	border-bottom: 2px solid black;
}

.search {
	display: inline-block;
	text-align: center;
	float: right;
	margin-right: 100px;
}

body {
	background-color: #F8F8FF;
}
/* ここまで共通 */
.user_name {
	width: 100px;
	margin: auto;
}

.user_name table {
	text-align: center;
}

.user_item_list table {
	border-collapse: collapse;
	text-align: center;
	margin-left: auto;
    margin-right: auto;
    width: 10em
}

.user_item_list p {
	text-align: center;
}

</style>

<meta charset="UTF-8">
<title>ユーザーの個別表示</title>
<div class="header">
	<div class="search">
		<form name="itemsearch" method='post' action='search'
			onSubmit="return check()">
			<input type='text' name='keyword'
				style="width: 800px; height: 40px; margin-top: 30px"
				placeholder="商品名検索"> <input type='submit' value='検索！'
				style="height: 40px">
		</form>
	</div>
</div>
</head>
<body>
	<div class="user_name">
		<table border="1">
			<tr>
				<th>出品者</th>
				<c:forEach var="user" items="${user}">
					<td>${user.userName}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div class="user_item_list">

		<p>この出品者の商品</p>
		<table border="1">
			<tr>
				<c:forEach var="item" items="${item}">
					<td><a href="showiteminfo?item_id=${item.itemId}">${item.itemName}</a></td></tr>
					<tr><td>￥${item.price}</td></tr>


		</c:forEach>
		</table>

	</div>

</body>
</html>
