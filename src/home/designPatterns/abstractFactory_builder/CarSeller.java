package home.designPatterns.abstractFactory_builder;

/**
 * Builder Design Pattern applied for returning the Car object
 */
class CarSeller {
	
	private final CarModelsFactory provider;
	private String color;
	private int engineType;
	
	protected CarSeller(int budget) {
		this.provider = CarFactoryProvider.create(budget);
	}
	
	protected CarSeller setCarColor(String color) {
		this.color = color;
		return this;
	}
	
	protected CarSeller setCarEngineType(int engine) {
		this.engineType = engine;
		return this;
	}
	
	public CarModelsFactory getProvider() {
		return provider;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getEngineType() {
		return engineType;
	}
	//}
}
