package home.designPatterns.miscellaneous;

/**
 * this class refers to the Strategy Pattern class
 */
class Context {

	private Strategy strategy;
	
	/**
	 * constructor
	 * @param strategy sets the initial Strategy object
	 */
	protected Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	protected Context() {
	
	}
	
	/**
	 * enables switching at runtime to a different strategy, allowing dynamic change of the algorithms used for data processing
	 * @param strategy the Strategy object
	 */
	protected void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * executes the strategy action defined
	 * @param x the array of double values
	 * @return the double parameter = result of the computation
	 */
	protected double execute(double[] x) {
		return strategy.applyStrategy(x);
	}

}
