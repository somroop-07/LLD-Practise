package WatchPartySystem.model;

public class MovieState {

	PlayState playState;
	long timeinMillis;
	long lastUpdatedTime;
	double playbackSpeed;
	
	public MovieState() {
		super();
		this.playState = PlayState.PAUSED;
		this.timeinMillis = 0;
		this.lastUpdatedTime = System.currentTimeMillis();
		this.playbackSpeed = 1.0;
	}

	public PlayState getPlayState() {
		return playState;
	}

	public void setPlayState(PlayState playState) {
		this.playState = playState;
		
	}

	public long getTimeinMillis() {
		return timeinMillis;
	}

	public void setTimeinMillis(long timeinMillis) {
		this.timeinMillis = timeinMillis;
	}


	public double getPlaybackSpeed() {
		return playbackSpeed;
	}

	public void setPlaybackSpeed(double playbackSpeed) {
		this.playbackSpeed = playbackSpeed;
	}

	public long getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(long lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	public long calculateTimeElapsed() {
		if(playState.equals(PlayState.PAUSED)) {
			return timeinMillis;
		}
		long elapsed = timeinMillis + (long)((System.currentTimeMillis() - lastUpdatedTime) * playbackSpeed);
		return elapsed;
	}
	
	
}
