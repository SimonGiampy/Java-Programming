package home.designPatterns.abstractFactory;

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
	
	private CarModelsFactory getProvider() {
		return this.provider;
	}
	
	protected CarSeller setCarColor(String color) {
		this.color = color;
		return this;
	}
	
	protected CarSeller setCarEngineType(int engine) {
		this.engineType = engine;
		return this;
	}
	
	//TODO: divide the builder object and assign one car for each of the car engine types so the return value is correct
	protected  buildCar() {
		return switch (engineType) {
			case 1 -> getProvider().constructElectricCar(this.color);
			case 2 -> getProvider().constructGasCar(this.color);
			case 3 -> getProvider().constructHybridCar(this.color);
			default -> null;
		};
	}
}
