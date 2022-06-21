package tw.com.westeros.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/Logout.do")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equals("JSESSIONID")) {
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}
		
		response.sendRedirect("/IceAndFire/page/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
