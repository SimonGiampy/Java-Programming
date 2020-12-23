package home.designPatterns.miscellaneous;

class AverageStrategy implements Strategy {
	
	protected AverageStrategy() {
	
	}
	
	@Override
	public double applyStrategy(double[] doubles) {
		double result = 0;
		for(double k: doubles) {
			result += k;
		}
		return result / doubles.length;
	}
}
