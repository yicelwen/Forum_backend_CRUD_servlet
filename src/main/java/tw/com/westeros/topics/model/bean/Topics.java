package tw.com.westeros.topics.model.bean;

import java.io.Serializable;

public class Topics implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int topicId;
	private String topicSubject;
	private String topicDate;
	private String topicContent;
	private String catName;
	private String userName;
	
	public Topics() {}
	
	public Topics(int topicId, String topicSubject, String topicDate, String topicContent, String catName, String userName) {
		super();
		this.topicId = topicId;
		this.topicSubject = topicSubject;
		this.topicDate = topicDate;
		this.topicContent = topicContent;
		this.catName = catName;
		this.userName = userName;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicSubject() {
		return topicSubject;
	}

	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}

	public String getTopicDate() {
		return topicDate;
	}

	public void setTopicDate(String topicDate) {
		this.topicDate = topicDate;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
