package home.designPatterns.abstractFactory;

interface CarModelsFactory {
	
	ElectricCar constructElectricCar(String color);
	GasCar constructGasCar(String color);
	HybridCar constructHybridCar(String color);
	
}
