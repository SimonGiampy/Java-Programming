package home.generics;

import java.util.Scanner;

/**
 * This class is the starter class for the creation of an Interval generic class. The Interval class is based
 * on generic object types with multiple values and parameters, handled by the specific class. The purpose of the generic
 * class is to handle objects without knowing what they were intended for, and how they are implemented.
 * The exercise is structured for testing the Interval class with different classes made ad-hoc for using
 * custom sets of numbers, each one with its rules. The generic objects must implement the Comparable interface, in order
 * to make sure they can be interpreted as numbers and be compared one to another.
 */
public class Generic {
	
	/**
	 * the main method creates objects of the various custom classes, and assigns the required parameters. Then creates the
	 * Interval object using the custom classes as generic types. The purpose is testing the Interval functionalities, which
	 * must work for every custom class.
	 * @param args console input
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Time time1 = input(scan, 1);
		Time time2 = input(scan, 2);
		
		System.out.printf("time1 = %2d:%2d:%2d; time2 = %2d:%2d:%2d\n", time1.getHours(), time1.getMinutes(), time1.getSeconds(),
				time2.getHours(), time2.getMinutes(), time2.getSeconds());
		
		Interval<Time> obj1 = new Interval<>(time1, time2);
		
		Time time3 = input(scan, 3);
		Time time4 = input(scan, 4);
		
		Interval<Time> obj2 = new Interval<>(time3, time4);
		
		System.out.println("comparison yields " + obj1.compareTo(obj2) + "\n");
		
		//TODO: test more methods for the generic class
		
		//TODO: add support for the classes Date and Timezone
	}
	
	private static Time input(Scanner scan, int i) {
		System.out.println("write time " + i + "with this format: hh:mm:ss in a single line");
		String str = scan.nextLine();
		int hour = Integer.parseInt(str.substring(0, 2));
		int minutes = Integer.parseInt(str.substring(3, 5));
		int seconds = Integer.parseInt(str.substring(6, 8));
		
		return new Time(hour, minutes, seconds);
	}
	
	//TODO: add input randomization for testing quickly multiple intervals, without having to wait for the user input
}
