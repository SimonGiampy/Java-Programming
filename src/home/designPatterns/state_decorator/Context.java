package home.designPatterns.state_decorator;

class Context {
	
	protected int currentTrack;
	protected int equalization;
	
	protected boolean shuffleActive;
	protected State currentState;
	
	private Context() {
	
	}
	
	protected Context(int track) {
		this();
		this.currentTrack = track;
		shuffleActive = false;
		currentState = new PausedState(this);
	}
	
	protected void changeState(State state) {
		if (shuffleActive) {
			state = new Shuffling(this, state);
		}
		this.currentState = state;
	}
	
	protected State getCurrentState() {
		return this.currentState;
	}
	
	protected void setCurrentTrack(int track) {
		this.currentTrack = track;
	}
	
	protected void setEqualization(int equalization) {
		this.equalization = equalization;
	}
	
	protected void nextSong() {
		if (currentTrack == MusicPlayer.numberOfTracks) {
			currentTrack = 0;
		} else currentTrack++;
		showPlayingSong();
	}
	
	protected void previousSong() {
		if (currentTrack == 0) {
			currentTrack = MusicPlayer.numberOfTracks;
		} else currentTrack--;
		showPlayingSong();
	}
	
	protected int getPlayingSong() {
		return currentTrack;
	}
	
	protected void showPlayingSong() {
		System.out.println("song = " + this.getPlayingSong());
	}
}
