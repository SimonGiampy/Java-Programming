package home.generics;

import java.util.ArrayList;

/**
 * this is not a generic class, but its only purpose is to have a generic method inside it
 */
public class SortingGenerics {
	
	/**
	 * This function takes as input an arraylist of elements of the generic type T, then sorts them by using a simple
	 * algorithm which does the comparisons using the specific implementation of the generic types.
	 * This method is static since it doesn't require an instance of this class to be executed.
	 * @param list arraylist that contains a number of elements of the generic method specified
	 * @param <T> generic class which defines the type of the elements contained in the array list
	 * @return the arraylist sorted according to the comparisons implemented in the specific functions
	 */
	public static <T extends Comparable<T>> ArrayList<Interval<T>> sortElements(ArrayList<Interval<T>> list) {
		//implementation of the Insertion Sort algorithm, applicable to all Comparable classes
		
		Interval<T> temp;
		for (int i = 1, j; i < list.size(); i++) {
			j = i;
			while (j > 0 && list.get(j-1).compareTo(list.get(j)) > 0) {
				temp = list.get(j-1);
				list.set(j-1, list.get(j));
				list.set(j, temp);
				j--;
			}
		}
		//PROBLEM: technically the sorting order is based on the comparison function implemented in the class Time (the
			//generic type). But the comparison return values I used constitute a description which is not really suited
			//for sorting the intervals. A better distinction of the return values and a more sophisticated comparison
			//mechanism is needed for the sort method. But it's not needed, since it's just for testing purposes
		
		return list;
	}
}
