package tw.com.westeros.users.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.model.dao.UsersDAO;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/UpdateUser.do")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chaarset=UTF-8");
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);

		int userId =Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String userEmail = request.getParameter("userEmail");
		
		Users u = new Users();
		u.setUserId(userId);
		u.setUserName(userName);
		u.setUserPass(userPass);
		u.setUserEmail(userEmail);
		
		Boolean state =uDao.updateUser(u);
		String message = state ? "修改成功" : "修改失敗";
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
