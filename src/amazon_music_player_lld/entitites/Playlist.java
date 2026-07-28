package amazon_music_player_lld.entitites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Playlist {

	String id;
	String name;
	List<Song> songList;

	public Playlist(String name) {
		super();
		this.name = name;
		id = UUID.randomUUID().toString();
		songList = new ArrayList<>();
	}
	
	public void addSong(Song song) {
		 songList.add(song);
	}
	
	public void removeSong(String songId) {
		songList.remove(songId);
	}

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	
	
	
}
