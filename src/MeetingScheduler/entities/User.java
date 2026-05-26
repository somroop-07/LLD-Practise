package MeetingScheduler.entities;

import java.util.UUID;

public class User {
    String id;
    String email;
	public User(String email) {
		super();
		id = UUID.randomUUID().toString();
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}

    
}
