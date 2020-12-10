package home.concurrency.pizzeria;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Pizzeria implements Runnable, OrderListener {
	
	private final int numberOfPizzaioli;
	private int processedOrders;
	private int completedOrders;
	
	private final Pizzaiolo[] pizzaioli;
	private final Thread[] pizzaioliThreads;
	
	private final CiroTheOrderManager ciro;
	private boolean shopClosed;
	
	protected ReentrantLock mainLock;
	protected Condition subThreadsTerminatedCondition;
	protected Condition orderCompletedCondition;
	protected Condition emptyOrdersQueueCondition;
	
	private final String[] namesPizzaioli = {"Gennaro 'o biondo", "Leonardo", "Ciro 'o svitat'", "Ciruzz 'o cicat",
			"Gennarino 'o milanes", "Genny 'o pompat", "Giuanni u' bucagummi", "Pascal", "Pino 'o luord",
			"Kristian 'o ncapac", "Don Franco u' sciupafimmine"};
	
	/**
	 * default constructor with default parameters inherited from the Starter class, used for testing concurrency mechanisms
	 */
	protected Pizzeria(int numberOfPizzaioli) {
		//just one pizzaiolo for initial tests
		this.processedOrders = 0;
		this.completedOrders = 0;
		this.shopClosed = false;
		this.numberOfPizzaioli = numberOfPizzaioli;
		
		
		this.ciro = new CiroTheOrderManager(this);
		
		this.pizzaioli = new Pizzaiolo[numberOfPizzaioli];
		pizzaioliThreads = new Thread[numberOfPizzaioli];
		for (int i = 0; i < numberOfPizzaioli; i++) {
			pizzaioli[i] = new Pizzaiolo(getRandomName(), i, ciro, this);
			pizzaioliThreads[i] = new Thread(pizzaioli[i]);
		}
		
		//locks and conditions used for managing the orders movement among classes
		mainLock = new ReentrantLock();
		subThreadsTerminatedCondition = mainLock.newCondition();
		orderCompletedCondition = mainLock.newCondition();
		emptyOrdersQueueCondition = mainLock.newCondition();
	}
	
	@Override
	public void run() {
		//starts the execution of all the threads created with the Pizzaioli runnables.
		for (Thread th: pizzaioliThreads) {
			th.start();
		}
		
		//anonymous runnable that checks whether if there is at least one pizzaiolo that is still alive and executing its task. If not every thread
		// has finished, this thread waits until all the pizzaioli finished. Then it closes the pizzeria
		Thread threadsTerminationListener = new Thread( () -> {
			mainLock.lock();
			try {
				//TODO: fix this part and make it work
				while (!ciro.isQueueEmpty()) {
					emptyOrdersQueueCondition.await();
				}
				if (ciro.isQueueEmpty() && isShopClosed()) {
					System.out.println("termination signal");
				}
				
				
				while (!arePizzaioliThreadsTerminated()) {
					System.out.println("waiting for threads termination");
					//can be notified when the last order has been received or when the pizzeria is closed and the remaining orders are completed
					subThreadsTerminatedCondition.await();
					//TODO: try to remove the following statement
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("interrupted when checking for the threads' liveness");
				//TODO: check for the interruption of the await condition
			} finally {
				mainLock.unlock();
			}
			System.out.println("now i'm closing the shop");
		});
		
		//TODO: make a new function with the pattern Observer that listens for the completion of the orders from the pizzaioli and receives the
		// orders completed; notifies the other thread listener when the total number of completed orders is the total count of clients created.
		
		threadsTerminationListener.start();
		//orderCompletedListener.start();
		
	}
	
	/**
	 * checks if all the threads of the pizzaioli are still running
	 * @return false when at least one the pizzaioli is still alive and still not terminated
	 */
	private boolean arePizzaioliThreadsTerminated()  {
		for (int i = 0; i < numberOfPizzaioli; i++) {
			if (pizzaioliThreads[i].isAlive()) return false;
		}
		return true;
	}
	
	/**
	 * this method is called whenever this class, which listens to the custom event (order created). This is part of the
	 * Observer design pattern, that provides event listeners
	 * @param order the Order object created and sent to the pizzeria by the Client
	 * @param client the client who makes the order
	 */
	@Override
	public synchronized void onOrderReceived(Client client, Order order) {
		System.out.println("order received from client#" + client.getIdClient());
		this.ciro.assignOrder(order);
		processedOrders++;
		if (processedOrders == GennaroTheClientManager.numberOfClients) {
			this.closeShop();
			
			mainLock.lock();
			try {
				subThreadsTerminatedCondition.signalAll(); //signals that the last customer's order has been received, so the main thread can terminate
			} finally {
				mainLock.unlock();
			}
			
		}
	}
	
	/**
	 * utility function to randomly choose the name of the pizzaiolo who works in the pizzeria
	 * @return a random name chosen from the list provided on top
	 */
	private String getRandomName() {
		double pos = Math.random() * namesPizzaioli.length;
		return namesPizzaioli[(int) pos];
	}
	
	/**
	 * function to start the procedure of closing the pizzeria. Must let the pizzaioli finish their work
	 */
	private void closeShop() {
		this.shopClosed = true; //sets the flag to true
		//closing condition is signaled to all sub threads
		for (Pizzaiolo p : pizzaioli) {
			p.pizzaLock.lock();
			try {
				p.shopClosedCondition.signalAll();
			} finally {
				p.pizzaLock.unlock();
			}
		}
	}
	
	/**
	 * getter for boolean flag
	 * @return true if the pizzeria is closed
	 */
	protected boolean isShopClosed() {
		return this.shopClosed;
	}
	
}
