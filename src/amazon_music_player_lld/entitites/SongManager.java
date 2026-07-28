package amazon_music_player_lld.entitites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongManager {

	Map<String, Song> songList = new HashMap<>();
	Map<String, List<Song>> songByAlbum = new HashMap<>();
	Map<String, List<Song>> songByArtist = new HashMap<>();
	Map<String, List<Song>> songByName = new HashMap<>();
	
	public void addSong(Song song) {
		songList.put(song.getId(), song);
		songByAlbum.putIfAbsent(song.getAlbumName(), new ArrayList<>());
		songByArtist.putIfAbsent(song.getArtistName(), new ArrayList<>());
		songByName.putIfAbsent(song.getName(), new ArrayList<>());
		songByAlbum.get(song.getAlbumName()).add(song);
		songByArtist.get(song.getArtistName()).add(song);
		songByName.get(song.getName()).add(song);
	}

	public Map<String, Song> getSongList() {
		return songList;
	}

	public Map<String, List<Song>> getSongByAlbum() {
		return songByAlbum;
	}

	public Map<String, List<Song>> getSongByArtist() {
		return songByArtist;
	}

	public Map<String, List<Song>> getSongByName() {
		return songByName;
	}
	
	
}
