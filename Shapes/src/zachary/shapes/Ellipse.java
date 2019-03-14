package zachary.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class represents a double precision ellipse, that draws a ellipse and can calculate basic 
 * properties of the circle, such as circumference and area
 * 
 * @author Zachary Wang
 * @version 10/9/18
 */

public class Ellipse extends Shape2D{
	
	private double width, height;

	/**
	 *  Creates a default instance of a Ellipse object with all dimensions
	 *  set to zero.
	*/
	public Ellipse() {
		super(0, 0);
	}
	
	/**
	 * Creates a new instance of an Ellipse object with the center at x, y
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param width width of ellipse
	 * @param height height of ellipse
	 */
	public Ellipse(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a new instance of an Ellipse object with the center at x, y and a certain line thickness
	 * @pre strokeWidth cannot be negative
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param width width of ellipse
	 * @param height of ellipse
	 * @param strokeWidth thickness of lines
	 */
	public Ellipse(double x, double y, double width, double height, int strokeWidth) {
		super(x, y, strokeWidth);
		this.width = width;
		this.height = height;
	}
	
	/**
	 *  Draws a new instance of an Ellipse object the center at x, y
	 * @param p the reference of the PApplet used to draw the ellipse
	 * @pre p must not be null, and appropriate settings should have been selected (color, fill, etc)
	 * @post p will have its ellipse mode set to center
	 */
	public void draw(PApplet p) {
		super.draw(p);
		p.ellipse((float) x, (float) y, (float) width , (float) height);
	}

	/**
	 *  Calculates and returns the perimeter of the ellipse
	 * @return the perimeter of the ellipse
	 */
	public double getPerimeter() {
		return Math.PI*(3*(width/2 + height/2) - Math.sqrt((3*width/2 + height/2)*(3*height/2 + width/2)));
	}

	/**
	 *  Calculates and returns the area of the ellipse
	 * @return the area of the ellipse
	 */
	public double getArea() {
		return Math.PI*width/2*height/2;
	}

	/**
	 *  Determines whether the point x,y is contained inside this ellipse
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if the point x,y is contained inside, or on the border, of this ellipse
	 */
	public boolean isPointInside(double x, double y) {
		return ((x*x)/(width/2*width/2) + (y*y)/(height/2*height/2)) <= 1;
	}

	/** Returns the center point of the ellipse
	* 
	* @return The center point of the ellipse 
	*/
	public Point2D getCenter() {
		return new Point2D.Double(x, y);
	}

}
