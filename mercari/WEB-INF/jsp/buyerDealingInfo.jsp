<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買い手の商品取引画面</title>
<%@include file="../css/buyerDealInfo.css"%>
</head>
<body>
<div class="center">
<div class="left">
	<table border="1">
		<c:forEach var="item" items="${item}">
			<img src="images/${item.itemImage}" width="300">

			<tr>
				<th>商品名</th>
				<td>${item.itemName}</td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<c:forEach var="deal" items="${deal}">

			<c:set var="stateCheck" value="${deal.dealState}"></c:set>
		</c:forEach>
	</table>
</div>
<div class="right">
	<c:forEach var="deal" items="${deal}">
		<div id="receive">
			<form action="receive?deal_id=${deal.dealId}&user_state=1" method="post">
				<input type="submit" value="受け取りました" class="button">
			</form>
		</div>
	</c:forEach>


		<c:forEach var="chat" items="${chat}">

			<script>
							var sold1=`<p id="left">${chat.userName}<div class="balloon1-left"><p>${chat.text}</p></div><br>${chat.date}</p><br>`
							var sold2=`<p id="right">${chat.userName}</p><div class="balloon1-right"><p>${chat.text}</p></div><br><p id="right">${chat.date}<br></p>`
							if(${chat.sellerId}==${userId}){
							document.write(sold2)
							}else{document.write(sold1)}
					</script>

	</c:forEach>

	<c:forEach var="deal" items="${deal}">
		<form action="sendPrivateChat?deal_id=${deal.dealId}&user_state=1" method="post">
			<input type="text" name="text" class="textBox"><br> <input
				type="submit" value="コメントする" class="button">
		</form>
		</div>


		<div class = "leftBtn">
			<p id="canceldeal">
				<a href="canceldeal?deal_id=${deal.dealId}&user_state=1" class="button">取引をキャンセルする</a>
			</p>
</div>
	</c:forEach>
	<div class="underLeftBtn">
	<p>
		<a href="f_start" class="button">TOPページへ</a>
	</p>
</div>
</div>
	<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>
		<script>
		<!-- 1→取引中（取引開始）、2→取引キャンセル、3→取引完了（受け取り終了）、4→商品発送 -->
		if (<c:out value="${stateCheck}" /> == 1) {
			$("#canceldeal").css("display","none");
		}
		if (<c:out value="${stateCheck}" /> == 4) {
			$("#canceldeal").css("display","none");
		}
	</script>
	<script>
		<!-- 1→取引中（取引開始）、2→取引キャンセル、3→取引完了（受け取り終了）、4→商品発送 -->
		if (<c:out value="${stateCheck}" /> == 1) {
			$("#receive").empty();
			$("#receive").html('<p class="button">商品の発送をお待ちください。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2) {
			$("#receive").empty();
			$("#receive").html('<p class="button">取引がキャンセルされました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 3) {
			$("#receive").empty();
			$("#receive").html('<p class="button">商品の受け取りが完了しました。</p>');
		}

		if (<c:out value="${stateCheck}" /> == 2 ||<c:out value="${stateCheck}" /> == 4) {
			$("#cancel").empty();
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