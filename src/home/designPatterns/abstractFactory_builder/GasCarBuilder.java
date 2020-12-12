package home.designPatterns.abstractFactory_builder;

class GasCarBuilder {
	
	private CarSeller seller;
	
	protected GasCarBuilder (CarSeller seller) {
		this.seller = seller;
	}
	
	protected GasCar build() {
		return seller.getProvider().constructGasCar(seller.getColor());
	}
	
}
