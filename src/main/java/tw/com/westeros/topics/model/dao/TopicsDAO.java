package tw.com.westeros.topics.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tw.com.westeros.topics.model.bean.Topics;
import tw.com.westeros.users.model.bean.Users;

public class TopicsDAO {
	
	private Connection conn;
	
	public TopicsDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 根據標題ID，取得標題的Bean，如果找不到則回傳null。
	 * 
	 * @param topicID 標題ID
	 * 
	 * @return Topics topic的Bean
	 */
	public Topics getTopicById(int topicId) {
		Topics t = null;

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Topics WHERE topicId = ?");
			preState.setInt(1, topicId);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				t = new Topics(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 根據標題topic，取得標題的Bean，如果找不到則回傳null。
	 * 
	 * @param topicName 標題topic
	 * 
	 * @return Topics topic的Bean
	 */
	public Topics getTopicByName(String topicSubject) {

		Topics t = new Topics();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Topics WHERE topicSubject LIKE ?");
			preState.setString(1, topicSubject);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				t = new Topics(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 取得所有標題。
	 * 
	 * @return ArrayList<Topics> 所有標題的List集合
	 */
	public ArrayList<Topics> getAllTopics() {

		ArrayList<Topics> aL = new ArrayList<Topics>();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Topics");
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {
				Topics t = new Topics(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				aL.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	
	/**
	 * 根據標題的ID，刪除指定標題。刪除成功回傳True。
	 * 
	 * @param topicID 標題ID
	 * 
	 * @return Boolean 預設回傳False，刪除成功回傳True
	 */
	public Boolean deleteTopicById(int topicId) {

		Boolean state = false;

		try {
			PreparedStatement preState = 
		conn.prepareStatement("DELETE FROM Topics WHERE topicId = ?");
			preState.setInt(1, topicId);

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
	 * 根據輸入的資料，新增一筆文章標題。
	 * 
	 * @param Topics t 標題 model
	 * 
	 * @return int 預設回傳0，更新成功回傳1
	 */
	public boolean addTopic(Topics t) {
		int index = 0;
		try {
			PreparedStatement preState = conn.prepareStatement("INSERT INTO [dbo].[Topics]"
					+ "([TopicSubject],[TopicDate],[TopicContent],[CatName],[UserName]) "
					+ "VALUES (?,?,?,?,?)");
			preState.setString(1,t.getTopicSubject());
			preState.setString(2,t.getTopicDate());
			preState.setString(3,t.getTopicContent());
			preState.setString(4,t.getCatName());
			preState.setString(5,t.getUserName());
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
