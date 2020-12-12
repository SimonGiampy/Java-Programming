package home.designPatterns.abstractFactory_builder;

class HybridCoupeCar implements HybridCar {
	
	private String color;
	protected HybridCoupeCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "purple";
	}
	
	@Override
	public String getModelName() {
		return "porsche panamera";
	}
	
	@Override
	public int getTopSpeed() {
		return 230;
	}
	
	@Override
	public double getElectricAutonomy() {
		return 100;
	}
}
