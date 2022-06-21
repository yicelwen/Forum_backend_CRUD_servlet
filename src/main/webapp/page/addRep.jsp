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
	<form action="AddRep.do" method="post">
		<table align="center">
			<tr>
				<td colspan="2"
					style="text-align: center; font-siz: 30px; font-weight: bold;">回覆討論新增</td>
			</tr>
			<tr>
			<tr>
				<td>對應文章標題：</td>
				<td>
				<label><input type="radio" name="topName" value="【閒聊】2022年4月閒聊文">【閒聊】2022年4月閒聊文 </label><br>
				<label><input type="radio" name="topName" value="【小說】A clash of kings 心得討論區">【小說】A clash of kings 心得討論區 </label><br>
				<label><input type="radio" name="topName" value="【影集】GOT S8 差評原因?">【影集】GOT S8 差評原因? </label><br>
				<label><input type="radio" name="topName" value="【教學】你對採礦知多少?">【教學】你對採礦知多少?</label><br>
				</td> 
			</tr>
				<td>回覆內容：</td>
				<td><textarea name="repContent" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>回覆日期：</td>
				<td><input type="date" name="repDate"></td>
			</tr>
			<tr>
				<!-- 如何讓登入使用者名稱直接對應到此欄位? -->
				<td>回覆的用戶：</td>
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