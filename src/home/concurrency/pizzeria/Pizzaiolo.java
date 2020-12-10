package home.concurrency.pizzeria;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Pizzaiolo implements Runnable {
	
	private final String name;
	private final int idPizzaiolo;
	//times for processing an order, will be changed
	private final int maxWaitingTime = 1000;
	private final int minWaitingTime = 100;
	
	private Order currentOrder;
	private final Pizzeria pizzeria;
	
	private final CiroTheOrderManager ciro;
	
	protected ReentrantLock pizzaLock;
	protected Condition shopClosedCondition;
	
	protected Pizzaiolo(String name, int idNumber, CiroTheOrderManager manager, Pizzeria pizzeria) {
		this.name = name;
		this.idPizzaiolo = idNumber;
		this.currentOrder = null;
		this.ciro = manager;
		this.pizzeria = pizzeria;
		pizzaLock = new ReentrantLock();
		shopClosedCondition = pizzaLock.newCondition();
		
		//correct this code to make the waiting queue not pointless
		new Thread(() ->  {
			pizzaLock.lock();
			try {
				if (!pizzeria.isShopClosed()) {
					shopClosedCondition.await();
				}
				System.out.println("pizzaiolo says: shop is now closed");
			} catch (InterruptedException exception) {
				System.out.println("closed condition check interrupted");
				//TODO: check for the interruption of the await condition
			} finally {
				pizzaLock.unlock();
			}
		}).start();
	}
	
	
	/**
	 * If this thread was constructed using a separate {@code Runnable} run object, then that {@code Runnable} object's {@code run} method is called;
	 * otherwise, this method does nothing and returns.
	 */
	@Override
	public void run() {
		//to be replaced with a condition object
		while (!pizzeria.isShopClosed()) {
			try {
				this.currentOrder = ciro.takeOrder();
				long waitingTime = (long) (Math.random() * maxWaitingTime) + minWaitingTime;
				System.out.println("pizzaiolo " + getIdPizzaiolo() + " received order #" + currentOrder.getIdOrder() + ", waiting " + waitingTime);
				//TODO: add dynamic assignment of processing time based on the order made.
				Thread.sleep(waitingTime); //simulated constant processing time
			} catch (InterruptedException ignored) {
			
			}
			
			//TODO: sends the order back to the pizzeria and confirms it
		}
		System.out.println("pizzaiolo #" + this.getIdPizzaiolo() + " finished working");
		pizzeria.mainLock.lock();
		try {
			pizzeria.subThreadsTerminatedCondition.signalAll(); //signals the termination of the program to the pizzeria
		} finally {
			pizzeria.mainLock.unlock();
		}
	}
	
	public int getIdPizzaiolo() {
		return idPizzaiolo;
	}
}
