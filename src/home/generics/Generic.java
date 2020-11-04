package home.generics;

import java.util.ArrayList;
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
		/*
		//manual input testing
		Scanner scan = new Scanner(System.in);

		Time time1 = randomTime();
		Time time2 = randomTime();
		
		System.out.printf("time1 = %s; time2 = %s\n", time1.getDescription(), time2.getDescription());
		
		Interval<Time> obj1 = new Interval<>(time1, time2);
		
		Time time3 = input(scan, 3);
		Time time4 = input(scan, 4);
		
		Interval<Time> obj2 = new Interval<>(time3, time4);
		
		System.out.println("comparison yields " + obj1.compareTo(obj2) + "\n");
		System.out.println("");*/
		
		//automatic testing with randomized input
		//just creates an arraylist with random objects inserted. this is for testing nested generic classes
		ArrayList<Interval<Time>> list = new ArrayList<>();
		int number = 20;
		Time[] timetable = new Time[number];
		int i = 0;
		for (Time t: timetable) {
			t = randomInput();
			System.out.println("time " + i + " = " + t.getDescription() + "\n");
			i++;
		}
		for (i = 0; i < number; i+=2) {
			Interval<Time> interval = new Interval<>(timetable[i], timetable[i+1]);
			list.add(i/2, interval);
		}
		
		list = SortingGenerics.sortElements(list);
		System.out.println("sorted the array list");
		for (i = 0; i < list.size(); i++) {
			Time t1 = list.get(i).getLower();
			Time t2 = list.get(i).getUpper();
			System.out.printf("interval %d = <%s , %s>\n", i, t1.getDescription(), t2.getDescription());
		}
	}
	
	
	private static Time manualInput(Scanner scan, int i) {
		System.out.println("write time " + i + " with this format: hh:mm:ss in a single line");
		String str = scan.nextLine();
		int hour = Integer.parseInt(str.substring(0, 2));
		int minutes = Integer.parseInt(str.substring(3, 5));
		int seconds = Integer.parseInt(str.substring(6, 8));
		
		return new Time(hour, minutes, seconds);
	}
	
	/**
	 * randomize creation of a new Time instance
	 * @return Time object with random values
	 */
	private static Time randomInput() {
		int hours = (int) (Math.random() * 24);
		int minutes = (int) (Math.random() * 60);
		int seconds = (int) (Math.random() * 60);
		return new Time(hours, minutes, seconds);
	}
	
}
