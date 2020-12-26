package home.designPatterns.adapter;

class MicroUSBToLightningConverter implements LightningPhone {
	
	protected MicroUSBPhone adapter;
	
	protected MicroUSBToLightningConverter(MicroUSBPhone phone) {
		this.adapter = phone;
	}
	
	@Override
	public void useLightning() {
		System.out.print("connected adapter -> ");
		adapter.useMicroUSB();
	}
	
	@Override
	public void recharge() {
		adapter.recharge();
	}
}
