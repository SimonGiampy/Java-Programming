package home.designPatterns.abstractFactory;

class GasCoupeCar implements GasCar {
	
	private String color;
	protected GasCoupeCar(String color) {
		this.color = color;
	}
	
	@Override
	public int getTankCapacity() {
		return 4000;
	}
	
	@Override
	public String getBaseColor() {
		return "blue";
	}
	
	@Override
	public String getModelName() {
		return "toyota yaris coupe";
	}
	
	@Override
	public int getTopSpeed() {
		return 200;
	}
}
