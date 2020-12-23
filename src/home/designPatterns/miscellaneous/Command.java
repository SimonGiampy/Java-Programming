package home.designPatterns.miscellaneous;

abstract class Command {
	
	private final String text;
	private final double[] numbers;
	
	protected Command(double[] numbers, String text) {
		this.numbers = numbers;
		this.text = text;
	}
	
	abstract protected void archive();
	
	//@Override
	//abstract protected Command clone() throws CloneNotSupportedException;
	
	protected String getText() {
		return text;
	}
	
	protected double[] getNumbers() {
		return numbers;
	}
}
