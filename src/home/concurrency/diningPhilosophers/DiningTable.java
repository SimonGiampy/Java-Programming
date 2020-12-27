package home.concurrency.diningPhilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of a multiple access shared resources with semaphores, allowing only one access to a resource at a time. It follows the paradigm
 * of multiple producers, single consumer. Everything is synchronized thanks to the implementation of the Semaphore Java class
 */
class DiningTable {
	
	protected final int chopsticks; //number of chopsticks on the table, copy of the parameter in the main class
	protected Semaphore[] semaphores; //array of semaphores used for mutual exclusion mechanisms
	
	/**
	 * singleton constructor for managing the table
	 * @param chopsticks number of chopsticks present on the table
	 */
	private DiningTable(int chopsticks) {
		this.chopsticks = chopsticks;
		
		semaphores = new Semaphore[chopsticks];
		for (int i = 0; i < chopsticks; i++) {
			semaphores[i] = new Semaphore(1);
		}
		
	}
	
	/**
	 * singleton method for retrieving the only instance of this class
	 * @return the singleton instance of this class
	 */
	protected static DiningTable getInstance() {
		return new DiningTable(Problem.chopsticks);
	}
	
	/**
	 * waits until the chosen chopstick hasn't become available. The mutex is locked as long as the philosopher eats.
	 * @param id the number of the position of the chopstick to take
	 */
	protected void takeChopstick(int id) {
		Semaphore mutex = semaphores[id];
		try {
			mutex.acquire();
		} catch (InterruptedException ex) {
			System.out.println("interrupted here"); //should not be called
		}
	}
	
	/**
	 * releases the lock on the mutex (semaphore object)
	 * @param id the number of the semaphore to be released
	 */
	protected void leaveChopstick(int id) {
		Semaphore mutex = semaphores[id];
		mutex.release();
	}
	
	/**
	 * This is the easy version of the function that acquires the lock for any of the 2 adjacent chopsticks present on the table, relative to the
	 * philosopher who is hungry.
	 * @param leftChop the position of the chopstick on the left of the philosopher
	 * @param rightChop the position of the chopstick on the right of the philosopher
	 * @return the one chopstick chosen among the 2, which is the first that becomes available while waiting for both of them on turns
	 */
	protected int takeOneOfTwoChopsticks(int leftChop, int rightChop) {
		int taken = -1; //-1 means that a chopstick has not been taken yet
		boolean checkL, checkR;
		Semaphore leftMutex = semaphores[leftChop];
		Semaphore rightMutex = semaphores[rightChop];
		long maxTimeout = (long) (0.05 * Problem.timeMultiplier); //max timeout to wait for when checking a chopstick availability through semaphores
		
		do {
			try {
				checkL = leftMutex.tryAcquire(maxTimeout, TimeUnit.MILLISECONDS);
				if (checkL) {
					taken = leftChop;
				} else {
					checkR = rightMutex.tryAcquire(maxTimeout, TimeUnit.MILLISECONDS);
					if (checkR) {
						taken = rightChop;
					}
				}
				
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			
		} while (taken == -1); //iterates as long as a chopstick hasn't been chosen yet
		
		return taken;
	}
	
	/**
	 * checks whether a chopstick is free to take of not. (not currently used)
	 * @param id the position of the chopstick
	 * @return true if it the mutex is unlocked, false otherwise
	 */
	protected boolean isAvailable(int id) {
		Semaphore mutex = semaphores[id];
		return mutex.hasQueuedThreads();
	}
	
}
