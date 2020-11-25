package home.concurrency.pizzeria;

import java.util.Scanner;

class Starter {
	
	public static void main(String[] args) {
		
		//user input asked for parameters
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("how many pizzaioli in the pizzeria?");
		int numPizzaioli = scanner.nextInt();
		*/
		
		//default parameters version
		Pizzeria pizzeria = new Pizzeria();
		//order of execution: Starter (user input) -> Pizzeria (parameters setup) -> Gennaro (Clients spawner) -> Pizzaioli
	
		
		//testing randomness for the order random generation
		/*
		Client giovanni = new Client("Gio", 1);
		Order orders;
		for (int i = 0; i < 10; i++) {
			orders = giovanni.generateRandomOrder();
			System.out.println(orders.getOrderDescription());
		}*/
	}
}
