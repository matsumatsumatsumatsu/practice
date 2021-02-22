<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<style>
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
			width: 700px;
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
    		margin:90px;


		}
		.left{
			display:inline-block;
			float:left;
			margin-left:20px;
		}
		.right{
			display:inline-block;
			float:right;
			margin-right:30px;
		}
		.textsize{
			width:300px;
		}
</style>
<meta charset="UTF-8">
<title>出品物の編集</title>
</head>
<body>
<div class="center">
<h1>出品物の編集</h1>
	<form action="editListing" method="post">
		<c:forEach var="item" items="${item}">
			<input type="hidden" name="itemId" value="${item.itemId}">
		</c:forEach>
		<div class="left">
		<c:forEach var="item" items="${item}">
		<p>商品画像の変更</p>
			<input type="file" name="image" value="${item.itemImage}" class="textsize">
		</c:forEach><br>
		</div>
		<div class="right">
		<c:forEach var="item" items="${item}">
		<p>商品名の変更</p>
			<input type="text" name="name" value="${item.itemName}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>商品説明の変更</p>
			<input type="text" name="explanation" value="${item.itemExplanation}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>ゲームのジャンルの変更</p>
			<input type="text" name="category" value="${item.categoryId}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>ハードの変更</p>
			<input type="text" name="hardware" value="${item.hardwareId}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>発送までの期間の変更</p>
			<input type="text" name="term" value="${item.term}" class="textsize">
		</c:forEach><br>
		<c:forEach var="item" items="${item}">
		<p>値段の変更</p>
			<input type="text" name="price" value="${item.price}" class="textsize">
		</c:forEach><br>
		</div>
			<input type="submit" value="変更" class="button">
	</form>
	</div>
</body>
</html>