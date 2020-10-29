package home.enumerations.planets;

public class Main {
	
	public static void main(String[] args) {
		//iteration through the elements of the enumeration for the solar system
		int i = 1;
		String str;
		for (SolarSystem planet: SolarSystem.values()) {
			str = "planet " + i + " with nickname " + planet.toString() + " is called " + planet.getName() + " has mass = " + planet.getMass() + " and radius = " + planet.getRadius();
			System.out.println(str);
			i++;
		}
		
	}
}
