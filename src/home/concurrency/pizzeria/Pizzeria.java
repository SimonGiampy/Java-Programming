package home.concurrency.pizzeria;

public class Pizzeria implements OrderListener {
	
	private int numberOfPizzaioli;
	
	
	protected Pizzeria() {
		//this function is just for testing
		GennaroTheClientManager gennaro = new GennaroTheClientManager(this, 1000);
		Pizzaiolo pizzaiolo = new Pizzaiolo("Ciro", 7);
	}
	
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
		System.out.println("order received");
		
	}
	
	//listener on order received
	
}
