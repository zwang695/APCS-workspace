package zachary.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This abstract class provides definitions for double precision geometric shapes.
 * @author Zachary Wang
 * @version 10/9/18
 * 
 * good style, good comments
 * lots of constructors
 * 
 * no way to change stroke color or fill color later
 * 
 * 
 * need javadoc for protected fields
 * need javadoc for abstract methods 
 * 
 */

public abstract class Shape {

	/**
	 * x coordinate of the shape
	 */
	protected double x;
	
	/**
	 * y coordinate of the shape
	 */
	protected double y;
	
	private int strokeWeight;
	private int[] stroke;
	
	/**
	 * This creates a Shape object with x coordinate x and y coordinate y
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		this.strokeWeight = 1;
		stroke = new int[3];
		stroke[0] = 0;
		stroke[1] = 0;
		stroke[2] = 0;
	}
	
	/**
	 * This creates a Shape object with x coordinate x, y coordinate y, and a certain line color
	 * @pre stroke is an array of size 3 with red in the first index, blue in the second, and green in the third
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param stroke the color of the line
	 */
	public Shape(double x, double y, int[] stroke) {
		this.x = x;
		this.y = y;
		this.strokeWeight = 1;
		this.stroke = stroke;
	}
	
	/**
	 * This creates a Shape object with x coordinate x, y coordinate y, and a certain line thickness
	 * @pre strokeWeight can not be negative
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param strokeWeight the thickness of the line
	 */
	public Shape(double x, double y, int strokeWeight) {
		this.x = x;
		this.y = y;
		this.strokeWeight = strokeWeight;
		stroke = new int[3];
		stroke[0] = 0;
		stroke[1] = 0;
		stroke[2] = 0;
	}
	
	/**
	 * This creates a Shape object with x coordinate x, y coordinate y, a certain line thickness, and a certain line color
	 * @pre stroke is an array of size 3 with red in the first index, blue in the second, and green in the third
	 * @pre strokeWeight can not be negative
	 * @param x x coordinate of the shape
	 * @param y y coordinate of the shape
	 * @param stroke the color of the line
	 * @param strokeWeight the thickness of the line
	 */
	public Shape(double x, double y, int[] stroke, int strokeWeight) {
		this.x = x;
		this.y = y;
		this.strokeWeight = strokeWeight;
		this.stroke = stroke;
	}
	
	/**
	 * Moves the shape's x and y to a new x and y
	 * @param x x coordinate shape is moving to
	 * @param y y coordinate shape is moving to
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the x coordinate of the shape
	 * @return x coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the y coordinate of the shape
	 * @return y coordinate
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the stroke width into a new width
	 * @param x new stroke width
	 */
	public void setStrokeWidth(int x) {
		this.strokeWeight = x;
	}
	
	/**
	 * Prepares the line thickness and color of the shape
	 * @param p the reference of the PApplet used
	 * @pre p must not be null, and appropriate settings should have been selected (color, fill, etc)
	 */
	public void draw(PApplet p) {
		p.strokeWeight(strokeWeight);
		p.stroke(stroke[0], stroke[1], stroke[2]);
	}
	
	/** Returns the center point of the shape
	* 
	* @return The center point of the shape
	*/
	public abstract Point2D getCenter();
	
}
