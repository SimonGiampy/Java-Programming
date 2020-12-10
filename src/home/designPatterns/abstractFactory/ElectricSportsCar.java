package home.designPatterns.abstractFactory;

//concrete class
class ElectricSportsCar implements ElectricCar {
	
	@Override
	public int getPowerCapacity() {
		return 2000000;
	}
	
	private String color;
	protected ElectricSportsCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "red";
	}
	
	@Override
	public String getModelName() {
		return "Tesla Roadster";
	}
	
	@Override
	public int getTopSpeed() {
		return 300;
	}
}
