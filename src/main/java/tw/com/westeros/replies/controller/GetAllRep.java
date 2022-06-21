package tw.com.westeros.replies.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.replies.model.bean.Replies;
import tw.com.westeros.replies.service.RepService;

@WebServlet("/page/GetAllRep.do")
public class GetAllRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RepService rService = new RepService();
		ArrayList<Replies> aL = rService.getRepList();
		
		request.setAttribute("repList", aL);
		request.getRequestDispatcher("allRep.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
