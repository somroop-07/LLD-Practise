package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public interface IWatchPartyCommand {

	public void execute(Room room);
}
