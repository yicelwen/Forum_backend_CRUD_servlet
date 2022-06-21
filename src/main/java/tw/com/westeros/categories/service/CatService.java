package tw.com.westeros.categories.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.topics.model.bean.Topics;
import tw.com.westeros.topics.model.dao.TopicsDAO;
import tw.com.westeros.categories.model.bean.Categories;
import tw.com.westeros.categories.model.dao.CategoriesDAO;

/**
 * 存放討論分類 Categories 相關的服務，如..等等
 */
public class CatService {

	/**
	 * 呼叫此方法，可以取得所有討論分類的清單。
	 * 
	 * @return ArrayList<Categories> 回傳討論分類LIST
	 */
	public ArrayList<Categories> getCateList() {
		Connection conn = ConnectionFactory.getConn();
		CategoriesDAO cDao = new CategoriesDAO(conn);
		ArrayList<Categories> aL = cDao.getAllCat();

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}

	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆文章分類。
	 * 
	 * @param categoryId (Int 基本資料型別)
	 * 
	 * @return message 回傳刪除失敗或成功的字串
	 */
	public String deleteCateById(int catId) {
		Connection conn = ConnectionFactory.getConn();
		CategoriesDAO cDao = new CategoriesDAO(conn);
		Boolean state = cDao.deleteCatById(catId);
		String message = "";
		if (state) {
			message = "刪除成功";
		} else {
			message = "刪除失敗。可能的原因：此標題ID存在於其他資料表中。";
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆文章分類。
	 * 
	 * @param categoryId  (String 參考資料型別)
	 * 
	 * @return message 回傳刪除失敗或成功的字串
	 */
	public String deleteCateById(String catId) {
		Connection conn = ConnectionFactory.getConn();
		CategoriesDAO cDao = new CategoriesDAO(conn);
		Boolean state = cDao.deleteCatById(Integer.valueOf(catId));
		String message = "";
		if (state) {
			message = "刪除成功";
		} else {
			message = "刪除失敗";
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 新增一筆文章分類區資料
	 * 
	 * @param Categories 文章分類區 BEAN
	 * 
	 * @return  1 = 新增成功, 0 = 新增失敗
	 */
	public boolean add(Categories c) {
		Connection conn = ConnectionFactory.getConn();
		CategoriesDAO cDao = new CategoriesDAO(conn);
		return cDao.addCate(c);
	}
}