package WatchPartySystem.model;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class Room {

	String id;
	User host;
	Set<User> viewers = ConcurrentHashMap.newKeySet();
	Movie movie;
	MovieState movieState;
	
	public Room(String id,User host, Movie movie) {
		super();
		this.id = id;
		this.host = host;
		this.movie = movie;
		this.movieState = new MovieState();
		viewers.add(host);
	}
	public void playMovie() {
		if(movieState.getPlayState().equals(PlayState.PLAYING)) {
			return;
		}
		long curr = movieState.calculateTimeElapsed();
		movieState.setPlayState(PlayState.PLAYING);
		movieState.setLastUpdatedTime(System.currentTimeMillis());
		movieState.setTimeinMillis(curr);
		
	}
	
	public void seek(long desiredTime) {
		movieState.setLastUpdatedTime(System.currentTimeMillis());
		movieState.setTimeinMillis(desiredTime);
	}
	
	public void pauseMovie() {
		if(movieState.getPlayState().equals(PlayState.PAUSED)) {
			return;
		}
		long curr = movieState.calculateTimeElapsed();
		movieState.setPlayState(PlayState.PAUSED);
		movieState.setLastUpdatedTime(System.currentTimeMillis());
		movieState.setTimeinMillis(curr);
	}
	public void changeSpeed(double speed) {
		long curr = movieState.calculateTimeElapsed();
		movieState.setPlaybackSpeed(speed);
		movieState.setLastUpdatedTime(System.currentTimeMillis());
		movieState.setTimeinMillis(curr);
	}
	public void addUser(User user) {
		viewers.add(user);
	}
	public Set<User> getMembers() {
		return viewers;
	}
	public String getId() {
		return id;
	}
	public User getHost() {
		return host;
	}
	public Set<User> getViewers() {
		return viewers;
	}
	public Movie getMovie() {
		return movie;
	}
	public MovieState getMovieState() {
		return movieState;
	}
	
}
