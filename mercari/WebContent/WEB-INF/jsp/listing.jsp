<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
<%@include file="../../css/listingEdit.css"%>
</head>
<body>
<div class="topOuter">
	<a href="f_start" class="topButton">TOPページへ</a>
</div>
<div class="center">
	<h1>出品</h1>
	<form name="listing" action="listing" enctype="multipart/form-data" method="post" onSubmit="return check()">
		<div class="left">
		<p>商品の画像(.jpg .jpeg .png)</p><input type="file" name="itemImage" accept=".jpg,.jpeg,.png">
		</div>
		<div class="right">
		<br><p>商品名(40字以内)</p><input type="text" name="itemName" maxlength="40" class="textsize"/>
		<br> <p>商品の説明(500字以内)</p><textarea rows ="10" cols="45" name="itemExplanation" maxlength="500"></textarea>
		<!-- <input type="text"name="itemExplanation"  class="textsize"/> -->
		<br> <p>ハードの種類</p>
		<select name="hardwareId" class="textsize">
			<option value="">選択してください</option>
			<c:forEach var="hardware" items="${hardware}">
				<option value="${hardware.hardwareId}">${hardware.hardware}</option>
			</c:forEach>
		</select>
		<br> <p>ゲームのジャンル</p>
		<select name="categoryId" class="textsize">
			<option value="">選択してください</option>
			<c:forEach var="category" items="${category}">
				<option value="${category.categoryId}">${category.category}</option>
			</c:forEach>
		</select>
		<br> <p>発送までの日数(半角数字)</p><input type="text" name="term" pattern="[0-9]+" placeholder="(例：7)" class="textsize"/>
		<br><p>値段(半角数字)</p><input type="text" name="price" pattern="[0-9]+" placeholder="(例：5000)" class="textsize"/>
		</div>
		<br><br> <input type="submit" value="出品する" class="button">
	</form>
</div>
	<script>
	    function check() {
	        if(document.listing.itemImage.value == "") {
	            alert("画像がありません");
	            return false;
	        }
	        if(document.listing.hardwareId.value == "") {
	            alert("ハードを選択して下さい");
	            return false;
	        }
	        if(document.listing.categoryId.value == "") {
	            alert("ジャンルを選択して下さい");
	            return false;
	        }
	        if(document.listing.itemName.value == "") {
	            alert("名前を入力してください");
	            return false;
	        }
	        if(document.listing.itemExplanation.value == "") {
	            alert("説明を入力してください");
	            return false;
	        }
	        if(document.listing.term.value == "") {
	            alert("発送までの期間を入力してください");
	            return false;
	        }
	        if(document.listing.price.value == "") {
	            alert("値段を入力してください");
	            return false;
	        }
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