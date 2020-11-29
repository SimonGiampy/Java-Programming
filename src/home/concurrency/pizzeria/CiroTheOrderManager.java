package home.concurrency.pizzeria;

import java.util.LinkedList;
import java.util.Queue;

/**
 * this class' purpose is to handle the transfer of the orders from the pizzeria to the pizzaioli. Its job is to assign the orders to the right
 * pizzaioli according to who is free or not. The orders are inserted in a queue that follows the FIFO principlce.
 */
class CiroTheOrderManager {

	//this is the queue that contains all the orders made
	private Queue<Order> orders;
	
	//this field is set to true by the pizzeria when it is about to close
	private boolean shopClosed;
	
	
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
		
		notifyAll();
		return this.orders.remove();
	}
	
	protected void closeShop() {
		this.shopClosed = true;
	}
	
	protected boolean isShopClosed() {
		return this.shopClosed;
	}
	
	protected boolean isQueueEmpty() {
		return orders.isEmpty();
	}

}
