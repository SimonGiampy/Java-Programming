package home.designPatterns.abstractFactory_builder;

class ElectricCarBuilder {
	
	private CarSeller seller;
	
	protected ElectricCarBuilder (CarSeller seller) {
		this.seller = seller;
	}
	
	protected ElectricCar build() {
		return seller.getProvider().constructElectricCar(seller.getColor());
	}
}
