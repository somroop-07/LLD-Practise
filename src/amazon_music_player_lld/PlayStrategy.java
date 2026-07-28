package amazon_music_player_lld;

import amazon_music_player_lld.entitites.Playlist;
import amazon_music_player_lld.entitites.Song;

public interface PlayStrategy {
     
	public Song playNext(Playlist playlist, int idx);
	public Song playPrev(Playlist playlist, int idx);
}
