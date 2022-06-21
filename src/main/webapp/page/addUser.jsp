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
    <form action="AddUser.do" method="post">
        <table align="center">
            <tr>
                <td colspan="2"
                    style="text-align: center; font-siz: 30px; font-weight: bold;">使用者欄位新增</td>
            </tr>
            <tr>
                <td>使用者名稱：</td>
                <td><input type="text" name="newUserName"></td>
            </tr>
            <tr>
                <td>使用者密碼：</td>
                <td><input type="text" name="newUserPass"></td>
            </tr>
            <tr>
                <td>使用者電郵：</td>
                <td><input type="email" name="newUserEmail"></td>
            </tr>
            <tr>
                <td>使用者照片：<br>
                <div style="bolder;">**僅接受 BASE 64格式**</div>
                <a href="https://webtool.yah101.com/zh-tw/e_d/Base64_Encode_Image" target="_blank" rel="noopener noreferrer">前往圖片加密BASE64(外部)鏈結</a>
                </td>
                <td>
				<textarea name="topicContent" rows="8" cols="50"></textarea>
                
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="新增" /><input
                    type="reset" value="清空" /></td>
            </tr>
        </table>
    </form>
</body>
</html>