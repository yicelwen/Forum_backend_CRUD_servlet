package tw.com.westeros.categories.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.westeros.categories.model.bean.Categories;
import tw.com.westeros.categories.model.dao.CategoriesDAO;
import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.model.dao.UsersDAO;

@WebServlet("/page/UpdateCate.do")
public class UpdateCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chaarset=UTF-8");
		Connection conn = ConnectionFactory.getConn();
		CategoriesDAO cDao = new CategoriesDAO(conn);

		int catId =Integer.parseInt(request.getParameter("catId"));
		String catName = request.getParameter("catName");
		String catDescript = request.getParameter("catDescript");
		
		Categories c = new Categories();
		c.setCatId(catId);
		c.setCatName(catName);
		c.setCatDescript(catDescript);
		
		Boolean state =cDao.updateCate(c);
		String message = state ? "修改成功" : "修改失敗";
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
