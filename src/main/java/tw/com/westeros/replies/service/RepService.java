package tw.com.westeros.replies.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.replies.model.bean.Replies;
import tw.com.westeros.replies.model.dao.RepliesDAO;
import tw.com.westeros.users.model.bean.Users;
import tw.com.westeros.users.model.dao.UsersDAO;

/**
 * 存放討論串回覆 Replies 相關的服務，如..等等
 */
public class RepService {
	
	/**
	 * 呼叫此方法，可以取得所有討論串回覆的清單。
	 * 
	 * @return ArrayList<Replies> 回傳討論串回覆LIST
	 */
	public ArrayList<Replies> getRepList() {
		Connection conn = ConnectionFactory.getConn();
		RepliesDAO rDao = new RepliesDAO(conn);
		ArrayList<Replies> aL = rDao.getAllReplies();

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}

	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆回覆。
	 * 
	 * @param replyId (Int 基本資料型別)
	 * 
	 * @return message 回傳刪除成功或失敗
	 */
	public String deleteRepById(int replyId) {
		Connection conn = ConnectionFactory.getConn();
		RepliesDAO rDao = new RepliesDAO(conn);
		Boolean state = rDao.deleteRepliesById(replyId);
		String message = "";
		if (state) {
			message = "刪除成功";
		} else {
			message = "刪除失敗。可能的原因：此回覆ID存在於其他資料表中。";
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆回覆。
	 * 
	 * @param replyId (String 基本資料型別)
	 * 
	 * @return message 回傳刪除成功或失敗
	 */
	public String deleteRepById(String replyId) {
		Connection conn = ConnectionFactory.getConn();
		RepliesDAO rDao = new RepliesDAO(conn);
		Boolean state = rDao.deleteRepliesById(Integer.valueOf(replyId));
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
	 * 新增一筆使用者資料
	 * 
	 * @param users 使用者BEAN
	 * 
	 * @return  true = 新增成功, false = 新增失敗
	 */
	public boolean add(Replies r) {
		Connection conn = ConnectionFactory.getConn();
		RepliesDAO rDao = new RepliesDAO(conn);
		return rDao.addRep(r);
	}
}
