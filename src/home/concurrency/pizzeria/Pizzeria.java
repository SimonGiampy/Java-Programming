package home.concurrency.pizzeria;

class Pizzeria implements Runnable, OrderListener {
	
	private int numberOfPizzaioli;
	private int processedOrders;
	
	private Thread maker;
	private Pizzaiolo pizzaiolo;
	private final OrderManager gennaro;
	
	
	private final String[] namesPizzaioli = {"Gennaro 'o biondo", "Leonardo", "Ciro 'o svitat'", "Ciruzz 'o cicat",
			"Gennarino 'o milanes", "Genny 'o pompat", "Giuanni u' bucagummi", "Pascal", "Pino 'o luord",
			"Kristian 'o ncapac", "Don Franco u' sciupafimmine"};
	
	
	/**
	 * default constructor with default parameters, used for initial testing
	 */
	protected Pizzeria(OrderManager manager) {
		//just one pizzaiolo for initial tests
		numberOfPizzaioli = 1;
		processedOrders = 0;
		
		this.gennaro = manager;
		pizzaiolo = new Pizzaiolo(getRandomName(), 0, gennaro);
		maker = new Thread(pizzaiolo);
		//maker.setDaemon(true);
	}
	
	@Override
	public void run() {
		maker.start();
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
			this.gennaro.assignOrder(order);
			processedOrders++;
			if (processedOrders == GennaroTheClientManager.numberOfClients) {
				gennaro.closeShop();
				Thread.currentThread().interrupt();
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
