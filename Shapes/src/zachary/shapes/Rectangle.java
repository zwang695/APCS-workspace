package zachary.shapes;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class represents a double precision rectangle, that draws a rectangle and can calculate
 * basic properties of the rectangle, such as finding the area or perimeter.
 * @author Zachary Wang
 * @version 10/9/18
 */

public class Rectangle extends Shape2D{
	
	private double width, height;
	
	/**
	 *  Creates a default instance of a Rectangle object with all dimensions
	 *  set to zero.
	*/
	public Rectangle() {
		super(0, 0);
	}

	/**
	 * Creates a new instance of a Rectangle object with the left and right
	 * edges of the rectangle at x and x + width. The top and bottom edges
	 * are at y and y + height.
	 * @param x x coordinate of top left
	 * @param y y coordinate of top left
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a new instance of a Rectangle object of certain color
	 * with the left and right
	 * edges of the rectangle at x and x + width. The top and bottom edges
	 * are at y and y + height.
	 * @param x x coordinate of top left
	 * @param y y coordinate of top left
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @param fill the color of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height, int[] fill) {
		super(x, y, fill);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a new instance of a Rectangle object
	 * with the left and right
	 * edges of the rectangle at x and x + width. The top and bottom edges
	 * are at y and y + height. The lines are of a certain thickness.
	 * @param x x coordinate of top left
	 * @param y y coordinate of top left
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @param strokeWeight thickness of the lines
	 */
	public Rectangle(double x, double y, double width, double height, int strokeWeight) {
		super(x, y, strokeWeight);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a new instance of a Rectangle object of a certain color
	 * with the left and right
	 * edges of the rectangle at x and x + width. The top and bottom edges
	 * are at y and y + height. The lines are of a certain thickness and a certain color.
	 * @param x x coordinate of top left
	 * @param y y coordinate of top left
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @param fill the color of the rectangle
	 * @param stroke the color of the lines
	 * @param strokeWeight the thickness of the lines
	 */
	public Rectangle(double x, double y, double width, double height, int[] fill, int[] stroke, int strokeWeight) {
		super(x, y, fill, stroke, strokeWeight);
		this.width = width;
		this.height = height;
	}

	/**
	 *  Calculates and returns the perimeter of the rectangle
	 * @return the perimeter of the rectangle
	 */
	public double getPerimeter() {
		return Math.abs(width)*2 + Math.abs(height)*2;
	}

	/**
	 *  Calculates and returns the area of the rectangle
	 * @return the area of the rectangle
	 */
	public double getArea() {
		return Math.abs(width*height);
	}

	/**
	 *  Determines whether the point x,y is contained inside this rectangle
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if the point x,y is contained inside, or on the border, of this rectangle
	 */
	public boolean isPointInside(double x, double y) {
		return x > this.x && x < (this.x + width) && y > this.y && y < (this.y + height);
	}

	/**
	 *  Draws a new instance of a Rectangle object with the left and right
	 *  edges of the rectangle at x and x + width. The top and bottom edges
	 *  are at y and y + height.
	 * @param marker the reference of the PApplet used to draw the rectangle
	 * @pre marker must not be null, and appropriate settings should have been selected (color, fill, etc)
	 * @post the marker will have its rectangle mode modified to PApplet.CORNER 
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rectMode(PApplet.CORNER);
		marker.rect((float)x, (float)y, (float)width, (float)height);
	}

	/**
	 * Calculates and returns the length of the diagonal of the rectangle
	 * @return the length of the diagonal of the rectangle
	 */
	public double getDiagonal() {
		return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
	}
	
	/**
	 * Calculates the area of an ellipse around the rectangle
	 * @return the area of a circumscribed ellipse
	 */
	public double getAreaOfCircumscribedEllipse() {
		return Math.PI*width/2*height/2;
	}
	
	/** Returns the center point of the rectangle
	* 
	* @return The center point of the rectangle 
	*/
	public Point2D.Double getCenter() {
		return new Point2D.Double(x + width/2, y + height/2);
	}
	
	/** Sets the coordinate of the bottom right corner of the Rectangle
	* 
	* @param x the x-coordinate of the new bottom right point
	* @param y the y-coordinate of the new bottom right point
	*/
	public void setBottomRight(double x, double y) {
		width = x-this.x;
		height = y-this.y;
	}

	/** Gets the width.
	 * 
	 * @return X-axis width of the rectangle.
	 */
	public double getWidth() {
		return width;
	}
	
	/** Gets the height.
	 * 
	 * @return Y-axis height of the rectangle.
	 */
	public double getHeight() {
		return height;
	}
	
}
