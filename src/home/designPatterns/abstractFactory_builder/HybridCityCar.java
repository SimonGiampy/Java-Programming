package home.designPatterns.abstractFactory_builder;

class HybridCityCar implements HybridCar {
	
	private String color;
	protected HybridCityCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "green";
	}
	
	@Override
	public String getModelName() {
		return "mercedes benz";
	}
	
	@Override
	public int getTopSpeed() {
		return 210;
	}
	
	@Override
	public double getElectricAutonomy() {
		return 160;
	}
}
