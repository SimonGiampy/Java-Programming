package home.designPatterns.miscellaneous;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * receives the commands and executes them after choosing the right strategy. Every command has its own strategy of execution associated
 */
class Decider implements ReceiverListener {
	
	private final Context context;
	private final CommandHistory history;

	protected Decider() {
		this.context = new Context();
		history = new CommandHistory();
	}
	
	/**
	 * Observer design pattern in action
	 * @param command the object sent and to be received
	 */
	@Override
	public void onCommandReceived(Command command) {
		System.out.printf("string received: %s\n", command.getText());
		System.out.printf("numbers received: %s\n", elaborateNumbers(command.getNumbers()));
		
		//in case I want to define a custom Strategy using a lambda expression:
		context.setStrategy( (doubles) -> doubles.length * 3f); //multiplies by 3 the length of the input array and returns the result
		
		int pick = (int) (Math.random() * 2) + 1;
		switch (pick) {
			case 1 -> context.setStrategy(new SquareRootStrategy());
			case 2 -> context.setStrategy(new AverageStrategy());
		}
		
		command.archive();
		
		history.push(command.clone()); //copies the object and stores it in the history so the original Command object gets a backup
		System.out.printf("elaborated number with strategy %d: %f\n", pick, context.execute(command.getNumbers()));
	}
	
	/**
	 * uses functional programming and the Stream paradigm to transform a series of double values in an array into a string where each double value
	 * is separated by a space character.
	 * @param x the array of double values
	 * @return the output string transformed
	 */
	private String elaborateNumbers(double[] x) {
		Stream<String> stringStream = Arrays.stream(x).mapToObj(String::valueOf);
		return stringStream.reduce("", (s, s1) -> s + s1 + " ");
	}
}
