package home.concurrency.diningPhilosophers;

class Philosopher implements Runnable {
	
	private final String name;
	private final int pos;
	private final DiningTable table;
	private final int numberOfChopsticks;
	
	private final int leftChop;
	private final int myChop;
	private final int rightChop;
	
	
	/**
	 * constructor for a thread Philosopher
	 * @param table the singleton instance for the table management
	 * @param name philosopher's name
	 * @param num the index position in the table
	 */
	protected Philosopher(DiningTable table, String name, int num) {
		this.name = name;
		this.pos = num;
		this.table = table;
		numberOfChopsticks = table.chopsticks;
		
		leftChop = getLeftStickPosition(pos);
		myChop = pos;
		rightChop = getRightStickPosition(pos);
	}
	
	/**
	 * calculates the index of the chopstick on the left
	 * @param pos the position of the philosopher (its creation index)
	 * @return the left chopstick position
	 */
	private int getLeftStickPosition(int pos) {
		if (pos == 0) {
			return numberOfChopsticks - 1;
		} else {
			return (pos - 1) % numberOfChopsticks;
		}
	}
	
	/**
	 * calculates the index of the chopstick on the right
	 * @param pos the position of the philosopher (its creation index)
	 * @return the right chopstick position
	 */
	private int getRightStickPosition(int pos) {
		return (pos + 1) % numberOfChopsticks;
	}
	
	
	
	@Override
	public void run() {
		System.out.printf("running thread #%d\n", pos);
		long wait;
		int rounds = 0;
		
		//iterates the cycle Thinking - Hungry - Eating for the number of rounds specified in the Problem class
		while (rounds < Problem.eatingRounds) {
			
			//Thinking phase: busy waiting
			try {
				wait = (long) (Math.random() * 1 + 0.5) * Problem.timeMultiplier;
				//random thinking time is between 0.5 * multiplier and 1 * multiplier.
				Thread.sleep(wait);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			
			
			//Hungry phase: takes 2 chopsticks from the table
			table.takeChopstick(myChop);
			System.out.printf("#%d takes their chop %d\n", pos, myChop);
			int chopTaken = table.takeOneOfTwoChopsticks(leftChop, rightChop);
			System.out.printf("#%d acquired the chop %d\n", pos, chopTaken);
			
			//Eating phase: waits some time and then deposits the chopsticks on the table
			try {
				wait = (long) (Math.random() * 1 + 0.5) * Problem.timeMultiplier;
				Thread.sleep(wait);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			table.leaveChopstick(myChop);
			table.leaveChopstick(chopTaken);
			System.out.printf("#%d leaves all their chops (%d , %d)\n", pos, myChop, chopTaken);
			
			rounds++;
		}
		System.out.printf("Philosopher #%d says goodnight\n", pos); // signals finished execution
	}
}
