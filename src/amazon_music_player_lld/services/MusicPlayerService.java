package amazon_music_player_lld.services;

import amazon_music_player_lld.entitites.AudioEngine;
import amazon_music_player_lld.entitites.PlayListService;
import amazon_music_player_lld.entitites.Playlist;
import amazon_music_player_lld.entitites.Song;
import amazon_music_player_lld.entitites.User;

public class MusicPlayerService {

	AudioEngine audioEngine;
	Song currentSong;
	Playlist currentPlaylist;
	PlayListService playListManager;
	int playListIdx;
	
	
	
	public MusicPlayerService(AudioEngine audioEngine,PlayListService playListManager) {
		super();
		this.audioEngine = audioEngine;
		this.playListManager = playListManager;
	}
	
	public void playSong(Song song) {
		currentSong = song;
		audioEngine.playSong(song);
	}
	
	public void playPlayList(User user,String playListId) {
		 currentPlaylist = playListManager.getAllPlayLists(user).getOrDefault(playListId, null);
		 if(currentPlaylist != null) {
			 currentSong = currentPlaylist.getSongList().get(0);
			 playListIdx = 0;
		 }
		 audioEngine.playSong(currentSong);
	}
	public void playNext() {
		playListIdx++;
		currentSong = currentPlaylist.getSongList().get(playListIdx % currentPlaylist.getSongList().size());
		audioEngine.playSong(currentSong);
	}
	public void playPrev() {
		if(playListIdx > 0) {
			playListIdx--;
			currentSong = currentPlaylist.getSongList().get(playListIdx);
			audioEngine.playSong(currentSong);
		}
	}
	public void pause() {
		audioEngine.pause();
	}
	public void reset() {
		currentSong = null;
		audioEngine.reset();
	}
	
	


	
	
	
}
