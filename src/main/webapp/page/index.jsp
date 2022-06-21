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

<fieldset align="center" style="margin-bottom: 10px;">
<legend>冰與火之歌之論壇之後台</legend>
<h5>這是一個可以討論<u>權力遊戲電視劇</u>、<u>冰與火之歌</u>小說、或者其他奇幻故事的空間。</h5>
	<c:if test="${!empty loginSuccessUser }">
		<div>歡迎你! ${loginSuccessUser.userName} <a href="Logout.do"><button>登出</button></a>
		</div>
	</c:if>
	<c:if test="${empty loginSuccessUser }">
		<div>
			<a href="login.jsp">
				<button>登入</button>
			</a>
		</div>
	</c:if>
</fieldset>
	
<fieldset align="center" style="margin-bottom: 40px;">
<legend>論壇後台管理 </legend>
	<div>
		<a href="GetAllUser.do"><button>進入用戶管理介面</button></a>
	</div>
	<div>
		<a href="GetAllCate.do"><button>進入論壇分類管理介面</button></a>
	</div>
	<div>
		<a href="GetAllTop.do"><button>進入討論標題管理介面</button></a>
	</div>
	<div>
		<a href="GetAllRep.do"><button>進入回覆討論串管理介面</button></a>
	</div>
</fieldset>	
<div class="base">台南跨域 Java 班 (EEIT 43) | 第二次期中專題 </div>
<div class="base">學號：19 | 學員姓名：張貽雯</div>
</body>
<style type="text/css">
.base{
	color: rgb(122, 122, 122);
	display: flex; 
	justify-content:center; 
	align-items:flex-end;
}
</style>
</html>