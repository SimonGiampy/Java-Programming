package home.inheritance.geometry;

/**
 * represents isosceles triangles
 */
 class IsoscelesTriangle extends Triangle implements Calculations {
	
	private final int equalSide;
	private final int baseSide;
	
	private int height = 0;
	
	/**
	 * constructor for this shape
	 * @param equalSide the two equal sides
	 * @param baseSide the base of the triangle
	 */
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
	
	/**
	 * this functions checks whether the sizes in input may compose a real triangle
	 * @param side1 dimension of first side
	 * @param side2 dimension of second side
	 * @param side3 dimension of third side
	 * @return boolean value for the validity of the input numbers
	 */
	@Override
	public boolean checkValidity(int side1, int side2, int side3) {
		return (side1 < side2 + side3) && (side2 < side1 + side3) && (side3 < side1 + side2);
	}
}
