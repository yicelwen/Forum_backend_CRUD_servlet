package tw.com.westeros.replies.model.bean;

import java.io.Serializable;

public class Replies implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int replyId;
	private String replyContent;
	private String replyDate;
	private String topicSubject;
	private String userName;
	
	public Replies() {}
	
	public Replies(int replyId, String replyContent, String replyDate, String topicSubject, String userName) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.topicSubject = topicSubject;
		this.userName = userName;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getTopicSubject() {
		return topicSubject;
	}

	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
}
