package home.tests;

public class IsoscelesTriangle extends Triangle implements Operations{
	
	private final int equalSide;
	private final int baseSide;
	
	private int height = 0;
	
	public IsoscelesTriangle(int equalSide, int baseSide) {
		super("Isosceles");
		this.baseSide = baseSide;
		this.equalSide = equalSide;
	}
	
	@Override
	public int computeArea() {
		return baseSide * height / 2;
	}
	
	@Override
	public int computePerimeter() {
		return baseSide + equalSide * 2;
	}
	
}
