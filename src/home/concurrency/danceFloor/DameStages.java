package home.concurrency.danceFloor;

public enum DameStages {
	//currently unused enumeration, but can be implemented if the dames are transformed into their own runnable threads
	
	WAITING("waiting for dance companion"), DANCING("dancing with a gentleman"),
		IN_CRISIS("feeling unaccepted");
	//stages cycle: Dancing -> In crisis -> Talking -> Waiting ->
	
	private final String description;
	
	DameStages(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return this.description;
	}
}
