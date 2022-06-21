<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>冰與火之歌之萬物皆聊論壇</title>
<link rel="stylesheet" href="basicStyle.css">
</head>
<body>
	<div class="topnav">
		<a class="active" href="index.jsp">回到首頁</a> 
		<a href="GetAllUser.do">用戶管理頁</a>
		<a href="GetAllCate.do">分類管理頁</a> 
		<a href="GetAllTop.do">標題管理頁</a> 
		<a href="GetAllRep.do">回覆管理頁</a>
	</div>
	<form action="AddTop.do" method="post">
		<table align="center">
			<tr>
				<td colspan="2"
					style="text-align: center; font-siz: 30px; font-weight: bold;">文章標題新增</td>
			</tr>
			<tr>
				<td>文章標題：</td>
				<td><input type="text" name="topicSubject"></td>
			</tr>
			<tr>
				<td>文章日期：</td>
				<td><input type="date" name="topicDate"></td>
			</tr>
			<tr>
				<td>標題內文：</td>
				<td><textarea name="topicContent" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>討論區分類：</td>
				<td>
				<label><input type="radio" name="catName" value="公告與情報專區">公告與情報專區 </label><br>
				<label><input type="radio" name="catName" value="冰與火之歌—小說討論區">冰與火之歌—小說討論區 </label><br>
				<label><input type="radio" name="catName" value="權力遊戲—影集討論區">權力遊戲—影集討論區 </label><br>
				<label><input type="radio" name="catName" value="衍生作品討論區">衍生作品討論區 </label><br>
				<label><input type="radio" name="catName" value="離題專區">離題專區 </label><br>
				</td> 
			</tr>
			<tr>
				<!-- 如何讓登入使用者名稱直接對應到此欄位? -->
				<td>發文用戶：</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="送出" /><input
					type="reset" value="清空" /></td>
			</tr>
		</table>
	</form>
</body>
</html>