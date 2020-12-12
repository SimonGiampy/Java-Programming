package home.designPatterns.abstractFactory_builder;

interface CarModelsFactory {
	
	ElectricCar constructElectricCar(String color);
	GasCar constructGasCar(String color);
	HybridCar constructHybridCar(String color);
	
}
