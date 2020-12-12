package home.designPatterns.abstractFactory_builder;

import java.util.Scanner;

class Client {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input car engine type: electric (1), gas (2), hybrid (3)");
		int engine = scanner.nextInt();
		
		//simple attribute to add to a car
		System.out.println("input car color");
		String color = scanner.next();
		
		//this decides the model of the car
		System.out.println("input your budget: ");
		int budget = scanner.nextInt();
		
		
		//creates an object of the desired class based on the input, using the factories for each parameter. The factories will choose the
		// right model based on the budget given in input. Greater budget will return more expensive car models.
		
		//Abstract factory design pattern concurrently with builder design pattern in action here
		CarSeller seller = new CarSeller(budget);
		seller = seller.setCarColor(color).setCarEngineType(engine);
		Car newCar;
		
		switch (engine) {
			case 1 -> newCar = new ElectricCarBuilder(seller).build();
			case 2 -> newCar = new GasCarBuilder(seller).build();
			default -> newCar = new HybridCarBuilder(seller).build();
		}
		
		System.out.println("I can sell you a " + newCar.getModelName() + " with top speed of " + newCar.getTopSpeed() +
				" whose base color is " + newCar.getBaseColor() + " for the price you asked");
	}
}
