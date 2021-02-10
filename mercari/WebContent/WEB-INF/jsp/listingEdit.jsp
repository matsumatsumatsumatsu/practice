<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>出品物の編集</title>
</head>
<body>
	<form action="editListing" method="post">
		<tr>
			<input type="text" placeholder="商品画像の変更">
			<br>
			<input type="text" placeholder="商品名の変更">
			<br>
			<input type="text" placeholder="商品説明の変更">
			<br>
			<input type="text" placeholder="ゲームのジャンルの変更">
			<br>
			<input type="text" placeholder="ハードの変更">
			<input type="text" placeholder="発送までの期間の変更">
			<br>
			<input type="text" placeholder="値段の変更">
			<input type="submit" value="変更">
			<input type="submit" value="キャンセル">
		</tr>
	</form>
</body>
</html>