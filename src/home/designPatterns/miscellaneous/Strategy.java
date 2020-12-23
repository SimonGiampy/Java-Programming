package home.designPatterns.miscellaneous;

/**
 * application of the Strategy Design Pattern, that let the Decider class decide which one to use, according to any criteria
 */
interface Strategy {
	
	double applyStrategy(double[] doubles);
	
}
