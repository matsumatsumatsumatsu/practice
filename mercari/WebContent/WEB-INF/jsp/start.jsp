<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>スタート画面</title>
	<div class="search">
		<form name="itemsearch" method='post' action='search' onSubmit="return check()">
  	 	<p>商品名検索</p>
    	<input type='text' name='itemName'>
    	<input type='submit' value='検索！'>
  	</form>
	</div>
</head>

<body>
<h1>メルカリもどき</h1>
<p><a href="f_signup">ユーザー登録画面へ</a></p>
<p><a href="view">ユーザー確認画面へ</a></p>
<p><a href="f_listing">出品画面へ</a></p>
<p><a href="f_login">ログイン</a></p>
<p><a href="f_logout">ログアウト</a></p>
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

<table border="1">
	<tr><th>itemid</th><th>商品名</th><th>価格</th><th>画像</th><th>説明</th></tr>
	<c:forEach var="item" items="${data}">
		<tr><td>${item.itemId}</td><td>${item.itemName}</td><td>${item.price}</td><td>${item.itemImage}</td><td>${item.itemExplanation}</td></tr>
	</c:forEach>
</table>

</body>
</html>

<!-- HTMLでは、href属性の値として、相対パスを指定する場合は、スラッシュをつけません。「/input」のようにスラッシュを記述した場合は、「http://lcoalhost:9999/input」のように、コンテキストパスとして解釈されます。これは、javax.servlet.ServletRequestインターフェイスのgetRequestDispatcherメソッドの引数の指定の仕方とは異なります。 -->

