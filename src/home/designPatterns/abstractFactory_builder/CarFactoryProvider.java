package home.designPatterns.abstractFactory_builder;

class CarFactoryProvider {
	
	/**
	 * static method that returns the right factory object. The parameter for the decision of the correct factory method is intrinsic in the
	 * application and the client should not have say in it. The purpose is showing that this parameter may depend on the configuration of the
	 * application execution environment (for example the OS) and the client should not change it.
	 * @param budget the parameter used for deciding the correct factory method
	 * @return the correct factory class object
	 */
	protected static CarModelsFactory create(int budget) {
		CarModelsFactory factory;
		if (budget <= 20000) {
			factory = new CityCarFactory();
		} else if (budget <= 50000) {
			factory = new CoupeCarFactory();
		} else {
			factory = new SportsCarFactory();
		}
		return factory;
	}
	
}
