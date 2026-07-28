package mediator_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Client {

}

interface ChatMediator {
	void addUsers(User user);
	void sendMessage(User from, String text);
}

abstract class User {
	String userID;
	ChatMediator chatMediator;
	
	public User(String userID, ChatMediator chatMediator) {
		super();
		this.userID = userID;
		this.chatMediator = chatMediator;
	}

	abstract void sendMessage(String text);
	abstract void recieveMessage(String text);
}

class ChatRoom implements ChatMediator {
	List<User> users = new ArrayList<>();

	@Override
	public void addUsers(User user) {
		users.add(user);		
	}

	@Override
	public void sendMessage(User from, String text) {
		for(User user : users) {
			if(user.userID.equals(from.userID)) {
				continue;
			}
			user.recieveMessage(text);
		}
		
	}
	
}
class ChatUser extends User {

	public ChatUser(String userID, ChatMediator chatMediator) {
		super(userID, chatMediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	void sendMessage(String text) {
		chatMediator.sendMessage(this, text);
		
	}

	@Override
	void recieveMessage(String text) {
		System.out.println("Text recieved by " + userID);
	}
	
}
