package home.designPatterns.abstractFactory;

class GasCityCar implements GasCar {
	
	private String color;
	protected GasCityCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return "grey";
	}
	
	@Override
	public String getModelName() {
		return "citroen picasso";
	}
	
	@Override
	public int getTopSpeed() {
		return 140;
	}
	
	@Override
	public int getTankCapacity() {
		return 1000;
	}
}
