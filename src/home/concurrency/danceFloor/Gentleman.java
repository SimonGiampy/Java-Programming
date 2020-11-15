package home.concurrency.danceFloor;

import java.util.Random;

/**
 * This class is implemented as Thread and represents a single gentleman dancing with a dame. He cycles the stages and
 * dances every time with a newly assigned dame. This class is coupled with DanceFloor class, so it gets the dame that
 * the main class chooses, among the free waiting dames.
 */
public class Gentleman implements Runnable {
	
	private GentlemanStages stage;
	private final int id;
	//TODO: add name picker class so that it reads from a file and chooses a name from a list copied from the internet
	private final String name;
	private final DanceFloor danceFloor;
	private Dame currentPartner;
	
	public Gentleman(int number, String name, DanceFloor danceFloor) {
		this.stage = GentlemanStages.LONELY; //initial starting stage
		this.id = number;
		this.name = name;
		this.danceFloor = danceFloor;
	}
	
	public GentlemanStages getStage() {
		return stage;
	}
	
	public int getGentlemanId() {
		return id;
	}
	
	public String getGentlemanName() {
		return name;
	}
	
	private long getRandomTime() { //random time expressed in milliseconds
		//minimum = 1000, maximum = 7000
		double min = 1, max = 7;
		Random random = new Random();
		long num = (long) (random.nextDouble() * max + min);
		return num * 1000;
	}
	
	/**
	 * Causes this thread to begin execution; the Java Virtual Machine calls the {@code run} method of this thread.
	 */
	public synchronized void start() {
		System.out.println("thread for gentleman " + getGentlemanId() + " started");
	}
	
	/**
	 * If this thread was constructed using a separate {@code Runnable} run object, then that {@code Runnable} object's
	 * {@code run} method is called; otherwise, this method does nothing and returns.
	 * @see #start()
	 */
	@Override
	public void run() {
		while (true) {
			System.out.println(getGentlemanName() + " currently " + this.stage.getDescription());
			//cycles through the stages every 100ms
			if (stage == GentlemanStages.IN_CRISIS) {
				//after a random time, it dumps the dame and gets lonely
				try {
					Thread.sleep(getRandomTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.stage = GentlemanStages.LONELY;
				System.out.printf("%s ", getGentlemanName());
				danceFloor.dumpDame(currentPartner);
				this.currentPartner = null;
			} else if (stage == GentlemanStages.DANCING) {
				//waits for a random time and then goes in crisis
				try {
					Thread.sleep(getRandomTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stage = GentlemanStages.IN_CRISIS;
			} else if (stage == GentlemanStages.LONELY) {
				//after a random time, it requests for a dame that is free and waiting for a gentleman
				//System.out.println(getGentlemanName() + " is lonely and waits");
				try {
					Thread.sleep(getRandomTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.currentPartner = danceFloor.takeWaitingDame();
				System.out.println(getGentlemanName() + " now dancing with dame " + currentPartner.getNumber());
				this.stage = GentlemanStages.DANCING;
			}
			
			//before checking the new stage, waits 100ms, that works as a refresh rate
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//TODO: use a more advanced class to handle periodic refresh of the stages
		}
	}
}
