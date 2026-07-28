package amazon_music_player_lld;

import amazon_music_player_lld.entitites.AudioEngine;
import amazon_music_player_lld.entitites.PlayListService;
import amazon_music_player_lld.entitites.Playlist;
import amazon_music_player_lld.entitites.Song;
import amazon_music_player_lld.entitites.User;
import amazon_music_player_lld.services.MusicPlayerService;

public class Driver {

	public static void main(String[] args) {
		
		Song song = new Song("November Rain", "Guns n Roses", "OG");
		User user1 = new User("Somroop");
		PlayListService playListService = new PlayListService();
		Playlist playlist = playListService.createPlayList(user1, "GNR");
		playListService.addSongToPlayList(user1, playlist.getId(), song);
		MusicPlayerService musicPlayerService = new  MusicPlayerService(new AudioEngine(), playListService);
		musicPlayerService.playSong(song);
		musicPlayerService.playPlayList(user1, playlist.getId());
	}
}
