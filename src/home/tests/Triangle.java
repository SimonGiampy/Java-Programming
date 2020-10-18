package home.tests;

public class Triangle extends Polygon {
	
	protected String type;
	int area;
	int perimeter;
	
	public Triangle(String type) {
		super(3, "white");
		this.type = type;
		if (type.equals("Rectangle")) {
			Rectangle rect = new Rectangle(type,10, 10, 15);
			System.out.println("area = " + this.area + "; peri = " + this.perimeter + ".\n");
			//int area = rect.computeArea();
			//setArea(area);
		}
	}
	
	public Triangle() {
	
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
