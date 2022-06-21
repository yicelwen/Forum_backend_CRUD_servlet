package tw.com.westeros.users.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.model.dao.UsersDAO;

/**
 * 存放使用者相關的服務，如登入、註冊、取得使用者等等
 */
public class UserService {

	/**
	 * 呼叫此方法，可以取得使用者的清單。
	 * 
	 * @return ArrayList<Users> 回傳使用者LIST
	 */
	public ArrayList<Users> getUserList() {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);
		ArrayList<Users> aL = uDao.getAllUser();

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆使用者。
	 * 
	 * @param userId (Int 基本資料型別)
	 * 
	 * @return message 回傳刪除成功或失敗
	 */
	public String deleteUserByID(int userId) {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);
		Boolean state = uDao.deleteUserById(userId);
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
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆使用者。
	 * 
	 * @param userId (String 參考資料型別)
	 * 
	 * @return message 回傳刪除成功或失敗
	 */
	public String deleteUserById(String userId) {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);

		Boolean state = uDao.deleteUserById(Integer.valueOf(userId));
		String message = "";
		if (state) {
			message = "刪除成功";
		} else {
			message = "刪除失敗。可能的原因：此用戶的ID存在於其他資料表中。";
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 根據用戶ID 更新一筆使用者資料。
	 * 
	 * @param user 使用者bean
	 * 
	 * @return message 回傳新增成功或失敗的訊息
	 */
	public String updateUser(Users u) {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);

		Boolean state = uDao.updateUser(u);
		String message = "";
		if (state) {
			message = "更新該筆使用者資料成功";
		} else {
			message = "更新失敗。";
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	/**
	 * 新增一筆使用者資料
	 * 
	 * @param users 使用者BEAN
	 * 
	 * @return  true = 新增成功, false = 新增失敗
	 */
	public boolean add(Users u) {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);
		return uDao.addUser(u);
	}
	
	public List<Users> findUByCond(String uName) {
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);
		return uDao.findUByCond(uName);
	}


	/**
	 * 根據傳入的帳號、密碼，驗證使用者是否登入成功。
	 * 
	 * @param u Users類，使用者的Bean
	 * @return Users 使用者的Bean，裡面包含所有使用者資料。
	 */
	public Users login(Users u) {

		Users returnUserBean = null;
		
		
		Connection conn = ConnectionFactory.getConn();
		UsersDAO uDao = new UsersDAO(conn);

		Users userFromDB = uDao.getUserByName(u.getUserName());

		if (u.getUserPass().equals(userFromDB.getUserPass())) {
			returnUserBean = userFromDB;

		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnUserBean;
	}

}