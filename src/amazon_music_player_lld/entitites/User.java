package amazon_music_player_lld.entitites;

import java.util.HashMap;
import java.util.Map;

public class User {

	String userName;
	Map<String, Playlist> allPlayLists = new HashMap<>();
	
	
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public void addPlayList(Playlist playlist) {
		allPlayLists.put(playlist.getId(), playlist);
	}

	public String getUserName() {
		return userName;
	}

	public Map<String, Playlist> getAllPlayLists() {
		return allPlayLists;
	}
	
	
}
