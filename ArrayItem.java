/**
 * This class is part of Lab 2 for ITSC 2214: Data Structures.
 * An ArrayItem object stores the color and ID that are read from the input files. ArrayItem objects are
 * stored in the two arrays in the Main class.
 */
public class ArrayItem implements Comparable<ArrayItem> {
	private String color;
	private Integer id;
	
	/**
	 * A constructor for the ArrayItem class that sets the attributes to the parameters.
	 * @param color
	 * @param id
	 */
	public ArrayItem(String color, Integer id) {
		this.color = color;
		this.id = id;
	}
	
	/**
	 * Returns a formatted string that represents an ArrayItem object.
	 * @return string containing the color and id attributes.
	 */
	@Override
	public String toString() {
		return "Color: " + color + "\tID: " + id;
	}
	
	
	/**
	 * Compares this ArrayItem to another ArrayItem object based on their IDs.
	 * @return a number >0 if this item is greater, <0 if less than, 0 if both are equal.
	 */
	@Override
	public int compareTo(ArrayItem other) {
		return Integer.compare(this.id, other.id);
	}
}
