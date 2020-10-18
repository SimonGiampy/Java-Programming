package home.tests;

public class Polygon {
	
	protected int sidesNumber;
	protected String color;
	private int area;
	private int perimeter;
	
	public Polygon(int sidesNumber, String color) {
		this.sidesNumber = sidesNumber;
		this.color = color;
	}
	
	public Polygon() {
		System.out.println("instantiated polygon\n");
	}
	
	public int getSidesNumber() {
		return sidesNumber;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public int getPerimeter() {
		return perimeter;
	}
	
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
	
	
}
