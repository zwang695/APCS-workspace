package zachary.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This abstract class provides definitions for double precision geometric 2D shapes.
 * @author Zachary Wang
 * @version 10/9/18
 */

public abstract class Shape2D extends Shape{

	private int[] fill;
	
	/**
	 * This creates a 2D Shape object with x coordinate x and y coordinate y
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 */
	public Shape2D(double x, double y) {
		super(x, y);
		fill = new int[3];
		fill[0] = 255;
		fill[1] = 255;
		fill[2] = 255;
	}
	
	/**
	 * This creates a 2D Shape object with x coordinate x, y coordinate y, and a certain fill color
	 * @pre fill is an array of size 3 with red in the first index, blue in the second, and green in the third
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param fill the color of the shape
	 */
	public Shape2D(double x, double y, int[] fill) {
		super(x, y);
		this.fill = fill;
	}
	
	/**
	 * This creates a 2D Shape object with x coordinate x, y coordinate y, and a certain line thickness
	 * @pre strokeWeight can not be negative
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param strokeWeight the thickness of the line
	 */
	public Shape2D(double x, double y, int strokeWeight) {
		super(x, y, strokeWeight);
	}

	/**
	 * This creates a 2D Shape object with x coordinate x, y coordinate y, a fill color, a certain line thickness, and a certain line color
	 * @pre stroke and fill are arrays of size 3 with red in the first index, blue in the second, and green in the third
	 * @pre strokeWeight can not be negative
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param stroke the color of the line
	 * @param strokeWeight the thickness of the line
	 * @param fill the color of the shape
	 */
	public Shape2D(double x, double y, int[] fill, int[] stroke, int strokeWeight) {
		super(x, y, stroke, strokeWeight);
		this.fill = fill;
	}
	
	/**
	 * Prepares the shape ill color
	 * @param p the reference of the PApplet used
	 * @pre p must not be null, and appropriate settings should have been selected (color, fill, etc)
	 */
	public void draw(PApplet p) {
		super.draw(p);
		p.fill(fill[0], fill[1], fill[2]);
	}

	/**
	 *  Calculates and returns the perimeter of the shape
	 * @return the perimeter of the shape
	 */
	public abstract double getPerimeter();
		
	/**
	 *  Calculates and returns the area of the shape
	 * @return the area of the shape
	 */
	public abstract double getArea();
		
	/**
	 *  Determines whether the point x,y is contained inside this shape
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if the point x,y is contained inside, or on the border, of this shape
	 */
	public abstract boolean isPointInside(double x, double y);

}
