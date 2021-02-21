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
	height:150px;
	border-bottom: 2px solid black;
}

.search {
	display:inlone-block;
	text-align: center;
	float: right;
	margin-right: 100px;
}
body {
		background-color: #F8F8FF;
	}
	h1{
		text-align:center;
	}
		.center{
			text-align: center;
			margin-left: auto;
			margin-right: auto;
			height: auto;
			background-color: white;
			width: 500px;
		}
		.button{
			background-color: #4669ff;
    		border-bottom: solid 2px #003aff;
   			border-right: solid 2px #003aff;
   		 	border-radius: 20px;
    		font-weight: bold;
    		width:200px;
   		 	color: #FFF;
    		text-decoration: none;
    		padding: 10px;
    		display: inline-block;
    		margin:20px

		}
		.textsize{
			width:300px;
		}
</style>
<meta charset="UTF-8">
<title>プロフィール編集</title>
<div class="header">
	<div class="search">
		<form name="itemsearch" method='post' action='search' onSubmit="return check()">
			<input type='text' name='itemName' style="width: 800px; height: 40px; margin-top: 30px"placeholder="商品名検索">
			<input type='submit' value='検索！' style="height: 40px">
		</form>
	</div>
	</div>
</head>
<body>
<div class="center">
<h1>プロフィールを編集する</h1>
	<form action="editProfile" method="post">
		<c:forEach var="user" items="${data}">
			<p>ユーザーネームの変更</p>
			<input type="text" name="name" value="${user.userName}" class="textsize">
		</c:forEach><br><br>
		<c:forEach var="user" items="${data}">
		<p>パスワードの変更</p>
			<input type="text" name="pass" value="${user.userPassword}" class="textsize">
		</c:forEach><br><br>
		<c:forEach var="user" items="${data}">
			<p>本名の変更</p>
			<input type="text" name="real" value="${user.realName}" class="textsize">
		</c:forEach><br><br>
		<c:forEach var="user" items="${data}">
		<p>電話番号の変更</p>
			<input type="text" name="tel" value="${user.tel}" class="textsize">
		</c:forEach><br><br>
		<c:forEach var="user" items="${data}">
			<p>住所の変更</p>
			<input type="text" name="address" value="${user.address}" class="textsize">
		</c:forEach><br><br>
		<c:forEach var="user" items="${data}">
		<p>自己紹介文の変更</p>
			<input type="text" name="prof" value="${user.profile}" class="textsize">
		</c:forEach><br><br>
		<input type="submit" value="変更" class ="button">
	</form>
	</div>
</body>
</html>