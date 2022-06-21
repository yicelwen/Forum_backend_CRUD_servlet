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
<div><a href="addCate.jsp"><button>新增一項分類欄位</button></a></div>

	<table>
		<thead>
			<tr>
				<td>討論分類Id</td>
				<td>討論分類名稱</td>
				<td>討論分類敘述</td>
				<td>修改按鈕</td>
				<td>刪除按鈕</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cateList}" var="item">

				<tr>
					<td>${item.catId}</td>
					<td>${item.catName}</td>
					<td>${item.catDescript}</td>

					<td>
					<a href="updateCate.jsp?catId=${item.catId}&catName=${item.catName}&catDescript=${item.catDescript}">
					<button class="reviseTar">修改</button>
					</a></td>
					<td><button class="myTarget" catId="${item.catId}">刪除</button></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
 		let btnCollection=document.getElementsByClassName("myTarget");
 		
 		for(item of btnCollection){
 			
 			item.addEventListener("click",function(){
 				let state = window.confirm("確定要刪除此討論分類？");
 				if(state){
 				let catId = this.getAttribute("catId");
 				
 				document.location.href="DeleteCate.do?catId="+catId;
 				}
 			})
 		}
		let button = document.getElementsByClassName("reviseTar");

		for(item of button){
			item.addEventListener("click",function(){
				let state = window.confirm("確定要修改這筆討論區分類資料？");
				if(state){
				let catId = this.getAttribute("catId");
							
				document.location.href = "UpdateCate.do?catId="+catId;
					}
				})
			}
	</script>
</body>
</html>