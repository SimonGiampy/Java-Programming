package home.inheritance.geometry;

/**
 * triangle with 90 degrees angle
 */
public final class RightTriangle extends Triangle implements Operations {
	
	private final int cathetus1;
	private final int cathetus2;
	private final int hypotenuse;
	
	/**
	 * after construction calculates the area and perimeter
	 * @param cathetus1 1
	 * @param cathetus2 2
	 * @param hypotenuse i
	 */
	protected RightTriangle(int cathetus1, int cathetus2, int hypotenuse) {
		super("RightTriangle");
		this.cathetus1 = cathetus1;
		this.cathetus2 = cathetus2;
		this.hypotenuse = hypotenuse;
		
		setArea(computeArea());
		setPerimeter(computePerimeter());
	}
	
	@Override
	public int computeArea() {
		return cathetus1 * cathetus2 / 2;
	}
	
	@Override
	public int computePerimeter() {
		return cathetus1 + cathetus2 + hypotenuse;
	}
	
	
}
