package home.designPatterns.abstractFactory_builder;

class SportsCarFactory implements CarModelsFactory {
	
	@Override
	public ElectricCar constructElectricCar(String color) {
		return new ElectricSportsCar(color);
	}
	
	@Override
	public GasCar constructGasCar(String color) {
		return new GasSportsCar(color);
	}
	
	@Override
	public HybridCar constructHybridCar(String color) {
		return new HybridSportsCar(color);
	}
}
