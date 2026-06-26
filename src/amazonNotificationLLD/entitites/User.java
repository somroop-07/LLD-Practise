package amazonNotificationLLD.entitites;

public class User {
     
	  String userId;
	  String userName;
	  Channel preferredChannel;
	  //mobile number, email, deviceToken
	  
	  public User(String userId, String userName, Channel preferredChannel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.preferredChannel = preferredChannel;
	  }

	  public Channel getPreferredChannel() {
		  return preferredChannel;
	  }
	  	  
}
