package tw.com.westeros.topics.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.com.westeros.conn.ConnectionFactory;
import tw.com.westeros.topics.model.bean.Topics;
import tw.com.westeros.topics.model.dao.TopicsDAO;
import tw.com.westeros.users.model.dao.UsersDAO;

/**
 * 存放標題 Topics 相關的服務，如..等等
 */
public class TopService {
	
	/**
	 * 呼叫此方法，可以取得所有標題的清單。
	 * 
	 * @return ArrayList<Topics> 回傳標題LIST
	 */
	public ArrayList<Topics> getTopicList() {
		Connection conn = ConnectionFactory.getConn();
		TopicsDAO tDao = new TopicsDAO(conn);
		ArrayList<Topics> aL = tDao.getAllTopics();

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	/**
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆標題。
	 * 
	 * @param topicId (Int 基本資料型別)
	 * 
	 * @return message 回傳刪除失敗或成功的字串
	 */
	public String deleteTopicById(int topicId) {
		Connection conn = ConnectionFactory.getConn();
		TopicsDAO tDao = new TopicsDAO(conn);
		Boolean state = tDao.deleteTopicById(topicId);
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
	 * 呼叫此方法，可以依提供的ID編號刪除特定一筆標題。
	 * 
	 * @param userId (String 參考資料型別)
	 * 
	 * @return message 回傳刪除失敗或成功的字串
	 */
	public String deleteTopicById(String topicId) {
		Connection conn = ConnectionFactory.getConn();
		TopicsDAO tDao = new TopicsDAO(conn);
		Boolean state = tDao.deleteTopicById(Integer.valueOf(topicId));
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
	 * 新增一筆文章標題資料
	 * 
	 * @param users 使用者BEAN
	 * 
	 * @return  1 = 新增成功, 0 = 新增失敗
	 */
	public boolean add(Topics t) {
		Connection conn = ConnectionFactory.getConn();
		TopicsDAO tDao = new TopicsDAO(conn);
		return tDao.addTopic(t);
	}
}
