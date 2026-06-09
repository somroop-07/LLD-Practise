package concert_reservation_lld.entitites;

import java.util.Objects;

public class User {
    
	String userId;
	String userName;
	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(userId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}
	
	
}
