package home.concurrency.pizzeria;

import java.util.LinkedList;
import java.util.Queue;

class CiroTheOrderManager {

	private Queue<Order> orders;
	
	// True if consumer should wait for producer to send message,
	// false if producer should wait for consumer to retrieve message.
	private boolean flag;
	//this field is set to true by the pizzeria when it is about to close
	private boolean shopClosed;
	
	
	protected CiroTheOrderManager() {
		orders = new LinkedList<>();
		this.flag = true;
		this.shopClosed = false;
	}
	
	protected synchronized void assignOrder(Order newOrder) throws InterruptedException {
		/*
		while (!flag) {
			wait();
		}
		*/
		
		flag = false;
		this.orders.add(newOrder);
		
		System.out.println("added new order from " + orders.element().getClient().getIdClient());
		notifyAll();
	}
	
	protected synchronized Order takeOrder() throws InterruptedException {
		while (this.orders.isEmpty() && !this.shopClosed) {
			wait();
		}
		flag = true;
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
