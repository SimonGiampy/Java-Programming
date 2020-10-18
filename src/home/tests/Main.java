package home.tests;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("insert polygon type: ");
		String name = scanner.next();
		//String line = scanner.nextLine();
		
		switch (name) {
			case "Triangle": {
				
				String type = scanner.next();
				Triangle triangle = new Triangle(type);
				
				
			}; break;
			case "Circle": {
				Circle circle = new Circle();
			} break;
		}
		
		/*
		Operations op = new Rectangle();
		int area = op.computeArea();
		int per = op.computePerimeter();
		System.out.println("area = " + area + "; peri = " + per + ".\n");
		 */
		
	}
}
