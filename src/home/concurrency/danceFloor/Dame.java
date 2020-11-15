package home.concurrency.danceFloor;

/**
 * basic class containing the id number of the dame dancing
 */
public class Dame {
	
	String name;
	private final int number;
	
	public Dame(int number) {
		this.number = number;
	}
	
	protected int getNumber() {
		return this.number;
	}
}
