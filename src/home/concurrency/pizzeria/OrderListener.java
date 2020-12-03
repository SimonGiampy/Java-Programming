package home.concurrency.pizzeria;

/**
 * this interface serves for the Observer design pattern. It is the function called for the custom made event
 */
interface OrderListener {
	
	/**
	 * this method is the core of the Observer design pattern. When the order is made, the Client class calls this method.
	 * Then the receiver Class, which is the Pizzeria, receives the function call, since it was listening for the event.
	 * @param client the CLient object who creates the event
	 * @param order the order object to be transferred to the event listener
	 */
	void onOrderReceived(Client client, Order order);
	
}
