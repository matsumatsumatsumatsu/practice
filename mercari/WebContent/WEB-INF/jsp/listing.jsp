<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
</head>
<body>
	<form name="listing" action="listing" enctype="multipart/form-data" method="post" onSubmit="return check()">
		商品の画像：<input type="file" name="itemImage" accept=".jpg,.jpeg,.png">
		<br>商品名：<input type="text" name="itemName" />
		<br> 商品の説明：<input type="text"name="itemExplanation" />
		<br> ハードの種類：
		<select name="hardwareId">
			<option value="">選択してください</option>
			<c:forEach var="hardware" items="${hardware}">
				<option value="${hardware.hardwareId}">${hardware.hardware}</option>
			</c:forEach>
		</select>
		<br> ゲームのジャンル：
		<select name="categoryId">
			<option value="">選択してください</option>
			<c:forEach var="category" items="${category}">
				<option value="${category.categoryId}">${category.category}</option>
			</c:forEach>
		</select>
		<br> 発送までの期間：<input type="text" name="term" />
		<br>値段：<input type="text" name="price" />
		<br><br> <input type="submit" value="出品する">
	</form>

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
</body>
</html>