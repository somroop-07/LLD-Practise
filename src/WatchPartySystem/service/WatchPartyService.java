package WatchPartySystem.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import WatchPartySystem.broadcaster.IWatchPartyBroadcaster;
import WatchPartySystem.broadcaster.RoomBroadcaster;
import WatchPartySystem.commands.CommandExecutor;
import WatchPartySystem.commands.IWatchPartyCommand;
import WatchPartySystem.model.Movie;
import WatchPartySystem.model.Room;
import WatchPartySystem.model.User;

public class WatchPartyService {

	Map<String, Room> rooms = new ConcurrentHashMap<>();
	CommandExecutor commandExecutor = new CommandExecutor();
	IWatchPartyBroadcaster broadcaster = new RoomBroadcaster();
	
	
	
	public String createRoom(User host, Movie movie) {
	   String roomId = UUID.randomUUID().toString();
	   Room movieRoom = new Room(roomId, host, movie);
	   rooms.put(roomId, movieRoom);
	   return roomId;
		
	}
	
	public void joinRoom(User user, String roomId) {
		if(!rooms.containsKey(roomId)) {
			return;
		}
		Room room = rooms.get(roomId);
		room.addUser(user);
		user.updateMovieState(room.getMovieState());
	}
	
	public void executeCommand(String roomId, IWatchPartyCommand command) {
		if(!rooms.containsKey(roomId)) {
			return;
		}
		Room room = rooms.get(roomId);
		synchronized (room) {
			commandExecutor.executeCommand(command, room);
		}
		broadcaster.broadcast(room);
		
	}
	
	
}
