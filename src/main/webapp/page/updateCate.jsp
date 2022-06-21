<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.com.westeros.categories.model.bean.*"%>
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
	String catId = request.getParameter("catId");
	String catName = request.getParameter("catName");
	String catDescript = request.getParameter("catDescript");
	%>
	<fieldset>
		<legend style="text-align: center; font-size: 30px; font-weight: bold;">修改一筆討論區分類資料</legend>

		<form action="UpdateCate.do" method="post">

			<span>用戶識別碼：</span> 
			<span><input type="text" name="catId" value="<%=catId %>" readonly="readonly" size="20" /></span><br>
			
			<span>使用者名稱：</span> 
			<span><input type="text" name="catName" value="<%=catName %>" size="20" /></span><br>
			
			<span>使用者密碼：</span> 
			<span><input type="text" name="catDescript" value="<%=catDescript %>" size="20" /></span><br>
			
			<input type="submit" value="提交">
		</form>
	</fieldset>
</body>
</html>