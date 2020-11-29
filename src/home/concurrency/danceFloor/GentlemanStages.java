package home.concurrency.danceFloor;

/**
 * enumeration containing the descriptions of the possible situations in which a gentleman can be
 */
enum GentlemanStages {
	
	IN_CRISIS("being in crisis"), DANCING("coupled with a dame"),
		LONELY("feeling lonely without a dame");
	//Stages cycle: Dancing -> In crisis -> Lonely
	
	private final String description;
	
	GentlemanStages(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return this.description;
	}
}
