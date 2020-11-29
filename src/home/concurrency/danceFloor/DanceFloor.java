package home.concurrency.danceFloor;

import java.util.ArrayList;

/**
 * handles the requests of the Gentleman dancing and moves around the Dames
 */
class DanceFloor {
	
	ArrayList<Dame> waitingDames;
	ArrayList<Dame> dancingDames;
	ArrayList<Dame> inCrisisDames;
	//Stages cycle: Dancing -> In crisis -> Waiting
	//TODO: alternate version of this mechanism is to implement all dames as separates threads, like the gentlemen.
	//  This way all the gentlemen and dames are handled like people with their own cycled behavior
	
	Gentleman[] knights;
	
	int numberOfDames;
	int numberOfGentlemen;
	
	
	public DanceFloor(int numberDames, int numberGentlemen) {
		waitingDames = new ArrayList<>();
		dancingDames = new ArrayList<>();
		inCrisisDames = new ArrayList<>();
		this.numberOfDames = numberDames;
		this.numberOfGentlemen = numberGentlemen;
		
		knights = new Gentleman[numberOfGentlemen];
		
		//creates a set of dames willing to dance, each one with its own number
		for (int i = 0; i < numberDames; i++) {
			waitingDames.add(new Dame(i + 1));
		}
		
		//creates set of gentleman, identified by the name Knight and their number
		for (int i = 0; i < numberGentlemen; i++) {
			knights[i] = new Gentleman(1, "Knight" + i, this);
		}
	}
	
	/**
	 * starts the execution for every thread (the gentlemen)
	 */
	public void startDance() {
		Thread[] threads = new Thread[numberOfGentlemen];
		
		for (int i = 0; i < numberOfGentlemen; i++) {
			threads[i] = new Thread(knights[i]);
			threads[i].start();
		}
	}
	
	/**
	 * takes a random dame from the list of the waiting ones and handles it to the gentleman who asked for it
	 * @return the chosen dame to the gentleman who asked for one
	 */
	protected synchronized Dame takeWaitingDame() {
		if (waitingDames.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int choice = (int) (Math.random() * waitingDames.size());
		Dame taken = waitingDames.remove(choice);
		dancingDames.add(taken);
		System.out.println("handing dame" + taken.getNumber());
		return taken;
	}
	
	/**
	 * the gentleman dumps the dame when he reaches the crisis stage
	 * @param dame the dame that the gentleman was dancing with. The gentleman is fed up of dancing with that dame and
	 *             later asks for a new one
	 */
	protected synchronized void dumpDame(Dame dame) {
		System.out.println("dumping dame" + dame.getNumber());
		inCrisisDames.add(dame);
		dancingDames.remove(dame);
		
		//a dame exits the crisis when finds another dame in crisis, so two dames become available at the same time
		if (inCrisisDames.size() % 2 != 0 && inCrisisDames.contains(dame)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (inCrisisDames.contains(dame)) {
			inCrisisDames.remove(dame);
			waitingDames.add(dame);
			
			//two dames go to the waiting stage, since they always move in couples
			int choice = (int) (Math.random() * inCrisisDames.size());
			Dame available = inCrisisDames.remove(choice);
			waitingDames.add(available);
			notifyAll();
		}
	}

}
