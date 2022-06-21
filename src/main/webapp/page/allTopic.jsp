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

<div><a href="addTop.jsp"><button>新增一筆文章標題</button></a></div>

	<table>
		<thead>
			<tr>
				<td>標題Id</td>
				<td>標題名稱</td>
				<td>標題日期</td>
				<td>標題內文</td>
				<td>討論區分類</td>
				<td>發文用戶</td>
				<td>刪除按鈕</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${topicList}" var="item">

				<tr>
					<td>${item.topicId}</td>
					<td>${item.topicSubject}</td>
					<td>${item.topicDate}</td>
					<td>${item.topicContent}</td>
					<td>${item.catName}</td>
					<td>${item.userName}</td>
					<td><button class="myTarget" topicId="${item.topicId}">刪除</button></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
 		let btnCollection=document.getElementsByClassName("myTarget");
 		
 		for(item of btnCollection){
 			
 			item.addEventListener("click",function(){
 				let state = window.confirm("確定要刪除此標題？");
 				if(state){
 				let topicId = this.getAttribute("topicId");
 				
 				document.location.href="DeleteTopic.do?topicId="+topicId;
 				}
 			})
 		}
	</script>
</body>
</html>