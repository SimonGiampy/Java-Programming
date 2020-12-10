package home.designPatterns.abstractFactory;

class ElectricCityCar implements ElectricCar {
	
	private String color;
	protected ElectricCityCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "navy blue";
	}
	
	@Override
	public String getModelName() {
		return "tesla model s";
	}
	
	@Override
	public int getTopSpeed() {
		return 250;
	}
	
	@Override
	public int getPowerCapacity() {
		return 120000;
	}
}
