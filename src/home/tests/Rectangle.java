package home.tests;

public final class Rectangle extends Triangle implements Operations{
	
	private int cathetus1;
	private int cathetus2;
	private int hypotenuse;
	
	public Rectangle(String type, int cathetus1, int cathetus2, int hypotenuse) {
		//super(type);
		this.cathetus1 = cathetus1;
		this.cathetus2 = cathetus2;
		this.hypotenuse = hypotenuse;
		this.area = computeArea();
	}
	
	@Override
	public int computeArea() {
		int area = cathetus1 * cathetus2 / 2;
	//	super.area = area;
		return area;
	}
	
	@Override
	public int computePerimeter() {
		return cathetus1 + cathetus2 + hypotenuse;
	}
	
	public Rectangle() {
	
	}
	
	
}
