package home.inheritance.geometry;

/**
 * another interface with more methods than operations, specific for another class of shapes
 */
 interface Calculations extends Operations {
	/**
	 * this functions checks whether the sizes in input may compose a real triangle
	 * @param side1 dimension of first side
	 * @param side2 dimension of second side
	 * @param side3 dimension of third side
	 * @return boolean value for the validity of the input numbers
	 */
	boolean checkValidity(int side1, int side2, int side3);
}
