package home.concurrency.sleepingBarber;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Shop {
	
	protected Semaphore[] mutexes;
	private Barber barber;
	
	Condition sleepingBarber;
	Semaphore barberReady;
	Condition clientServed;
	ReentrantLock lock;
	
	protected Shop() {
		mutexes = new Semaphore[BarberShop.numChairs];
		for (int i = 0; i < BarberShop.numChairs; i++) {
			mutexes[i] = new Semaphore(1);
		}
		
		lock = new ReentrantLock();
		sleepingBarber = lock.newCondition();
		barberReady = new Semaphore(0);
		clientServed = lock.newCondition();
	}
	
	protected Shop setBarber(Barber barber) {
		this.barber = barber;
		return this;
	}
	
	protected void wakeBarberUp() {
		lock.lock();
		sleepingBarber.signal();
		lock.unlock();
		System.out.println("barber has woken up");
	}
	
	protected void readyToCut() {
		barberReady.release();
		lock.lock();
		clientServed.signal();
		lock.unlock();
	}
	
	protected String serveCustomer(Client client) {
		lock.lock();
		try {
			clientServed.await();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		return barber.cutHair(client);
	}
	
	protected void waitForAClient() {
		lock.lock();
		try {
			sleepingBarber.await();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	protected boolean isChairFree(int num) {
		return mutexes[num].availablePermits() > 0;
	}
	
	protected boolean areAllChairsFree() {
		for (Semaphore sem: mutexes) {
			if (sem.availablePermits() == 0) {
				return false;
			}
		}
		return true;
	}
	
	
}
