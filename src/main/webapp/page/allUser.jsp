<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div>
		<a href="addUser.jsp"><button>新增一筆使用者</button></a>
	</div>
	<form action="FindUser.do"> 
	<div style="font-weight: bolder;font-size:20px;">查詢特定一筆使用者：</div>
	<div style="margin-bottom: 20px;">使用者名稱：<input type="text" name="userName">
		<input type="submit" value="查詢"></div>
		
	</form>
	<table>
		<thead>
			<tr>
				<td>使用者Id</td>
				<td>使用者名稱</td>
				<td>使用者密碼</td>
				<td>使用者電郵</td>
				<td>使用者照片</td>
				<td>修改按鈕</td>
				<td>刪除按鈕</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="item">
				<tr>
					<td>${item.userId}</td>
					<td>${item.userName}</td>
					<td>${item.userPass}</td>
					<td>${item.userEmail}</td>
					<td><img width=120px height=120px src="${item.userPhoto}" class="userpic"></td>
					
					<td>
					<a href="updateUser.jsp?userId=${item.userId}&userName=${item.userName}&userPass=${item.userPass}&userEmail=${item.userEmail}">
					<button class="reviseTar">修改</button>
					</a></td>
					
					<td>
						<button class="myTarget" userId="${item.userId}">刪除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
 		let btnCollection = document.getElementsByClassName("myTarget");
 		
 		for(item of btnCollection){
 			
 			item.addEventListener("click",function(){
 				let state = window.confirm("確定要刪除此用戶？");
 				if(state){
 				let userId = this.getAttribute("userId");
 				
 				document.location.href="DeleteUser.do?userId="+userId;
 					}
 				})
 			}

		let button = document.getElementsByClassName("reviseTar");

		for(item of button){
			item.addEventListener("click",function(){
				let state = window.confirm("確定要修改這筆使用者資料？");
				if(state){
				let userId = this.getAttribute("userId");
							
				document.location.href = "UpdateUser.do?userId="+userId;
					}
				})
			}
	</script>
</body>
</html>