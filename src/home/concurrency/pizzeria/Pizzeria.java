package home.concurrency.pizzeria;

class Pizzeria implements OrderListener {
	
	private int numberOfPizzaioli;
	
	private Pizzaiolo pizzaiolo1;
	
	private String[] namesPizzaioli = {"Gennaro 'o biondo", "Leonardo", "Ciro 'o svitat'", "Ciruzz 'o cicat",
			"Gennarino 'o milanes", "Genny 'o pompat", "Giuanni u' bucagummi", "Pascal", "Pino 'o luord",
			"Kristian 'o ncapac", "Don Franco u' sciupafimmine"};
	
	
	/**
	 * default constructor with default parameters, used for initial testing
	 */
	protected Pizzeria() {
		//this function is just for testing
		GennaroTheClientManager gennaro = new GennaroTheClientManager(this, 1000);
		//just one pizzaiolo for initial tests
		pizzaiolo1 = new Pizzaiolo(getRandomName(), 0);
		pizzaiolo1.run();
	}
	
	/**
	 * the real constructor with parameters passed from the Starter class
	 * @param numberOfPizzaioli self explanatory
	 * @param clientSpawnDelay self explanatory
	 */
	protected Pizzeria(int numberOfPizzaioli, int clientSpawnDelay) {
	
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
