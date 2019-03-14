package zachary.shapes;
import processing.core.PApplet;

/**
 * This class represents a double precision circle, that draws a circle and can calculate basic 
 * properties of the circle, such as circumference and area
 * 
 * @author Zachary Wang
 * @version 10/9/18
 */

public class Circle extends Ellipse{

	private double x, y; //center
	private double radius; 
	
	/**
	 *  Creates a default instance of a Circle object with all dimensions
	 *  set to zero.
	*/
	public Circle() {
		
	}
	
	/**
	 * Creates a new instance of a Circle object with the center at x, y
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param radius radius of the circle
	 */
	public Circle(double x, double y, double radius) {
		super(x, y, radius*2, radius*2);
	}
	
	/**
	 * Creates a new instance of a Circle object with the center at x, y and a certain line thickness
	 * @pre strokeWidth cannot be negative
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param radius radius of the circle
	 * @param strokeWidth thickness of lines
	 */
	public Circle(double x, double y, double radius, int strokeWidth) {
		super(x, y, radius*2, radius*2, strokeWidth);
	}
	
	/**
	 *  Calculates and returns the circumference of the circle
	 * @return the circumference of the circle
	 */
	public double getCircumference() {
		return 2*Math.PI*radius;
	}

	/**
	 *  Determines whether the point x,y is contained inside this circle
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if the point x,y is contained inside, or on the border, of this circle
	 */
	public boolean isPointInside(double x, double y) {
		return Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) < Math.pow(radius, 2) || Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) == Math.pow(radius, 2);
	}
	
}
