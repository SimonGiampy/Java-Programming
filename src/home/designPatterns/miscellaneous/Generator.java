package home.designPatterns.miscellaneous;

import java.util.Random;

/**
 * this runnable generates random Commands and sends them to the Decider class, which elaborates them only when they arrive
 */
class Generator implements Runnable {
	
	//listener for the event of commands exchanges
	private final ReceiverListener listener;
	
	/**
	 * constructor
	 * @param decider the listener object (an instance of a class that implements ReceiverListener)
	 */
	protected Generator(Decider decider) {
		this.listener = decider;
	}
	
	/**
	 * this runnable chooses randomly the Command action to be applied when it is received. And sends the command object to the decider class via
	 * the listener implemented using the Observer Design Pattern.
	 */
	@Override
	public void run() {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		int maxCount = random.nextInt(10) + 3;
		
		int pick = (int) (Math.random() * 2) + 1;
		Command command;
		if (pick == 1) {
			command = new CancelCommand(generateNumbers(maxCount), generateString(maxCount));
		} else {
			command = new DuplicateCommand(generateNumbers(maxCount), generateString(maxCount));
		}
		
		listener.onCommandReceived(command); //sends the Command to the receiver
	}
	
	/**
	 * generates a sequence of numbers
	 * @param count the number of numbers to be generated
	 * @return an array of doubles
	 */
	private double[] generateNumbers(int count) {
		double[] numbers = new double[count];
		Random random = new Random();
		random.setSeed(System.nanoTime());
		for (int i = 0; i < count; i++) {
			numbers[i] = random.nextDouble() * 1000;
		}
		return numbers;
	}
	
	/**
	 * generates a random string
	 * @param length of the string to be generated
	 * @return the string
	 */
	private String generateString(int length) {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		StringBuilder builder = new StringBuilder();
		int base = 'a';
		for (int i = 0; i < length; i++) {
			builder.append((char) (random.nextInt(26) + base));
		}
		//System.out.println("string generated: " + builder.toString());
		return builder.toString();
	}
	
	
}
