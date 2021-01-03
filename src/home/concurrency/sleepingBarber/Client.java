package home.concurrency.sleepingBarber;


class Client implements Runnable {
	
	private Shop shop;
	
	private int id;
	
	protected Client(Shop shop) {
		this.shop = shop;
		this.id = 1;
	}
	
	protected int getId() {
		return this.id;
	}
	
	@Override
	public void run() {
		System.out.println("here i am");
		
		if (shop.areAllChairsFree()) {
			//wake barber
			shop.wakeBarberUp();
			
			//ask for haircut
			System.out.println(askForHaircut());
		}
		//askForHaircut();
	}
	
	private String askForHaircut() {
		return shop.serveCustomer(this);
		
	}
}
