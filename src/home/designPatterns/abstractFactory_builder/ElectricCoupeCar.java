package home.designPatterns.abstractFactory_builder;

class ElectricCoupeCar implements ElectricCar {
	@Override
	public int getPowerCapacity() {
		return 150000;
	}
	
	private String color;
	protected ElectricCoupeCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "black";
	}
	
	@Override
	public String getModelName() {
		return "toyota chr coupe";
	}
	
	@Override
	public int getTopSpeed() {
		return 190;
	}
}
