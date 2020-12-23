package home.designPatterns.miscellaneous;

class CancelCommand extends Command {
	
	protected CancelCommand(double[] numbers, String text) {
		super(numbers, text);
	}
	
	protected CancelCommand(CancelCommand command) {
		super(command);
	}
	
	@Override
	protected void archive() {
		System.out.println("archiving canceled");
	}
	
	/**
	 * creates a new instance object of the same class, passing this as parameter of the duplication of data
	 * @return a copy of the object
	 */
	@Override
	protected Command clone() {
		return new CancelCommand(this);
	}
}
