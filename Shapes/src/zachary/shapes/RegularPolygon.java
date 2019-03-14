package zachary.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class represents a double precision Polygon, that draws a polygon and can calculate basic math about it
 * 
 * @author Zachary Wang
 * @version 10/22/18
 */

public class RegularPolygon extends Shape{
	
	private double numSides;
	private double sideLength;
	
	private Line[] lines;
	
	/**
	 *  Creates a default instance of a RegularPolygon object with all dimensions
	 *  set to zero.
	*/
	public RegularPolygon() {
		super(0, 0);
	}
	   
	public RegularPolygon(int numSides, double sideLength){
		super(200, 150);
		this.numSides = numSides;
		this.sideLength = sideLength;
		double newX = x - sideLength/2;
		double newY = y - calcr();
		lines = new Line[numSides];
		lines[0] = Line.generateLine(newX, newY, 0, sideLength, 1);
		for(int i = 1; i < numSides; i++) {
			lines[i] = Line.generateLine(lines[i-1].getPoint2().getX(), lines[i-1].getPoint2().getY(), (Math.toDegrees(- Math.PI - calcVertexAngle()))*i, sideLength, 1);
		}
	}
	
	/**
	 * Creates a default instance of a RegularPolygon object with a center point x, y, a side length, and a certain number of sides
	 * @param x x coordinate of the RegularPolygon
	 * @param y y coordinate of the RegularPolygon
	 * @param numSides number of sides of the RegularPolygon
	 * @param sideLength side length of the RegularPolygon
	 * @pre numSides has to be more than 2
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x, y);
		this.numSides = numSides;
		this.sideLength = sideLength;
		double newX = x - sideLength/2;
		double newY = y - calcr();
		lines = new Line[numSides];
		lines[0] = Line.generateLine(newX, newY, 0, sideLength, 1);
		for(int i = 1; i < numSides; i++) {
			lines[i] = Line.generateLine(lines[i-1].getPoint2().getX(), lines[i-1].getPoint2().getY(), (Math.toDegrees(- Math.PI - calcVertexAngle()))*i, sideLength, 1);
		}
	}

	/**
	 *  Calculates and returns the perimeter of the RegularPolygon
	 * @return the perimeter of the RegularPolygon
	 */
	public double getPerimeter() {
		return numSides*sideLength;
	}
	
	/**
	 * Calculates and returns the radius of the circumscribed circle
	 * @return the radius of the circumscribed circle
	 */
	public double calcR() {
		return .5*sideLength*(1/Math.sin(Math.PI/numSides));
	}

	/**
	 * Calculates and returns the radius of the inscribed circle
	 * @return the radius of the inscribed circle
	 */
	public double calcr() {
		return .5*sideLength*(1/Math.tan(Math.PI/numSides));
	}
	
	/**
	 * Calculates and returns the area of the RegularPolygon
	 * @return the area of the RegularPolygon
	 */
	public double getArea() {
		return .5*numSides*calcR()*calcR()*Math.sin(2*Math.PI/numSides);
	}
	
	/**
	 * Calculates and returns the angle of the vertex of the RegularPolygon
	 * @return the angle of the vertex of the RegularPolygon
	 */
	public double calcVertexAngle(){
		return (numSides-2)*Math.PI/numSides;
	}

	/**
	 * Returns the number of sides
	 * @return the number of sides
	 */
	public double getNumSides() {
		return numSides;
	}
	
	/**
	 * Returns the side length
	 * @return the side length
	 */
	public double getSideLength() {
		return sideLength;
	}
	
	/**
	 *  Draws a new instance of a RegularPolygon object with lines
	 * @param marker the reference of the PApplet used to draw the RegularPolygon
	 * @pre marker must not be null, and appropriate settings should have been selected (color, fill, etc)
	 */
	public void draw(PApplet p) {
		for(int i = 0; i < numSides; i++) lines[i].draw(p);
	}
	
	/**
	 *  Draws the inscribed and circumscribed circles of the RegularPolygon
	 * @param marker the reference of the PApplet used to draw the circles
	 * @pre marker must not be null, and appropriate settings should have been selected (color, fill, etc)
	 */
	public void drawBoundingCircles(PApplet p) {
		(new Circle(x, y, calcR())).draw(p);
		(new Circle(x, y, calcr())).draw(p);
	}
	
	public Point2D getCenter() {
		return new Point2D.Double(x, y);
	}

}
