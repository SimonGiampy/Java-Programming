package home.inheritance.geometry;

/**
 * represents all triangles
 */
public class Triangle extends Polygon {
	
	protected String type;
	
	/**
	 * Constructor for triangle shapes
	 * @param type string describing the shape
	 */
	public Triangle(String type) {
		super(3, "white");
		this.type = type;
	}
	
}
