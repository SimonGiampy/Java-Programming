package home.functional.lambdas;

import java.util.Arrays;
import java.util.Comparator;

/**
 * random testing for lambda expressions
 */
class StringSorting {
	
	public static void main(String[] args) {
		//Exercise purpose: sorting of strings in an input array. The sorting is based on the string length:
		//      shorter strings come before the longer ones. So their length is used as parameter for comparison
		String[] words = {"fnsf", "nfdskl", "ndfsdff", "ifeiowl", "fedwweff", "fee"};
		
		//METHOD1:
		String[] sortedWords1 = method1(words);
		String[] sortedWords2 = method2(words);
		String[] sortedWords3 = method3(words);
		String[] sortedWords4 = method4(words);
	}
	
	/**
	 * this method uses an instance of an interface, and it is passed as parameter to the sort function. The instance
	 * of the interface implements the compare method inside of it.
	 * @param words the input string array
	 * @return the same array but sorted
	 */
	private static String[] method1(String[] words) {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length()) {
					return -1;
				} else if (s1.length() > s2.length()) {
					return +1;
				} else return 0;
			}
		};
		Arrays.sort(words, comparator);
		return words;
	}
	
	/**
	 * same as the implementation of method1, but the interface is now anonymous and inner to this class
	 * @param words input
	 * @return sorted input
	 */
	private static String[] method2(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length()) {
					return -1;
				} else if (s1.length() > s2.length()) {
					return +1;
				} else return 0;
			}
		});
		return words;
	}
	
	/**
	 * this method uses a lambda expression that simplifies the comparison of string lengths
	 * @param words input array
	 * @return sorted input
	 */
	private static String[] method3(String[] words) {
		Arrays.sort(words, (s1, s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			} else if (s1.length() > s2.length()) {
				return +1;
			} else return 0;
		});
		return words;
	}
	
	/**
	 * this method uses a lambda expression, but instead passes a method reference as second parameter to the sort
	 * function. The method reference passed is a static function defined in the Comparator class, whose task is to
	 * sort integers according to the parameter in input. The parameter is the function that returns the string length.
	 * @param words input array
	 * @return sorted array
	 */
	private static String[] method4(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		//the statement above is equivalent to the following
		Arrays.sort(words, Comparator.comparingInt( x -> x.length())); //lambda expression that returns the string length
		
		return words;
	}
}
