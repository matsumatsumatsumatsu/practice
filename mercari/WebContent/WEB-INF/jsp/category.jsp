<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ一覧</title>
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="images/icon16.png">
</head>
<body>
	<h1>カテゴリ一覧</h1>
	<ul>
		<li><a class="DSList">DS</a></li>
		<li><a class="PSPList">DS</a></li>
		<li><a class="PS4List">DS</a></li>
		<li><a class="switchList">DS</a></li>
	</ul>
	<div class="DSList">
		<h4>DS</h4>
		<ul>
			<li><a hreh="">RPG</a></li>
			<li><a hreh="">アクション</a></li>
			<li><a hreh="">パズル</a></li>
			<li><a hreh="">アドベンチャー</a></li>
		</ul>
	</div>
	<div class="PSPList">
		<h4>PSP</h4>
		<ul>
			<li><a hreh="">RPG</a></li>
			<li><a hreh="">アクション</a></li>
			<li><a hreh="">パズル</a></li>
			<li><a hreh="">アドベンチャー</a></li>
		</ul>
	</div>
	<div class="PS4List">
		<h4>PS4</h4>
		<ul>
			<li><a hreh="">RPG</a></li>
			<li><a hreh="">アクション</a></li>
			<li><a hreh="">パズル</a></li>
			<li><a hreh="">アドベンチャー</a></li>
		</ul>
	</div>
	<div class="swittchList">
		<h4>switch</h4>
		<ul>
			<li><a hreh="">RPG</a></li>
			<li><a hreh="">アクション</a></li>
			<li><a hreh="">パズル</a></li>
			<li><a hreh="">アドベンチャー</a></li>
		</ul>
	</div>
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