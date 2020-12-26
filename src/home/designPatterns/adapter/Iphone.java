package home.designPatterns.adapter;

class Iphone implements LightningPhone {
	
	protected Iphone() {
	
	}
	
	@Override
	public void useLightning() {
		System.out.println("lightning connected");
	}
	
	@Override
	public void recharge() {
		System.out.println("iphone recharged");
	}
}
