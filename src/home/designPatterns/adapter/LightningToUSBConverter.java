package home.designPatterns.adapter;

class LightningToUSBConverter implements MicroUSBPhone {
	
	LightningPhone adapter;
	
	protected LightningToUSBConverter(LightningPhone phone) {
		adapter = phone;
	}
	
	@Override
	public void useMicroUSB() {
		System.out.print("connected adapter -> ");
		adapter.useLightning();
	}
	
	@Override
	public void recharge() {
		adapter.recharge();
	}
}
