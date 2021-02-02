<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
	<div class="search">
		<form name="itemsearch" method='post' action='SearchItem' onSubmit="return check()">
  	 	<p>商品名検索</p>
    	<input type='text' name='itemName'>
    	<input type='submit' value='検索！'>
  	</form>
	</div>
</head>

<body>
<div id="searh">
<div id="categorysearh">
<ul class="gnav">
    <li>
        <a href="category">カテゴリから探す</a>
        <ul>
            <li>
                <a href="">DS</a>
                <ul>

                    <li><a href="category">アクション</a></li>
                    <li><a href="category">Child2</a></li>
      			    <li><a href="category">Child3</a></li>
                    <li><a href="category">Child4</a></li>
                    <li><a href="category">Child5</a></li>
                </ul>

            </li>

        </ul>
    </li>

</ul>
</div>
<div id="pricesearh">
<input type="text" name="minvalu">
<input type="text" name="maxvalu">
</div>
<div id="stockserah">
<input type="checkbox" name="sale"><label for="sale">販売中</label>
<input type="checkbox" name="sold"><label for="sold">売りきれ</label>
</div>
<button type='submit' value='検索！'></button>
</div>
<p><a href="f_listing">出品画面へ</a></p>

<table border="1">
	<tr><th>商品名</th><th>価格</th><th>画像</th><th>itemid</th></tr>
	<c:forEach var="item" items="${data}">
		<tr><td>${item.itemName}</td><td>${item.price}</td><td>${item.itemImage}</td><td>${item.itemId}</td></tr>
	</c:forEach>
</table>

</body>
</html>