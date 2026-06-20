package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public class SeekCommand implements IWatchPartyCommand {
	
	long seekTime;
	
	

	public SeekCommand(long seekTime) {
		super();
		this.seekTime = seekTime;
	}



	@Override
	public void execute(Room room) {
		room.seek(seekTime);
		
	}

}
