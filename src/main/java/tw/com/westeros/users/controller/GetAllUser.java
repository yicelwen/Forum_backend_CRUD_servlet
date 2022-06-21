package tw.com.westeros.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/GetAllUser.do")
public class GetAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserService uService = new UserService();
		ArrayList<Users> aL = uService.getUserList();
		
		
		request.setAttribute("userList", aL);
		request.getRequestDispatcher("allUser.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
