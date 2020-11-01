package home.generics;

/**
 * Time format= hours:minutes:seconds
 * //TODO: add functions for summing and subtracting times, in base 60 of course
 * //TODO: add interfaces with methods that all classes used as generics for Interval must implement, in order to uniform
 *      all the methods implemented, that should be a standard
 */
public class Time implements Comparable<Time> {
	
	private final int hours, minutes, seconds;
	private String description;
	
	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.setDescription();
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	private void setDescription(String str) {
		this.description = str;
	}
	
	/**
	 * random stupid useless description, just for adding more parameters to the objects
	 * //TODO: create a more useful description of the time
	 */
	private void setDescription() {
		StringBuilder builder = new StringBuilder();
		if (hours == 12) {
			builder.append("mezzogiorno");
		} else if (hours == 6) {
			builder.append("alba");
		} else if (hours == 0) {
			builder.append("mezzanotte");
		}
		
		if (minutes == 30) {
			builder.append(" e mezza");
		} else if (minutes == 15) {
			builder.append(" e un quarto");
		} else if (minutes == 45) {
			builder.append(" e tre quarti");
		}
		
		if (seconds == 0) {
			builder.append(" precise.");
		} else {
			builder.append(" circa.");
		}
		this.description = builder.toString();
	}
	
	private String getDescription() {
		return description;
	}
	
	/**
	 * Compares this object with the specified object for order
	 * @param comparison the object to be compared with
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
	 * than the specified object.
	 * @throws NullPointerException if the specified object is null
	 */
	@Override
	public int compareTo(Time comparison) {
		int timeComparison = comparison.getHours() * 3600 + comparison.getMinutes() * 60 + comparison.getSeconds();
		int thisTime = this.getHours() * 3600 + this.getMinutes() * 60 + this.getSeconds();
		return thisTime - timeComparison;
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * @param obj the reference object with which to compare.
	 * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass() && this.getClass() == Time.class) {
			return ((Time) obj).getHours() == this.getHours() && ((Time) obj).getMinutes() == this.getMinutes() &&
					((Time) obj).getSeconds() == this.getSeconds();
		}
		return super.equals(obj);
	}
}
