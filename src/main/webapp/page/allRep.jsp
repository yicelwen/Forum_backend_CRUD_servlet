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
 	<a href="addRep.jsp"><button>新增一筆討論串回覆</button></a>
 	</div>
	<table>
		<thead>
			<tr>
				<td>討論串回覆Id</td>
				<td>回覆內容</td>
				<td>回覆日期</td>
				<td>對應標題名稱</td>
				<td>回覆者名字</td>
				<td>刪除按鈕</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${repList}" var="item">

				<tr>
					<td>${item.replyId}</td>
					<td>${item.replyContent}</td>
					<td>${item.replyDate}</td>
					<td>${item.topicSubject}</td>
					<td>${item.userName}</td>

					<td><button class="myTarget" replyId="${item.replyId}">刪除</button></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
 		let btnCollection=document.getElementsByClassName("myTarget");
 		
 		for(item of btnCollection){
 			
 			item.addEventListener("click",function(){
 				let state = window.confirm("確定要刪除此回覆？");
 				if(state){
 				let replyId = this.getAttribute("replyId");
 				
 				document.location.href="DeleteRep.do?replyId="+replyId;
 				}
 			})
 		}
	</script>
</body>
</html>