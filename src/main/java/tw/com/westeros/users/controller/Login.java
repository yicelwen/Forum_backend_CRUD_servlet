package tw.com.westeros.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		Users u = new Users();
		u.setUserName(account);
		u.setUserPass(password);

		Users loginUser = new UserService().login(u);

		HttpSession session = request.getSession();
		session.setAttribute("loginSuccessUser", loginUser);
		
		response.sendRedirect("http://localhost:8080/IceAndFire/page/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
