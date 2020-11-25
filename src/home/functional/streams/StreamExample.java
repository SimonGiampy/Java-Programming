package home.functional.streams;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

/**
 * this class contains a set of utility functions to test the Stream class and apply functional programming to a simple example
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
		
		
		Stream<String> stream = array.stream();
		//printStream(mapper(stream));
		//TODO: add function to extrapolate the data from the returned map
		
	}
	
	//TODO: add advanced collector mapper, that uses four different operations: a supplier, an accumulator, a combiner and a finisher.
	
	//TODO: try to find a sense in all this crap
	//TODO: add comments to explain this bullshit code
	private static Map<Double, BinaryOperator<Integer>> collector(Stream<String> stream) {
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
		
		//TODO: probably a binary operator doesn't make any sense
		//this is the equivalent lambda expression that represents the same statement as the one above
		Function<String, BinaryOperator<Integer>> valueMapper = new Function<String, BinaryOperator<Integer>>() {
			@Override
			public BinaryOperator<Integer> apply(String s) {
				return (BinaryOperator<Integer>) (x, y) -> {
					int z = 0;
					for (int i = 0; i < s.length(); i++) {
						z += x * s.charAt(i) + y * s.indexOf("f");
					}
					return z;
				};
			}
		};
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
