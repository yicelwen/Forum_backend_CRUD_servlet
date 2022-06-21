package tw.com.westeros.users.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.westeros.users.model.bean.Users;

public class UsersDAO {

	private Connection conn;
	
	public UsersDAO(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 根據使用者ID，取得使用者的Bean，如果找不則回傳null。
	 * 
	 * @param userId 使用者ID
	 * 
	 * @return Users user的Bean
	 */
	public Users getUserById(int userId) {
		Users u = null;

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Users WHERE userId = ?");
			preState.setInt(1, userId);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * 根據使用者name，取得使用者的Bean，如果找不則回傳null。
	 * 
	 * @param userName 使用者name
	 * 
	 * @return Users user的Bean
	 */
	public Users getUserByName(String userName) {

		Users u = new Users();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Users WHERE userName = ?");
			preState.setString(1, userName);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * 取得所有使用者。
	 * 
	 * @return ArrayList<Users> 所有使用者的List集合
	 */
	public ArrayList<Users> getAllUser() {

		ArrayList<Users> aL = new ArrayList<Users>();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Users");
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {
				Users u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				aL.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	
	/**
	 * 根據使用者的ID，刪除指定使用者。刪除成功回傳True。
	 * 
	 * @param userID 使用者ID
	 * 
	 * @return Boolean 預設回傳False，刪除成功回傳True
	 */
	public Boolean deleteUserById(int userId) {

		Boolean state = false;

		try {
			PreparedStatement preState = 
		conn.prepareStatement("DELETE FROM Users WHERE userId = ?");
			preState.setInt(1, userId);

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
	public boolean updateUser(Users u) {
		
		int count = 0;
		try {
			PreparedStatement preState = conn.prepareStatement(
					"UPDATE [dbo].[Users] SET [UserName] = ?,[UserPass] = ?"
					+ ",[UserEmail] = ? WHERE [userId] = ?");
			preState.setString(1, u.getUserName());
			preState.setString(2, u.getUserPass());
			preState.setString(3, u.getUserEmail());
			preState.setInt(4, u.getUserId());

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
	 * 根據輸入的資料，新增一筆使用者。
	 * 
	 * @param User u 使用者 model
	 * 
	 * @return boolean 新增成功回傳True
	 */
	public boolean addUser(Users u) {
		int index = 0;
		try {
			PreparedStatement preState = conn.prepareStatement("INSERT INTO [dbo].[Users]"
					+ "([UserName],[UserPass],[UserEmail],[UserPhoto]) "
					+ "VALUES (?,?,?,?)");
			preState.setString(1,u.getUserName());
			preState.setString(2,u.getUserPass());
			preState.setString(3,u.getUserEmail());
			preState.setString(4,u.getUserPhoto());
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
	
	public List<Users> findUByCond(String uName) {
		try {
			String sql = "SELECT * FROM users WHERE 1=1";
			StringBuffer sb = new StringBuffer(sql);
			List firL = new ArrayList<>();
			if (uName != null && uName != "") {
				sb.append(" and userName like '%'+ ? +'%' ");
				firL.add(uName);
			}
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			for (int i = 1; i <= firL.size(); i++) {
				pstmt.setObject(i, firL.get(i - 1));
			}
			ResultSet rs = pstmt.executeQuery();

			Users u = null;
			List<Users> uL = new ArrayList<Users>();
			while (rs.next()) {
				u = new Users();

				int userId = rs.getInt("UserId");
				String userName = rs.getString("userName");
				String userPass = rs.getString("userPass");
				String uEmail = rs.getString("userEmail");
				String uPhoto = rs.getString("userPhoto");

				u.setUserId(userId);
				u.setUserName(userName);
				u.setUserPass(userPass);
				u.setUserEmail(uEmail);
				u.setUserPhoto(uPhoto);

				uL.add(u);
			}
			return uL;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
