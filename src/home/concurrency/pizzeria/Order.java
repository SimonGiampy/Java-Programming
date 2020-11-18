package home.concurrency.pizzeria;

/**
 * Contains the types of pizzas chosen, the quantities, and calculates the price that the Client pays to the Pizzeria
 */
public class Order {

	private int numberPizzas; //total number of pizzas in the order
	private Menu[] pizzas;
	private double price;
	private Client client;
	private Pizzaiolo pizzaiolo;
	private String orderDescription;
	
	
	/**
	 * Client creates an order, containing a set of pizzas (from 1 to 4). The order is processed by a single pizzaiolo.
	 * There is a one-to-one association between clients and pizzaioli, since one order is made by a single client,
	 * is processed by the pizzeria, and all the pizzas in the order are made by the same single pizzaiolo.
	 * @param pizzas the array containing the chosen pizzas
	 * @param client the client who makes the order
	 * @param pizzaiolo the pizzaiolo who makes the pizzas
	 */
	protected Order(Menu[] pizzas, Client client, Pizzaiolo pizzaiolo) {
		this.numberPizzas = pizzas.length;
		this.pizzas = pizzas;
		this.client = client;
		this.pizzaiolo = pizzaiolo;
		
		for (int i = 0; i < numberPizzas; i++) {
			this.price += pizzas[i].getPrice();
		}
		
		//creates the text description of the order
		//TODO: add the multiplicity of the pizzas in the text. For example, a client "ordered 2 margherita, 2 capricciosa".
		StringBuilder builder = new StringBuilder();
		builder.append(client.getName()).append(" ordered ");
		for (int i = 0; i < numberPizzas; i++) {
			builder.append("one ").append(pizzas[i].getName()).append(", ");
		}
		builder.append("totaling ").append(this.price).append("€");
		this.orderDescription = builder.toString();
	}
	
	public int getNumberPizzas() {
		return numberPizzas;
	}
	
	public Menu[] getPizzas() {
		return pizzas;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Pizzaiolo getPizzaiolo() {
		return pizzaiolo;
	}
	
	public String getOrderDescription() {
		return orderDescription;
	}
}
