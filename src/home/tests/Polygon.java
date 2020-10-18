package home.tests;

public class Polygon {
	
	protected int sides;
	protected String color;
	
	public Polygon(int sides, String color) {
		this.sides = sides;
		this.color = color;
	}
	
	public Polygon() {
		System.out.println("instantiated polygon\n");
	}
	
	public int getSides() {
		return sides;
	}
	
	public String getColor() {
		return color;
	}
}
