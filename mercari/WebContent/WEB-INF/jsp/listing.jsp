<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
</head>
<body>
     <h1>出品</h1>
     <form action="authenticate" method="post">
       商品の画像：<input type="file" name="itemImage">
       商品名：<input type="text" name="itemName"/><br>
       商品の説明：<input type="text" name="itemExplanation"/><br>
       ゲームのジャンル：<input type="text" name="explanation"/><br>
       ハードの種類：<input type="text" name="explanation"/><br>
       発送までの期間：<input type="text" name="listingDate"/><br>
       値段：<input type="text" name="price"/><br><br>

       <input type="submit" value="出品する">
     </form>
</body>
</html>