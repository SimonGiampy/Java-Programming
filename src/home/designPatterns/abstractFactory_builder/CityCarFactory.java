package home.designPatterns.abstractFactory_builder;

class CityCarFactory implements CarModelsFactory {
	
	@Override
	public ElectricCar constructElectricCar(String color) {
		return new ElectricCityCar(color);
	}
	
	@Override
	public GasCar constructGasCar(String color) {
		return new GasCityCar(color);
	}
	
	@Override
	public HybridCar constructHybridCar(String color) {
		return new HybridCityCar(color);
	}
}
