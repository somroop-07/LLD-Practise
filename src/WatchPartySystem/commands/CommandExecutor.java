package WatchPartySystem.commands;

import WatchPartySystem.model.Room;

public class CommandExecutor {

	 public void executeCommand(IWatchPartyCommand command, Room room) {
		 command.execute(room);
	 }
}
