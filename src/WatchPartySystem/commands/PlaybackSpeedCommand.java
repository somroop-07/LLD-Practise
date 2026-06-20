package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public class PlaybackSpeedCommand implements IWatchPartyCommand{

	double playBackSpeed;
	
	
	public PlaybackSpeedCommand(double playBackSpeed) {
		super();
		this.playBackSpeed = playBackSpeed;
	}


	@Override
	public void execute(Room room) {
		room.changeSpeed(playBackSpeed);
		
	}

	
}
