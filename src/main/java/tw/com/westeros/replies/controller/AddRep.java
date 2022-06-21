package tw.com.westeros.replies.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.replies.model.bean.Replies;
import tw.com.westeros.replies.service.RepService;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;


@WebServlet("/page/AddRep.do")
public class AddRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;chaarset=UTF-8");
		RepService rService = new RepService();
		String rContent = req.getParameter("repContent");
		String rDate = req.getParameter("repDate");
		String tName = req.getParameter("topName");
		String uName = req.getParameter("userName");
		
		Replies r = new Replies();
		
		r.setReplyContent(rContent);
		r.setReplyDate(rDate);
		r.setTopicSubject(tName);
		r.setUserName(uName);
		
		Boolean state = rService.add(r);		
		String message = state ? "新增成功" : "新增失敗";
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("message.jsp").forward(req, res);
		}



	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}

}
