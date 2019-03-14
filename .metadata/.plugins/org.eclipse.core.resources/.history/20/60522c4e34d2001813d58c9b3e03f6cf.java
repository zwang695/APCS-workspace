package cchen.shapes;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Circle extends Shape2D {
	/**
	 * This class represents a double-precision circle. 
	 * It can do common calculations, as well as drawing a representation of the circle
	 * to a Processing PApplet.
	 * @author C Chen
	 * @version Sept 23 2018
	 * 
	 */
	private double radius, scaleBy;

	/**
	 * Creates a new Circle object with center (0,0) and radius 0.
	 */
	public Circle() {
		super(0, 0);
		scaleBy = 1.0D;
		radius = 0;
	}

	/**
	 * Creates a new Circle object with center of (xC, yC) and radius r. 
	 * 
	 * @param xC      x-coordinate of the circle's center
	 * @param yC      y-coordinate of the circle's center
	 * @param r		  radius of the circle
	 */
	public Circle(double xC, double yC, double r) {
		super(xC, yC);
		scaleBy = 1.0D;
		radius = r;
	}

	/**
	 * Calculates the circumference of the circle
	 * 
	 * @return the circumference 
	 */
	public double getPerimeter() {
		return 2 * Math.abs(radius) * Math.PI;
	}

	/**
	 * Calculates the area of the circle
	 * 
	 * @return the area
	 */
	public double getArea() {
		return Math.PI * Math.abs(radius) * Math.abs(radius);
	}

	/**
	 * Determines whether the point x,y is inside this circle 
	 * 
	 * @param x the x-coordinate of the point to check
	 * @param y the y-coordinate of the point to check
	 * @return true if (x,y) is in or on the circumference of the
	 *         circle
	 */
	public boolean isPointInside(double x, double y) {
		if ((x - this.x1) * (x - this.x1) + (y - this.y1) * (y - this.y1) <= radius * radius)
			return true;
		else
			return false;
	}

	/** Draws a new instance of a Circle object with the dimensions provided
	* @param drawer the PApplet that will be used to draw the circle
	*/
	public void draw(PApplet marker) {
		marker.stroke(this.getFill()[0], this.getFill()[1], this.getFill()[2]);
		marker.fill(this.getFill()[0], this.getFill()[1], this.getFill()[2]);
		marker.strokeWeight(this.getStrokeWeight());
		marker.scale((float) scaleBy, (float) scaleBy);
		marker.ellipse((float) (this.x1), (float) (this.y1), (float) (this.radius), (float) (this.radius));
	}

	/**Checks if this circle and another are congruent
	 * 
	 * @param c2
	 * @return whether the circles are congruent
	 */
	public boolean areCongruent(Circle c2) {
		if (this.radius == c2.radius)
			return true;
		else
			return false;

	}
	


	/** Changes the scale factor of the circle
	 * 
	 * @param The amount to scale the circle by
	 */
	public void increaseScale(double amount) {
		scaleBy += amount;
	}

	@Override
	public Double getCenter() {
		// TODO Auto-generated method stub
		return new Point2D.Double(x1, y1);
	}
	

}
