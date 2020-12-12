package home.designPatterns.abstractFactory_builder;

class HybridCarBuilder {
	
	private CarSeller seller;
	
	protected HybridCarBuilder (CarSeller seller) {
		this.seller = seller;
	}
	
	protected HybridCar build() {
		return seller.getProvider().constructHybridCar(seller.getColor());
	}
	
}
