package home.inheritance.geometry;

/**
 * This is the parent class which has many subclasses. This exercise is for testing inheritance properties
 * This class contains every field needed for all the geometric shapes implemented in the code
 * @author Simon
 * @version 1.1
 */
public class Polygon {
	
	protected int sidesNumber;
	protected String color;
	private int area;
	private int perimeter;
	
	/**
	 * creates new shape
	 * @param sidesNumber 3 for triangles
	 * @param color random useless attribute
	 */
	public Polygon(int sidesNumber, String color) {
		this.sidesNumber = sidesNumber;
		this.color = color;
		int k = useless(2 , 5); //serves for calling that stupid function
	}
	
	/**
	 * this function serves for no purpose other than testing html formatting for javadoc comments
	 * <p>
	 *     this is one paragraph <a href="www.google.com">this is a link to Google</a>
	 *     <ul>
	 *         <li>first element</li>
	 *         <li>second element</li>
	 *         <li> <b>third bold <i>element</i></b></li>
	 *     </ul>
	 * @param num1 first number
	 * @param num2 second number
	 * @return sum of the two integers
	 */
	private int useless(int num1, int num2) {
		return num1 + num2;
	}
	
	/**
	 * default constructor
	 */
	public Polygon() {
		System.out.println("instantiated polygon\n");
	}
	
	/**
	 * getter
	 * @return value
	 */
	public int getSidesNumber() {
		return sidesNumber;
	}
	
	/**
	 * getter
	 * @return value
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * getter
	 * @return value
	 */
	public int getArea() {
		return area;
	}
	
	/**
	 * setter
	 * @param area value
	 */
	public void setArea(int area) {
		this.area = area;
	}
	
	/**
	 * getter
	 * @return value
	 */
	public int getPerimeter() {
		return perimeter;
	}
	
	/**
	 * setter
	 * @param perimeter value
	 */
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
	
	
}
