package home.designPatterns.abstractFactory;

class CoupeCarFactory implements CarModelsFactory {
	
	@Override
	public ElectricCar constructElectricCar(String color) {
		return new ElectricCoupeCar(color);
	}
	
	@Override
	public GasCar constructGasCar(String color) {
		return new GasCoupeCar(color);
	}
	
	@Override
	public HybridCar constructHybridCar(String color) {
		return new HybridCoupeCar(color);
	}
}
