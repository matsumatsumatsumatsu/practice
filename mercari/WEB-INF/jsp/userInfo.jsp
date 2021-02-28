<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーの個別表示</title>
<%@include file="../css/userInfo.css"%>
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
	<div class="center">
		<div class="user_name">
			<table border="1" class="userName">
				<tr>
					<th>出品者</th>
				</tr>

				<c:forEach var="user" items="${user}">
					<tr>
						<td>${user.userName}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="itemlist">

			<p>この出品者の商品</p>
			<div id="column" class="column05">
				<ul>
				<c:forEach var="item" items="${item}">
					<li>
					<a href="showiteminfo?item_id=${item.itemId}">
					<p>${item.itemName}</p>
					<img src="images/${item.itemImage}" />
					<span>￥${item.price}</span>
					</a>
					</li>
				</c:forEach> </ul>
			</div>

		</div>
	</div>


</body>
</html>
