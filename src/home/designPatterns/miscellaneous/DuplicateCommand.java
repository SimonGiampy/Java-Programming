package home.designPatterns.miscellaneous;


class DuplicateCommand extends Command {
	
	protected DuplicateCommand(double[] numbers, String text) {
		super(numbers, text);
	}
	
	protected DuplicateCommand(DuplicateCommand command) {
		super(command);
	}
	
	@Override
	protected void archive() {
		System.out.println("archived x2");
	}
	
	/**
	 * creates a new instance object of the same class, passing this as parameter of the duplication of data
	 * @return a copy of the object
	 */
	@Override
	protected Command clone() {
		return new DuplicateCommand(this);
	}
}
