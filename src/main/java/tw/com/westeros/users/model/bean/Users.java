package tw.com.westeros.users.model.bean;

import java.io.Serializable;

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userName;
	private String userPass;
	private String userEmail;
	private String userPhoto;
	
	public Users() {}
	
	public Users(int userId, String userName, String userPass, String userEmail, String userPhoto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userPhoto = userPhoto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	
	
}