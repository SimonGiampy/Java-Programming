package home.concurrency.pizzeria;

/**
 * this enumeration serve as database for accessing the pizza properties and values. The list can be expanded easily
 */
public enum Menu {
	
	//TODO: create more pizzas
	MARGHERITA("Margherita", 3.5, 4),
	CAPRICCIOSA("Capricciosa", 6, 6),
	DIAVOLA("Diavola", 5.5, 5),
	MARINARA("Marinara", 3, 3);
	
	private final String name;
	private final double price; //expressed in euros
	private final int preparationTime; //expressed in real world minutes, goes from 3 (easiest) to 10 (special pizzas)
	
	protected static final int menuLength = 4; //change this number according to the number of pizzas present in the menu
	
	Menu(String name, double price, int preparationTime) {
		this.name = name;
		this.preparationTime = preparationTime;
		this.price = price;
	}
	
	protected String getName() {
		return name;
	}
	
	protected double getPrice() {
		return price;
	}
	
	protected int getPreparationTime() {
		return preparationTime;
	}
}
