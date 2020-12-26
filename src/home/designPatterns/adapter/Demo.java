package home.designPatterns.adapter;

class Demo {
	
	static void rechargeMicroUSBPhone(MicroUSBPhone phone) {
		phone.useMicroUSB();
		phone.recharge();
	}
	
	static void rechargeLightningPhone(LightningPhone phone) {
		phone.useLightning();
		phone.recharge();
	}
	
	public static void main(String[] args) {
		Android android = new Android();
		Iphone iPhone = new Iphone();
		
		System.out.println("Recharging android with MicroUsb");
		rechargeMicroUSBPhone(android);
		
		System.out.println("Recharging iPhone with Lightning");
		rechargeLightningPhone(iPhone);
		
		System.out.println("Recharging iPhone with MicroUsb");
		rechargeMicroUSBPhone(new LightningToUSBConverter(iPhone));
		
		System.out.println("recharging Android with Lightning");
		rechargeLightningPhone(new MicroUSBToLightningConverter(android));
	}

}
