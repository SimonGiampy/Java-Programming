package home.concurrency.diningPhilosophers;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

class DeadlockChecker implements Callable<Boolean> {
	
	Semaphore[] mutexes;
	
	protected DeadlockChecker(DiningTable table) {
		mutexes = table.semaphores;
	}
	
	@Override
	public Boolean call() {
		boolean deadlock = true;
		int queue = 0;
		
		// this is actually not the best way for detecting a deadlock occurrence
		for (Semaphore s : mutexes) {
			queue += s.getQueueLength();
			if (s.availablePermits() != 0) {
				deadlock = false;
			}
		}
		if (deadlock) {
			System.out.printf("a deadlock occurred and queue = %d\n", queue);
			return Boolean.TRUE;
		} else {
			System.out.printf("queue = %d\n", queue);
			return Boolean.FALSE;
		}
		
	}
}
