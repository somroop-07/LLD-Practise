package WatchPartySystem;

import WatchPartySystem.commands.PlayCommand;
import WatchPartySystem.commands.PlaybackSpeedCommand;
import WatchPartySystem.model.Movie;
import WatchPartySystem.model.User;
import WatchPartySystem.service.WatchPartyService;

//Design a Watch Party system that enables a host to create a virtual room 
//where multiple users can join using a unique Room ID and watch a movie together in a synchronized manner. 
//The system should support real-time playback controls such as Play, Pause, Seek, and Change Playback Speed, 
//ensuring that all participants experience the same playback state.
public class Driver {
     
	public static void main(String[] args) {
		WatchPartyService watchPartyService = new WatchPartyService();
		
		User user1 = new User("u1", "Somroop");
		User user2 = new User("u2", "fvrv");
		User user3 = new User("u3", "bgbt");
		User user4 = new User("u4", "tgbt");
		
		Movie movie = new Movie("fvfrv", 3 * 60 * 60 * 1000);
		String roomId = watchPartyService.createRoom(user1, movie);
		
		watchPartyService.joinRoom(user2, roomId);
		watchPartyService.joinRoom(user3, roomId);
		watchPartyService.joinRoom(user4, roomId);
		
		watchPartyService.executeCommand(roomId, new PlayCommand());
		watchPartyService.executeCommand(roomId, new PlaybackSpeedCommand(1.5));
		
		
	}
}
