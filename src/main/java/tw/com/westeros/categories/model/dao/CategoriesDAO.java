package tw.com.westeros.categories.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.com.westeros.categories.model.bean.Categories;
import tw.com.westeros.users.model.bean.Users;

public class CategoriesDAO {
	
	private Connection conn;
	
	public CategoriesDAO(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 根據分類ID，取得分類的Bean，如果找不則回傳null。
	 * 
	 * @param catId 分類ID
	 * 
	 * @return Categories Category的Bean
	 */
	public Categories getCatById(int catId) {
		Categories c = null;

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Categories WHERE catId = ?");
			preState.setInt(1, catId);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				c = new Categories(rs.getInt(1), rs.getString(2),rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 根據分類名稱catName，取得類別的catName，如果找不則回傳null。
	 * 
	 * @param catName 分類name
	 * 
	 * @return Categories category的Bean
	 */
	public Categories getCatByName(String catName) {

		Categories c = new Categories();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Categories WHERE catName = ?");
			preState.setString(1, catName);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				c = new Categories(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 取得所有分類。
	 * 
	 * @return ArrayList<Categories> 所有分類的List集合
	 */
	public ArrayList<Categories> getAllCat() {

		ArrayList<Categories> aL = new ArrayList<Categories>();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Categories");
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {
				Categories u = new Categories(rs.getInt(1), rs.getString(2), rs.getString(3));
				aL.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	
	/**
	 * 根據分類的ID，刪除指定分類。刪除成功回傳True。
	 * 
	 * @param catID 分類ID
	 * 
	 * @return Boolean 預設回傳False，刪除成功回傳True
	 */
	public Boolean deleteCatById(int catId) {

		Boolean state = false;

		try {
			PreparedStatement preState = 
		conn.prepareStatement("DELETE FROM Categories WHERE catId = ?");
			preState.setInt(1, catId);

			int i = preState.executeUpdate();
			if (i == 1) {
				state = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}	
	
	
	
	/**
	 * 根據使用者的ID，更新指定使用者的資料。更新成功回傳True。
	 * 
	 * @param User u 使用者 model
	 * 
	 * @return boolean 預設回傳False，更新成功回傳True
	 */
	public boolean updateCate(Categories c) {
		
		int count = 0;
		try {
			PreparedStatement preState = conn.prepareStatement(
					"UPDATE [dbo].[Categories]"
					+ "   SET [CatName] = ?,[CatDescript] = ? WHERE [CatId] = ?");
			preState.setString(1, c.getCatName());
			preState.setString(2, c.getCatDescript());
			preState.setInt(3, c.getCatId());

			count = preState.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count >= 1 ? true : false;
	}
	
	/**
	 * 根據輸入的資料，新增一筆文章分類。
	 * 
	 * @param Categories c 文章類別 model
	 * 
	 * @return boolean 新增成功回傳True
	 */
	public boolean addCate(Categories c){
		int index = 0;
		try {
			PreparedStatement preState = conn.prepareStatement("INSERT INTO [dbo].[Categories]"
					+ "([CatName],[CatDescript])"
					+ "VALUES (?,?)");
			preState.setString(1,c.getCatName());
			preState.setString(2,c.getCatDescript());
			index = preState.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println("Error:"+e.getErrorCode());
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return index >= 1 ? true : false;
	}
}
