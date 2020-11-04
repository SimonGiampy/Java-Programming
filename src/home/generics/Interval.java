package home.generics;

/**
 * This generic class handles pairs of objects, which are unknown to this class, since their behavior is independent from
 * this class' behavior. The Interval class is supposed to handle different algebraic operations between the objects of type A
 * and B. In this exercise the classes A and B must be the same type in order for the interval functions to make sense
 * and work.
 * @param <A> generic class for the bounds of the interval. Both bounds (upper and lower) must be of the same type
 *
 */
public class Interval<A extends Comparable<A>> implements Comparable<Interval<A>>  {
	
	private final A lower, upper; //upper and lower bounds of the interval
	
	protected Interval(A lower, A upper) {
		if (lower.compareTo(upper) > 0) { //upper bound must be greater than the lower bound
			A temp = lower;
			lower = upper;
			upper = temp;
		}
		this.lower = lower;
		this.upper = upper;
	}
	
	public A getLower() {
		return lower;
	}
	
	public A getUpper() {
		return upper;
	}
	
	/**
	 * returns a series of numbers which depend on the relative position of the Interval with the comparison one
	 * @param comparison the interval which the current Interval object is compared to
	 * @return <ul>
	 *     <li> -3 if the interval is smaller than the one which is compared with</li>
	 *     <li> -2 if the interval is detached from the other and goes to the left</li>
	 *     <li> -1 if the interval partially overlaps the other and the lower bound is on the left</li>
	 *     <li> 0 if the intervals coincide</li>
	 *     <li> +1 if the interval partially overlaps the other and the upper bound goes to the right</li>
	 *     <li> +2 if the interval is detached from the other and goes to the right</li>
	 *     <li> +3 if the interval is bigger than the one which is compared with</li>
	 * </ul>
	 */
	@Override
	public int compareTo(Interval<A> comparison) {
		if (this.getUpper().compareTo(comparison.getLower()) < 0) {
			return -2;
		} else if (this.getUpper().compareTo(comparison.getLower()) > 0) {
			if (this.getUpper().compareTo(comparison.getUpper()) < 0) {
				if (this.getLower().compareTo(comparison.getLower()) < 0) {
					return -1;
				} else {
					return -3;
				}
			} else {
				if (this.getLower().compareTo(comparison.getLower()) < 0) {
					return +3;
				} else {
					return +1;
				}
			}
		} else if (this.getLower().compareTo(comparison.getUpper()) > 0) {
			return  +2;
		}
		return 0;
	}
	
	public boolean comesBefore(Interval<A> interval) {
		return this.compareTo(interval) == -2;
	}
	
	public boolean comesAfter(Interval<A> interval) {
		return !comesBefore(interval);
	}
	
	public boolean isInside(Interval<A> interval) {
		return this.compareTo(interval) == -3;
	}
	
	public boolean isOverlapping(Interval<A> interval) {
		return !isInside(interval);
	}
	
	public boolean overlapsOnTheLeft(Interval<A> interval) {
		return this.compareTo(interval) == -1;
	}
	
	public boolean overlapsOnTheRight(Interval<A> interval) {
		return !overlapsOnTheLeft(interval);
	}
}
