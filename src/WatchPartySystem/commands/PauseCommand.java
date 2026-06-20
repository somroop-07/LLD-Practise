package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public class PauseCommand implements IWatchPartyCommand{

	@Override
	public void execute(Room room) {
		room.pauseMovie();
	}

}
