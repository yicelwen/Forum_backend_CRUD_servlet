package tw.com.westeros.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/AddUser.do")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;chaarset=UTF-8");
		UserService uService = new UserService();
		String name = req.getParameter("newUserName");
		String pass = req.getParameter("newUserPass");
		String email = req.getParameter("newUserEmail");
		String photo = req.getParameter("newUserPhoto");
		
		Users u = new Users();
		
		u.setUserName(name);
		u.setUserPass(pass);
		u.setUserEmail(email);
		u.setUserPhoto(photo);
		
		Boolean state = uService.add(u);		
		String message = state ? "新增成功" : "新增失敗";
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("message.jsp").forward(req, res);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
