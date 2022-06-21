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
	
	<form action="AddCate.do" method="post">
		<table align="center">
			<tr>
				<td colspan="2"
					style="text-align: center; font-size: 30px; font-weight: bold;">討論分類欄位新增</td>
			</tr>
			<tr>
				<td>分類名稱：</td>
				<td><input type="text" name="newCatName"></td>
			</tr>
			<tr>
				<td>分類敘述：</td>
				<td><input type="text" name="newCatDescript"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="送出" /><input
					type="reset" value="清空" /></td>
			</tr>
		</table>
	</form>
</body>
</html>