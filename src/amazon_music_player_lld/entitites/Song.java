package amazon_music_player_lld.entitites;

import java.util.UUID;

public class Song {

	String id;
	String name;
	String artistName;
	String albumName;
	
	public Song(String name, String artistName, String albumName) {
		super();
		id = UUID.randomUUID().toString();
		this.name = name;
		this.artistName = artistName;
		this.albumName = albumName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getArtistName() {
		return artistName;
	}	
	
}
