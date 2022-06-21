package tw.com.westeros.replies.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.com.westeros.replies.model.bean.Replies;
import tw.com.westeros.topics.model.bean.Topics;

public class RepliesDAO {

	private Connection conn;
	
	public RepliesDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 根據回覆ID，取得回覆的Bean，如果找不到則回傳null。
	 * 
	 * @param replyID 回覆ID
	 * 
	 * @return Replies reply的Bean
	 */
	public Replies getRepliesById(int replyId) {
		Replies r = null;

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Replies WHERE replyId = ?");
			preState.setInt(1, replyId);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				r = new Replies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	/**
	 * 根據回覆內容replies，取得回覆的Bean，如果找不到則回傳null。
	 * 
	 * @param replyContent 回覆 replyContent
	 * 
	 * @return Replies reply的Bean
	 */
	public Replies getRepliesByContent(String replyContent) {

		Replies r = new Replies();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Replies WHERE replyContent LIKE ?");
			preState.setString(1, replyContent);

			ResultSet rs = preState.executeQuery();
			if (rs.next()) {
				r = new Replies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	/**
	 * 取得所有回覆。
	 * 
	 * @return ArrayList<Replies> 所有回覆的List集合
	 */
	public ArrayList<Replies> getAllReplies() {

		ArrayList<Replies> aL = new ArrayList<Replies>();

		try {
			PreparedStatement preState = conn.prepareStatement("SELECT * FROM Replies");
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {
				Replies r = new Replies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				aL.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aL;
	}
	
	
	/**
	 * 根據回覆的ID，刪除指定回覆。刪除成功回傳True。
	 * 
	 * @param replyID 回覆ID
	 * 
	 * @return Boolean 預設回傳False，刪除成功回傳True
	 */
	public Boolean deleteRepliesById(int replyId) {

		Boolean state = false;

		try {
			PreparedStatement preState = 
		conn.prepareStatement("DELETE FROM Replies WHERE replyId = ?");
			preState.setInt(1, replyId);

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
	public boolean addRep(Replies r) {
		int index = 0;
		try {
			PreparedStatement preState = conn.prepareStatement("INSERT INTO [dbo].[Replies]"
					+ "([ReplyContent],[ReplyDate],[TopicSubject],[UserName]) "
					+ "VALUES (?,?,?,?)");
			preState.setString(1,r.getReplyContent());
			preState.setString(2,r.getReplyDate());
			preState.setString(3,r.getTopicSubject());
			preState.setString(4,r.getUserName());
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
