package home.concurrency.pizzeria;

class Pizzeria implements Runnable, OrderListener {
	
	private final int numberOfPizzaioli = 2;
	private int processedOrders;
	
	private Thread[] pizzaioliThreads;
	private Pizzaiolo[] pizzaioli;
	
	private final CiroTheOrderManager ciro;
	
	
	private final String[] namesPizzaioli = {"Gennaro 'o biondo", "Leonardo", "Ciro 'o svitat'", "Ciruzz 'o cicat",
			"Gennarino 'o milanes", "Genny 'o pompat", "Giuanni u' bucagummi", "Pascal", "Pino 'o luord",
			"Kristian 'o ncapac", "Don Franco u' sciupafimmine"};
	
	
	/**
	 * default constructor with default parameters, used for initial testing
	 */
	protected Pizzeria(CiroTheOrderManager manager) {
		//just one pizzaiolo for initial tests
		processedOrders = 0;
		
		this.ciro = manager;
		pizzaioli = new Pizzaiolo[2];
		pizzaioliThreads = new Thread[2];
		for (int i = 0; i < numberOfPizzaioli; i++) {
			pizzaioli[i] = new Pizzaiolo(getRandomName(), i, ciro);
			pizzaioliThreads[i] = new Thread(pizzaioli[i]);
		}
		
	}
	
	@Override
	public void run() {
		for (Thread th: pizzaioliThreads) {
			th.start();
		}
		
		Thread shopManager = new Thread(() -> {
			while (arePizzaioliThreadsAlive()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	private boolean arePizzaioliThreadsAlive()  {
		for (int i = 0; i < numberOfPizzaioli; i++) {
			if (!pizzaioliThreads[i].isAlive()) return false;
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
	public void onOrderReceived(Client client, Order order) {
		System.out.println("order received from client#" + client.getIdClient());
		try {
			this.ciro.assignOrder(order);
			processedOrders++;
			if (processedOrders == GennaroTheClientManager.numberOfClients) {
				ciro.closeShop();
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	
	
}
