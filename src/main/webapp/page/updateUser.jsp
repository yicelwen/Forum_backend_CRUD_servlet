<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.com.westeros.users.model.bean.*"%>
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
	<%
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String userPass = request.getParameter("userPass");
	String userEmail = request.getParameter("userEmail");
	String userPhoto = request.getParameter("userPhoto");
	%>
	<fieldset>
		<legend style="text-align: center; font-size: 30px; font-weight: bold;">修改一筆使用者資料</legend>

		<form action="UpdateUser.do" method="post">

			<span>用戶識別碼：</span> 
			<span><input type="text" name="userId" value="<%=userId %>" readonly="readonly" size="20" /></span><br>
			
			<span>使用者名稱：</span> 
			<span><input type="text" name="userName" value="<%=userName %>" size="20" /></span><br>
			
			<span>使用者密碼：</span> 
			<span><input type="text" name="userPass" value="<%=userPass %>" size="20" /></span><br>
				
			<span>使用者電郵：</span>
			<span><input type="text" name="userEmail" value="<%=userEmail %>" size="20" /></span><br>
			
			<input type="submit" value="提交">
		</form>
	</fieldset>
</body>
</html>