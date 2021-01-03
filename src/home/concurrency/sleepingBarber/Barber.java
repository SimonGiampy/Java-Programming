package home.concurrency.sleepingBarber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Barber implements Runnable {
	
	private static Barber me;
	private Shop shop;
	
	private Condition sleeping;
	private ReentrantLock lock;
	
	private Barber(Shop shop) {
		lock = new ReentrantLock();
		sleeping = lock.newCondition();
		
		this.shop = shop;
	}
	
	protected static Barber getInstance(Shop shop) {
		if (me == null) {
			return new Barber(shop);
		} else {
			return me;
		}
	}
	
	@Override
	public void run() {
		
		while (true) {
			if (shop.areAllChairsFree()) {
				//wait
				shop.waitForAClient();
				System.out.println("barber is awake now");
				
				shop.readyToCut();
			}
			//continues
			
		
		}
	
	}
	
	protected String cutHair(Client client) {
		return "capelli tagliati" + client.getId();
	}
}
