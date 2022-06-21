package tw.com.westeros.topics.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.topics.model.bean.Topics;
import tw.com.westeros.topics.service.TopService;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.service.UserService;

@WebServlet("/page/AddTop.do")
public class AddTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;chaarset=UTF-8");
		TopService tService = new TopService();
		String subject = req.getParameter("topicSubject");
		String date = req.getParameter("topicDate");
		String content = req.getParameter("topicContent");
		String catName = req.getParameter("catName");
		String userName = req.getParameter("userName");
		
		Topics t = new Topics();
		
		t.setTopicSubject(subject);
		t.setTopicDate(date);
		t.setTopicContent(content);
		t.setCatName(catName);
		t.setUserName(userName);
		
		Boolean addTopic = tService.add(t);
		String message = addTopic ? "新增成功" : "新增失敗";
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("message.jsp").forward(req, res);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
