package home.concurrency.pizzeria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * this class' purpose is to handle the transfer of the orders from the pizzeria to the pizzaioli. Its job is to assign the orders to the right
 * pizzaioli according to who is free or not. The orders are inserted in a queue that follows the FIFO principlce.
 */
class CiroTheOrderManager {
	
	//this field is set to true by the pizzeria when it is about to close
	
	private ReentrantLock lock; //lock shared between the methods in this class, without the need of the synchronized methods
	private Condition isEmptyCondition; //condition asserted when the queue is empty
	//this is the queue that contains all the orders made
	private Queue<Order> orderQueue; // FIFO principle
	private Pizzeria pizzeria;
	
	protected CiroTheOrderManager(Pizzeria pizzeria) {
		this.lock = new ReentrantLock();
		this.isEmptyCondition = lock.newCondition();
		this.orderQueue = new LinkedList<>(); //most optimized data structure for handling queues
		this.pizzeria = pizzeria;
		
	}
	
	protected void assignOrder(Order order) {
		lock.lock();
		try {
			orderQueue.add(order);
			isEmptyCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	protected Order takeOrder() {
		lock.lock();
		Order order = null;
		try {
			while (orderQueue.isEmpty() ) {
				isEmptyCondition.await(); //signal to pizzaioli threads
				
				//this must be changed because it does not work
				/*
				pizzeria.mainLock.lock();
				pizzeria.emptyOrdersQueueCondition.signalAll(); //signal to pizzeria thread for terminating everything
				pizzeria.mainLock.unlock();
				 */
			}
			order = orderQueue.remove();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} finally {
			lock.unlock();
		}
		assert order != null;
		return order;
	}
	
	/*
	//OLD VERSION CODE (with wait and notify methods)
	
	protected CiroTheOrderManager() {
		orders = new LinkedList<>();
		this.shopClosed = false;
	}
	
	//the Pizzeria adds a new order to the queue of orders. Note: the order manager doesn't know when the shop will close, since the class that
	// makes the decision of closing the shop is the Pizzeria.
	protected synchronized void assignOrder(Order newOrder) {
		this.orders.add(newOrder);
		
		System.out.println("added new order from " + orders.element().getClient().getIdClient());
		notifyAll();
	}
	
	//the Pizzaiolo takes the order when the queue is not empty and the shop hasn't yet closed. If the queue is empty, it waits until a new client
	// makes an order, which goes in the queue. The Pizzaiolo gets notified when it can take a new order
	protected synchronized Order takeOrder() throws InterruptedException {
		while (this.orders.isEmpty() && !this.shopClosed) {
			wait();
		}
		
		//notifyAll();
		return this.orders.remove();
	}
	 */
	
	protected boolean isQueueEmpty() {
		return orderQueue.isEmpty();
	}

}
