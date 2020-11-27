package home.functional.streams;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

/**
 * this class contains a set of utility functions to test the Stream class. The purpose is learning how to apply functional programming paradigm in
 * order to simplify a set of complex functions, which otherwise would take too long to be written.
 * @see <a href="https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/"> Stream Class tutorial </href>
 */
class StreamExample {
	
	public static void main(String[] args) {
		String textExample = "Lorem Ipsum is the single greatest threat. We are not - we are not keeping up with other websites. Lorem Ipsum best not" +
				" make any more threats to your website. It will be met with fire and fury like the world has never seen. Does everybody know that pig " +
				"named Lorem Ipsum? An ‘extremely credible source’ has called my office and told me that Barack Obama’s placeholder text is a fraud.";
		
		//converts the string into an arraylist in which all the elements of the array are the single words present in the text
		ArrayList<String> array = new ArrayList<>();
		int pos = 0;
		for (int i = 0; i < textExample.length(); i++) {
			if (textExample.charAt(i) == ' ') {
				array.add(textExample.substring(pos, i));
				pos = i+1;
			}
		}
		array.add(textExample.substring(pos));
		
		//Stream creation from the arraylist of strings
		Stream<String> stream = array.stream();
		
		//shows output of mapper function
		//printStream(mapper(stream));
		//shows output of the custom filter
		//printStream(filterer(stream));
		//show output of the custom sorting method
		//printStream(sorting(stream));
		
		//shows the entire structure of the Map created from the application of two different Functions to the strings in the Stream object
		Map<Double, ArrayList<Integer>> outputMap = collector(uniqueWords(stream));
		//shows the entire structure of the map created with the collect method, by printing the values, using a Consumer Function with 2 parameters.
		outputMap.forEach(new BiConsumer<Double, ArrayList<Integer>>() {
			@Override
			public void accept(Double x, ArrayList<Integer> integers) {
				System.out.printf("%f: < ", x);
				for (int i: integers.toArray(new Integer[0])) {
					System.out.printf("%d ", i);
				}
				System.out.print(" >\n");
			}
		});
		
	}
	
	//TODO: add advanced collector mapper, that uses four different operations: a supplier, an accumulator, a combiner and a finisher.
	
	/**
	 * This method is an example of the usage of the {@code Stream.collect} method, which transforms a Stream object to a collection, (a Map here).
	 * The output Map is a set of keys and values. The keys are Double variables, the values are Arraylists of integers. There are 2 Functions that
	 * elaborate the set of strings in input: the keyMapper Function takes a string and calculates the corresponding key value. The valueMapper
	 * Function takes an input string and generates a list of integers from it. One necessary requirement for the input stream is that every
	 * element must be distinct from the others, since the mapping is a 1-to-1 unique relationship.
	 * @param stream the input stream containing only distinct words
	 * @return a new map where the keys are Double numbers, and the values are an arraylist of integers
	 */
	private static Map<Double, ArrayList<Integer>> collector(Stream<String> stream) {
		//usage example of a Predicate that tests the validity of the specified condition (length less or equal than 10)
		//can be easily replaced with a lambda expression
		boolean shortStrings = stream.allMatch(new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return s.length() <= 10;
			}
		});
		/* //equivalent lambda expression:
		 * boolean shortStrings = stream.allMatch(s -> s.length() <= 10);
		 */
		
		
		//a Function object that calculates a double value from an input string. Can be simplifies in a lambda expression
		Function<String, Double> keyMapper = new Function<String, Double>() {
			@Override
			public Double apply(String s) {
				int temp;
				double result = 1;
				//nonsensical algorithm that extrapolates a unique double value from a string. by examining each character
				for (int i = 0; i < s.length(); i++) {
					temp = s.charAt(i) * 3 + s.toUpperCase().charAt(i) * 3;
					result += sqrt(temp);
				}
				return result;
			}
		};
		
		//a Function object that calculates an arraylist of integers from an input string. Can be simplified in a lambda expression
		Function<String, ArrayList<Integer>> valueMapper = new Function<String, ArrayList<Integer>>() {
			@Override
			public ArrayList<Integer> apply(String s) {
				//creates a set of numbers from an input string, a stupid algorithm
				ArrayList<Integer> integers = new ArrayList<>();
				int k;
				for (int i = 0; i < s.length(); i++) {
					k = s.toUpperCase().charAt(i);
					integers.add(k);
				}
				//orders the arraylist
				integers.sort(Integer::compareTo);
				return integers;
			}
		};
		
		//returns the map of the 2 functions, where the input string is mapped to a set of keys (double values) and a set of values (arraylist)
		return stream.collect(Collectors.toMap(keyMapper, valueMapper));
	}
	
	/**
	 * the Map is used to modify the elements in the stream, by using a Function class, implemented with a lambda expression.
	 * In this example, every character is modified by calculating the ascii code and shifting it of 10 positions. The resulting string
	 * is composed of all the characters concatenated.
	 * @param stream input
	 * @return the new stream modified from the input one
	 */
	private static Stream<String> mapper(Stream<String> stream) {
		//maps every string in the stream to a newly created string, transformed from the original one with a simple algorithm
		return stream.map((String s) -> {
			int k;
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				k = s.charAt(i) + 10;
				//creates a new character by converting the original char to its ascii code (integer) and then shifting it by 10 positions
				//in the ascii table. The result is a new character which might also be a special symbol
				builder.append((char) k);
			}
			//the result is a string with the same length as the original, but every character is different
			return builder.toString();
		});
	}
	
	/**
	 * the Filter is used to take a set of the elements of the stream that satisfy a boolean formula (expressed with a Predicate class).
	 * in this example, it returns a new stream containing the filtered elements accepted by the filter
	 * @param stream input
	 * @return the filtered stream with the algorithm implemented
	 */
	private static Stream<String> filterer(Stream<String> stream) {
		/*
		stream.filter(new Predicate<String>() { //classic version with anonymous inner classes and implementation of an interface
			@Override
			public boolean test(String s) {
				//something here
			}
		})
		 */
		
		//equivalent lambda expression that simplifies the calculation
		return stream.filter(s -> {
			if (s.length()> 1) {
				return s.charAt(0) > s.charAt(1);
			} else return false;
		});
		//comparison between the ascii values of the first and second character in the string
	}
	
	
	/**
	 * sorts the string using the compare method implemented in the lambda expression
	 * @param stream input stream to be sorted
	 * @return the sorted stream, using the simple algorithm implemented with the Comparator interface
	 */
	private static Stream<String> sorting(Stream<String> stream) {
		//lambda expression with type inference (object String) that implements the functional interface Comparator, with the method compare
		//the method implemented in the lambda expression is:
		//      int compare(String s1, String s2);
		return stream.sorted((s1, s2) -> {
			//stupid algorithm that compares the ascii values of each character in the strings being compared
			final int minLength = min(s1.length(), s2.length());
			for (int i = 0; i < minLength; i++) {
				if ((int) s1.charAt(i) > (int) s2.charAt(i)) {
					return 1;
				} else if (s1.charAt(i) == s2.charAt(i)) {
					//goes on
					if (i == minLength - 1) {
						return Integer.compare(s1.length(), s2.length()); //compares the lengths of the strings
						//the smaller string is the one that will come before
						//the bigger string is the one that will come after
						//if the strings are of equal size, it returns 0
					}
				} else if ((int) s1.charAt(i) < (int) s2.charAt(i)) {
					return -1;
				}
			}
			//should never arrive here
			return 0;
		});
	}
	
	/**
	 * returns a stream with distinct words
	 * @param stream input
	 * @return the array with only the unique words, since it takes the distinct values in it
	 */
	private static Stream<String> uniqueWords(Stream<String> stream) {
		return stream.distinct();
	}
	
	/**
	 * prints the content of the strings
	 * @param stream a stream of strings
	 */
	private static void printStream(Stream<String> stream) {
		stream.forEach(System.out::println);
	}
}
