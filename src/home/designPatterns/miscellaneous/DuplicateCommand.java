package home.designPatterns.miscellaneous;


class DuplicateCommand extends Command {
	
	protected DuplicateCommand(double[] numbers, String text) {
		super(numbers, text);
	}
	
	@Override
	protected void archive() {
		System.out.println("archived x2");
	}
}
