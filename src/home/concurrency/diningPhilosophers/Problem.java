package home.concurrency.diningPhilosophers;

import java.util.concurrent.*;

/**
 * class for setting the parameters for the simulation of the problem
 */
class Problem {
	
	protected static final int numberOfPhilosophers = 5; // how many philosophers are dining
	protected static final int chopsticks = 5; //how many chopsticks are there on the table
	protected static final int eatingRounds = 10; // how many rounds of the cycle each philosopher has to go through
	protected static final long timeMultiplier = 100; //indicates how fast the simulation goes on
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		DiningTable table = DiningTable.getInstance(); //singleton instance
		
		//TODO: add deadlock check condition
		//TODO: add readme description file
		//TODO: add continuous testing and see how many rounds can reach the simulation without any deadlock occurring
		
		Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
		
		for (int i = 0; i < numberOfPhilosophers; i++) {
			philosophers[i] = new Philosopher(table, "Name", i); //creation of Runnables
		}
		
		//setting up all the threads and running them
		Thread[] attendantsThreads = new Thread[numberOfPhilosophers];
		for (int i = 0; i < numberOfPhilosophers; i++) {
			attendantsThreads[i] = new Thread(philosophers[i]);
			attendantsThreads[i].start();
		}
		
		// this part will check for a deadlock occurrence and will halt the execution in case a deadlock is found. Doesn't actually work
		/*
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<Boolean> future;
		do {
			future = scheduledExecutorService.schedule(new DeadlockChecker(table), 500, TimeUnit.MILLISECONDS);
		} while (future.get() == Boolean.FALSE);
		*/
		//System.out.println(" -> halting the execution");
		
	}
	
	
}
