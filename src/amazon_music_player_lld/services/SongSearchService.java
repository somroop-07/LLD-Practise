package amazon_music_player_lld.services;

import java.util.List;

import amazon_music_player_lld.entitites.Song;
import amazon_music_player_lld.entitites.SongManager;

public class SongSearchService {

	SongManager songManager;
	
	
	
	public SongSearchService(SongManager songManager) {
		super();
		this.songManager = songManager;
	}



	public List<Song> getSongsByName(String name) {
		return songManager.getSongByName().getOrDefault(name, null);
	}
	
	public List<Song> getSongsByAlbum(String albumName) {
		return songManager.getSongByAlbum().getOrDefault(albumName, null);
	}
	public List<Song> getSongsByArtist(String artistName) {
		return songManager.getSongByArtist().getOrDefault(artistName, null);
	}
}
