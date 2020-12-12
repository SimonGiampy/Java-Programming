package home.designPatterns.abstractFactory_builder;

class GasSportsCar implements GasCar {
	
	private String color;
	protected GasSportsCar(String color) {
		this.color = color;
	}
	
	@Override
	public String getBaseColor() {
		return null;
	}
	
	@Override
	public String getModelName() {
		return null;
	}
	
	@Override
	public int getTopSpeed() {
		return 0;
	}
	
	@Override
	public int getTankCapacity() {
		return 0;
	}
}
