package WatchPartySystem.model;

public class User implements IUSer{

	String id;
	String userName;
	
	public User(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public void updateMovieState(MovieState state) {
		System.out.println("Sending updates to user");
	}
	
	
}
