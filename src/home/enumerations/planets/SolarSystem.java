package home.enumerations.planets;

enum SolarSystem {
	
	//list of planets with their values assigned by the constructor
	//must be declared within one line before its method constructor and parameters
	Mercury("the hot one", 120.0, 130.1),
	Venus("sulphuric", 1344, 103420),
	Earth("our planet", 3223, 4355),
	Jupiter("the big one", 241342304, 234545423),
	Alternative("bitch please", 0.145);
	
	// universal gravitational constant  (m3 kg-1 s-2)
	protected static final double G = 6.67300E-11;
	
	//parameters used for every planet
	private final String name;
	private final double mass;
	private final double radius;
	private final double distance;
	
	SolarSystem(String nickName, double mass, double radius) {
		this.name = nickName;
		this.mass = mass;
		this.radius = radius;
		this.distance = 0; //not initialized
	}
	
	/**
	 * overloading of the constructor which provides additional parameters in case of a different set of plantes
	 * @param nickName describes the name of the planet, different from the classic one
	 * @param distance distance from the sun
	 */
	SolarSystem(String nickName, double distance) {
		this.name = nickName;
		this.radius = 0; //not initialized
		this.mass = 0; //not initialized
		this.distance = distance;
	}
	
	protected String getName() {
		return name;
	}
	
	protected double getMass() {
		return mass;
	}
	
	protected double getRadius() {
		return radius;
	}
	
	protected double getDistance() {
		return distance;
	}
	
	/**
	 * this method translates the enumeration name type in a string
	 * the original toString method does a literal translation, instead this one adds a funny string, overriding
	 * the default one
	 * @return a string funnier than the original one supplied by java
	 */
	@Override
	public String toString() {
		return "la puttana di " + super.toString();
	}
}
