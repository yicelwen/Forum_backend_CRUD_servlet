package tw.com.westeros.categories.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.categories.model.bean.Categories;
import tw.com.westeros.categories.service.CatService;

@WebServlet("/page/AddCate.do")
public class AddCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;chaarset=UTF-8");
		CatService cService = new CatService();
		String catName = req.getParameter("newCatName");
		String catDes = req.getParameter("newCatDescript");
		Categories c = new Categories();
		c.setCatName(catName);
		c.setCatDescript(catDes);
		
		Boolean addCat = cService.add(c);
		String message = addCat ? "新增成功" : "新增失敗";
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("message.jsp").forward(req, res);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}