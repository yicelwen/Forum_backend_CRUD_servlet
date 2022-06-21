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
	<form action="Login.do" method="post">
			<table align="center">
			<tr>
				<td colspan="2"
					style="text-align: center; font-siz: 30px; font-weight: bold;">用戶登入</td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登入" /><input
					type="reset" value="清空" /></td>
			</tr>
			</table>
	</form>
</body>
</html>