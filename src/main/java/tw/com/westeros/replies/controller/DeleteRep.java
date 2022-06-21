package tw.com.westeros.replies.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.replies.service.RepService;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/DeleteRep.do")
public class DeleteRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String message = new RepService().deleteRepById(request.getParameter("replyId"));

		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

