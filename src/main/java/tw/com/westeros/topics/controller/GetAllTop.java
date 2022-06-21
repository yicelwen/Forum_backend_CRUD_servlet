package tw.com.westeros.topics.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.topics.model.bean.Topics;
import tw.com.westeros.topics.service.TopService;

@WebServlet("/page/GetAllTop.do")
public class GetAllTop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		TopService tService = new TopService();
		ArrayList<Topics> aL = tService.getTopicList();
		
		request.setAttribute("topicList", aL);
		request.getRequestDispatcher("allTopic.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
