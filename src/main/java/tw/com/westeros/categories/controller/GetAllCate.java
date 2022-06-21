package tw.com.westeros.categories.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.categories.model.bean.Categories;
import tw.com.westeros.categories.service.CatService;

@WebServlet("/page/GetAllCate.do")
public class GetAllCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		CatService cService = new CatService();
		ArrayList<Categories> aL = cService.getCateList();
		
		request.setAttribute("cateList", aL);
		request.getRequestDispatcher("allCate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
