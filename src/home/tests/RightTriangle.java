package home.tests;

public final class RightTriangle extends Triangle implements Operations {
	
	private final int cathetus1;
	private final int cathetus2;
	private final int hypotenuse;
	
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
