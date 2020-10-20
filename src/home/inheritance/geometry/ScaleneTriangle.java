package home.inheritance.geometry;

/**
 * 3 sides with different dimensions
 */
public class ScaleneTriangle extends Triangle implements Operations {
	
	private final int side1;
	private final int side2;
	private final int side3;
	
	/**
	 * the third type of triangle
	 * @param side1 1
	 * @param side2 2
	 * @param side3 3
	 */
	public ScaleneTriangle(int side1, int side2, int side3) {
		super("Scalene");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
	public int computeArea() {
		
		return 0;
	}
	
	@Override
	public int computePerimeter() {
		return side1 + side2 + side3;
	}
}
