package home.tests;

import java.util.Scanner;

public class Main {
	//TODO: add javadoc for all the classes and methods in the package
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("insert polygon type: ");
		String shape = scanner.next();
		System.out.println("insert type of polygon");
		String type = scanner.next();
		
		Polygon polygon = null;
		
		switch (shape) {
			case "Triangle": {
				if (type.equals("Right")) {
					polygon = new RightTriangle(10, 13, 18);
				} else if (type.equals("Isosceles")) {
					polygon = new IsoscelesTriangle(10, 23);
				}
			}; break;
			case "Circle": {
				polygon = new Circle();
			} break;
		}
		
		if (polygon != null) {
			int area = polygon.getArea();
			int perimeter = polygon.getPerimeter();
			System.out.println("area = " + area + "; peri = " + perimeter + ".\n");
		}
		
	}
}
