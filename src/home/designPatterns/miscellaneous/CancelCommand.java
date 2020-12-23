package home.designPatterns.miscellaneous;

class CancelCommand extends Command {
	
	protected CancelCommand(double[] numbers, String text) {
		super(numbers, text);
	}
	
	@Override
	protected void archive() {
		System.out.println("archiving canceled");
	}
}
