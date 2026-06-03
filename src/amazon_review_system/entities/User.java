package amazon_review_system.entities;

public class User {

	String userId;
	String userName;
	public User(String userId, String string) {
		super();
		this.userId = userId;
		this.userName = string;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
