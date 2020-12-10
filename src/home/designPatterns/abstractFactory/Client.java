package home.designPatterns.abstractFactory;

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
		
		
		//TODO: create an object of the desired class based on the input, using the factories for each parameter. The factories will choose the
		// right model based on the budget given in input. Greater budget will return more expensive car models.
		
		CarSeller seller = new CarSeller(budget);
		seller = seller.setCarColor(color).setCarEngineType(engine);
		ElectricCar car = seller.buildCar();
		
		
		
		//TODO: make it return a pre defined name for the chosen type of car: an example would be
		//  input = electric sports white -> output = "white tesla roadster"
	}
}
