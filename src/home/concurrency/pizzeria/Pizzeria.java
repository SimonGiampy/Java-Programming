package home.concurrency.pizzeria;

class Pizzeria implements Runnable, OrderListener {
	
	private final int numberOfPizzaioli = 3;
	private int processedOrders;
	
	private final Thread[] pizzaioliThreads;
	
	private final CiroTheOrderManager ciro;
	private boolean shopClosed;
	
	private final String[] namesPizzaioli = {"Gennaro 'o biondo", "Leonardo", "Ciro 'o svitat'", "Ciruzz 'o cicat",
			"Gennarino 'o milanes", "Genny 'o pompat", "Giuanni u' bucagummi", "Pascal", "Pino 'o luord",
			"Kristian 'o ncapac", "Don Franco u' sciupafimmine"};
	
	
	/**
	 * default constructor with default parameters, used for initial testing
	 */
	protected Pizzeria() {
		//just one pizzaiolo for initial tests
		processedOrders = 0;
		this.shopClosed = false;
		
		//this.ciro = manager;
		this.ciro = new CiroTheOrderManager(this);
		
		Pizzaiolo[] pizzaioli = new Pizzaiolo[numberOfPizzaioli];
		pizzaioliThreads = new Thread[numberOfPizzaioli];
		for (int i = 0; i < numberOfPizzaioli; i++) {
			pizzaioli[i] = new Pizzaiolo(getRandomName(), i, ciro, this);
			pizzaioliThreads[i] = new Thread(pizzaioli[i]);
		}
		
	}
	
	@Override
	public void run() {
		//starts the execution of all the threads created with the Pizzaioli runnables.
		for (Thread th: pizzaioliThreads) {
			th.start();
		}
		
		//anonymous runnable that checks whether if there is at least one pizzaiolo that is still alive and executing its task. If not every thread
		// has finished, this thread waits until all the pizzaioli finished. Then it closes the pizzeria
		new Thread( () -> {
			while (!arePizzaioliThreadsTerminated()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
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
			notifyAll();
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
	
	private void closeShop() {
		this.shopClosed = true;
	}
	
	protected boolean isShopClosed() {
		return this.shopClosed;
	}
	
}
