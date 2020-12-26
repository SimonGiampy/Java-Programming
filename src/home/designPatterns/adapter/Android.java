package home.designPatterns.adapter;

class Android implements MicroUSBPhone {
	
	protected Android() {
	
	}
	
	@Override
	public void useMicroUSB() {
		System.out.println("micro usb connected");
	}
	
	@Override
	public void recharge() {
		System.out.println("android recharged");
	}
}
