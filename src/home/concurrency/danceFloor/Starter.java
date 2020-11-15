package home.concurrency.danceFloor;

/**
 * class with main method that initialize the dance floor and sets the number of participants of the ballet
 */
public class Starter {
	
	public static void main(String[] args) {
		System.out.println("initialing dance session");
		//create instances of gentlemen and dames, with ease of choosing the number of elements to simulate
		int numberDames = 8;
		int numberGentlemen = 8;
		DanceFloor danceFloor = new DanceFloor(numberDames, numberGentlemen);
		danceFloor.startDance();
	}
}
