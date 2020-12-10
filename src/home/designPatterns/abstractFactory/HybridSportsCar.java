package home.designPatterns.abstractFactory;

class HybridSportsCar implements HybridCar {
	
	private String color;
	protected HybridSportsCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "blue";
	}
	
	@Override
	public String getModelName() {
		return "porsche p9";
	}
	
	@Override
	public int getTopSpeed() {
		return 250;
	}
	
	@Override
	public double getElectricAutonomy() {
		return 200;
	}
}
