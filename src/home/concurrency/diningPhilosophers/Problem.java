package home.concurrency.diningPhilosophers;

class Problem {
	
	protected static final int numberOfPhilosophers = 5; // how many philosophers are dining
	protected static final int chopsticks = 5; //how many chopsticks are there on the table
	protected static final int eatingRounds = 10; // how many rounds of the cycle each philosopher has to go through
	protected static final long timeMultiplier = 100; //indicates how fast the simulation goes on
	
	public static void main(String[] args) {
		DiningTable table = DiningTable.getInstance();
		
		Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
		
		for (int i = 0; i < numberOfPhilosophers; i++) {
			philosophers[i] = new Philosopher(table, "Name", i); //creation of Runnables
		}
		
		Thread[] attendantsThreads = new Thread[numberOfPhilosophers];
		for (int i = 0; i < numberOfPhilosophers; i++) {
			attendantsThreads[i] = new Thread(philosophers[i]);
			attendantsThreads[i].start();
		}
		
	}
	
	
}
