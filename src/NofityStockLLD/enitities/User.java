package NofityStockLLD.enitities;

import java.util.UUID;

public class User {

	String userID;
	String userName;
	String email;
	String mob;
	
	public User(String userName, String email, String mob) {
		super();
		this.userID = UUID.randomUUID().toString();
		this.userName = userName;
		this.email = email;
		this.mob = mob;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
		
}
