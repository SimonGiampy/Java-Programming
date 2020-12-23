package home.designPatterns.miscellaneous;

class SquareRootStrategy implements Strategy {
	
	protected SquareRootStrategy() {
	
	}
	
	@Override
	public double applyStrategy(double[] numbers) {
		double result = 0;
		for (double k: numbers) {
			result += Math.pow(k, 2);
		}
		return Math.sqrt(result);
	}
}
