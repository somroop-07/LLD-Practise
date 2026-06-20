package WatchPartySystem.broadcaster;


import java.util.Set;

import WatchPartySystem.model.Room;
import WatchPartySystem.model.User;

public class RoomBroadcaster implements IWatchPartyBroadcaster{

	@Override
	public void broadcast(Room room) {
		Set<User> viewList = room.getMembers();
		for(User user : viewList) {
			user.updateMovieState(room.getMovieState());
		}
		
	}

}
