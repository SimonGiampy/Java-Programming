package home.designPatterns.miscellaneous;

/**
 * this abstract class is the super class for the Command Design Pattern. It encapsulates the data in an object of this class, thus making it inter
 * changeable with other classes. This is useful for the cases of later processing of the data received, like in this case.
 */
abstract class Command {
	
	private String text;
	private double[] numbers;
	
	/**
	 * default constructor with normal creational parameters
	 * @param numbers the array of double values
	 * @param text the random generated string
	 */
	protected Command(double[] numbers, String text) {
		this.numbers = numbers;
		this.text = text;
	}
	
	/**
	 * alternative constructor used for cloning the object
	 * @param command the original copy to be cloned
	 */
	protected Command(Command command) {
		this(); //instantiates a new object of the same class
		this.numbers = command.getNumbers();
		this.text = command.getText();
	}
	
	public Command() {
	
	}
	
	/**
	 * simple method characteristic of a Command subclass. Each time this method is called, the correct method in the correct class is invoked.
	 */
	abstract protected void archive();
	
	/**
	 * abstract method that provides a new object exactly equal to the one being cloned. Application of the Prototype Design Pattern here
	 * @return an exact copy of the instance object
	 */
	abstract protected Command clone();
	
	protected String getText() {
		return text;
	}
	
	protected double[] getNumbers() {
		return numbers;
	}
}
