<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーの個別表示</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>userid</th>
			<th>ユーザー名</th>
			<th>住所</th>
			<th>本名</th>
			<th>電話番号</th>
			<th>メールアドレス</th>
			<th>パスワード</th>
		</tr>
		<c:forEach var="user" items="${data}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.realName}</td>
				<td>${user.address}</td>
				<td>${user.tel}</td>
				<td>${user.mail}</td>
				<td>${user.userPassword}</td>
				<td><a href="banuser?user_id=${user.userId}">削除</a></td>
			</tr>
		</c:forEach>
	</table>
<div class="dealing">
				<h4>取引中</h4>
				<div class="hidden_box">
					<label for="label1">購入した商品</label> <input type="checkbox"
						id="label1" />
					<div class="hidden_show">

						<h4>購入した商品</h4>
						<table border="1">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${buyDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=1"
										name="itemId">${deal.itemId}</a></td>
									<td>${deal.itemName}</td>
									<td>${deal.itemImage}</td>
									<td>${deal.dealState}</td>
									<td><form action="changeState" method='post'>


                <input type='hidden' name="deal_id" value="${deal.dealId}">
                <input type='submit' value='キャンセル'>

            </form></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>出品した商品</h4>
				<div class="hidden_box">
					<label for="label2">出品した商品</label> <input type="checkbox"
						id="label2" />
					<div class="hidden_show">


						<table border="1">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="deal" items="${sellDeal}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${deal.dealId}&user_state=2"
										name="itemId">${deal.itemId}</a></td>
									<td>${deal.itemName}</td>
									<td>${deal.itemImage}</td>

								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>過去の取引</h4>
				<div class="hidden_box">
					<label for="label3">過去の取引</label> <input type="checkbox"
						id="label3" />
					<div class="hidden_show">
						<div id="history">

							<h4>購入した商品</h4>
							<table border="1">
								<tr>
									<th>itemid</th>
									<th>商品名</th>
									<th>画像</th>
								</tr>
								<c:forEach var="history" items="${buyHistory}">
									<tr>
										<td><a
											href="showDealingInfo?deal_id=${history.dealId}&user_state=1"
											name="itemId">${history.itemId}</a></td>
										<td>${history.itemName}</td>
										<td>${history.itemImage}</td>
										<td>${history.dealState}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="dealing">
				<h4>過去出品した商品</h4>
				<div class="hidden_box">
					<label for="label4">出品した商品</label> <input type="checkbox"
						id="label4" />
					<div class="hidden_show">
						<table border="1">
							<tr>
								<th>itemid</th>
								<th>商品名</th>
								<th>画像</th>
							</tr>
							<c:forEach var="history" items="${sellHistory}">
								<tr>
									<td><a
										href="showDealingInfo?deal_id=${history.dealId}&user_state=2"
										name="itemId">${history.itemId}</a></td>
									<td>${history.itemName}</td>
									<td>${history.itemImage}</td>

								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	<form action="grantPoint" method='post'>
		<c:forEach var="user" items="${data}">
			<input type='hidden' name='user_id' value="${user.userId}">
		</c:forEach>
		<input type='text' placeholder='追加ポイント' name='point'> <input
			type='submit' value='追加'>
	</form>
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