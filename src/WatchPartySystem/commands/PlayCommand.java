package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public class PlayCommand implements IWatchPartyCommand{

	@Override
	public void execute(Room room) {
		room.playMovie();
		
	}

}
