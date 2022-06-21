package tw.com.westeros.users.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/FindUser.do")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userName = request.getParameter("userName");

		UserService uService = new UserService();
		List<Users> list = uService.findUByCond(userName);

		System.out.println(list);

		if (list != null) {
			request.setAttribute("userList", list);
			request.getRequestDispatcher("allUser.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
