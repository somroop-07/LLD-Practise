package amazon_music_player_lld.entitites;

public class AudioEngine {

	
	public void playSong(Song song) {
		System.out.println("Playing song" + song.getName());
	}
	
	public void pause() {
		System.out.println("Paused");
	}
	
    public void resume() {
    	System.out.print("Resumed");
    }
    
    public void reset() {
    	System.out.println("Stopped");
    }
}
