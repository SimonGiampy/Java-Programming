package home.genericTypes.intervals;

/**
 * Time format= hours:minutes:seconds
 * //TODO: add functions for summing and subtracting times
 */
 class Time implements Comparable<Time> {
	
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
	
	/**
	 * sets a string unique for the Time object which is the format representation with 2 digits for every integer
	 */
	private void setDescription() {
		this.description = String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
	}
	
	protected String getDescription() {
		return this.description;
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
		return thisTime - timeComparison; //represents the time difference expressed in seconds
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
