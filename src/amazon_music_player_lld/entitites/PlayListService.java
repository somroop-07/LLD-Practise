package amazon_music_player_lld.entitites;

import java.util.HashMap;
import java.util.Map;

public class PlayListService {


	public Playlist createPlayList(User user, String name) {
		Playlist playlist = new Playlist(name);
		user.addPlayList(playlist);
		return playlist;
	}
	
	public void addSongToPlayList(User user,String playlistId, Song song) {
		user.getAllPlayLists().get(playlistId).addSong(song);
	}

	public Map<String, Playlist> getAllPlayLists(User user) {
		return user.getAllPlayLists();
	}
	
}
