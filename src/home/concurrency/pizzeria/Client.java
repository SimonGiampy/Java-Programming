package home.concurrency.pizzeria;

import java.util.Random;

/**
 * a Client is a thread that makes a random order for the Pizzeria
 */
public class Client implements Runnable {
	
	private final String name;
	private int idClient;
	
	/**
	 * enumeration containing the different priority levels
	 */
	private enum Priorities {
		LOW, MEDIUM, HIGH, VERY_HIGH;
	}
	
	private final Priorities servingPriority; //priority attribute of current instance
	
	private OrderListener listener; //listener instance for this Client
	
	/**
	 * sets up the listener for the event of order creation
	 * @param listener the listener object is an instance of a class that implements OrderListener (that is always
	 *                 Pizzeria in this case)
	 */
	protected void setOrderMadeListener(OrderListener listener) {
		this.listener = listener;
	}
	
	/**
	 * When an object implementing interface {@code Runnable} is used to create a thread, starting the thread causes the
	 * object's {@code run} method to be called in that separately executing thread.
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("client " + this.getName() + " started running");
		Order myOrder = generateRandomOrder();
		this.listener.onOrderReceived(this, myOrder);
	}
	
	protected Client(String name, int id) {
		this.name = name;
		this.idClient = id;
		
		servingPriority = setPriority(); //random priority setting
	}
	
	/**
	 * random priority assignment
	 * @return the priority level generated
	 */
	private Priorities setPriority() {
		int num = (int) (Math.random() * 100) + 1; //different percentages of priorities
		if (num <= 5) {
			return Priorities.VERY_HIGH;
		} else if (num <= 15) {
			return Priorities.HIGH;
		} else if (num <= 40) {
			return Priorities.MEDIUM;
		} else return Priorities.LOW;
	}
	
	
	protected String getName() {
		return this.name;
	}
	
	protected int getIdClient() {
		return this.idClient;
	}
	
	/**
	 * a client generates randomly an order, with a random number of pizzas, and random types of pizzas.
	 * @return the randomly generated order
	 */
	protected Order generateRandomOrder() {
		Random random = new Random(System.currentTimeMillis() * System.nanoTime());
		//number of pizzas vary from 1 to 4
		int numPizzas = random.nextInt(4) + 1;
		Menu[] pizzas = new Menu[numPizzas];
		int choice;
		for (int i = 0; i < numPizzas; i++) {
			choice = random.nextInt(Menu.menuLength);
			pizzas[i] = Menu.values()[choice];
		}
		
		//at the moment the pizzaiolo is null since the request is handled by the pizzeria and not the client itself
		return new Order(pizzas, this, null);
	}
}
