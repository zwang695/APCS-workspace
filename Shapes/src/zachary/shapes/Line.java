package zachary.shapes;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class represents a double precision line, that draws a line and can calculate whether it 
 * intersects with another line
 * 
 * @author Zachary Wang
 * @version 10/22/18
 */

public class Line extends Shape{

	private double x2, y2;
	
	/**
	 * Creates a new instance of the line object with the first drawn point having coordinates
	 * x1, y1, and the second drawn point having coordinates x2, y2 and a given line thickness
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the first point
	 * @param x2 x coordinate of the second point
	 * @param y2 y coordinate of the second point
	 * @param strokeWidth thickness of the line
	 */
	public Line(double x1, double y1, double x2, double y2, int strokeWidth) {
		super(x1, y1, strokeWidth);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Creates a new instance of the line object with the first drawn point having coordinates
	 * x1, y1, and the second drawn point having coordinates x2, y2 and given thickness and color
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the first point
	 * @param x2 x coordinate of the second point
	 * @param y2 y coordinate of the second point
	 * @param strokeWidth thickness of the line
	 * @param stroke color of the line
	 */
	public Line(double x1, double y1, double x2, double y2, int strokeWidth, int[] stroke) {
		super(x1, y1, stroke, strokeWidth);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Generates a new instance of the line object with the first drawn point having coordinates
	 * x1, y1, and the second drawn calculated point having coordinates x2, y2 from a given angle and length and given line thickness
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the first point
	 * @param angle angle of the line 
	 * @param length length of the line
	 * @param strokeWidth thickness of the line
	 */
	public static Line generateLine(double x1, double y1, double angle, double length, int strokeWidth) {
		return new Line(x1, y1, x1 + length*Math.cos(Math.toRadians(angle)), y1 + length*Math.sin(Math.toRadians(angle)), strokeWidth);
	}

	/**
	 * This takes in the point x2, y2 and sets the second point as it
	 * @param x2 x coordinate of the second point
	 * @param y2 y coordinate of the second point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/** Returns the second point of the line
	 * 
	 * @return The second point of the line
	 */
	public Point2D.Double getPoint2() {
		return new Point2D.Double(x2, y2);
	}
	
	/**
	 *  Draws a new instance of a Line object with the first point at x1, y1
	 *  and the second point at x2, y2
	 * @param p the reference of the PApplet used to draw the circle
	 * @pre p must not be null, and appropriate settings should have been selected (color, fill, etc)
	 */
	public void draw(PApplet p) {
		p.pushMatrix();
		super.draw(p);
		p.line((float) x,(float) y,(float) x2,(float) y2);
		p.popMatrix();
	}
	
	/**
	 * Determines whether this line intersects with another line
	 * @param other the reference of the other line we are testing
	 * @return true if the lines intersect
	 */
	public boolean intersects(Line other) {
		double intersectX = getIntersectX(other);
		double intersectY = getIntersectY(other);
		if(intersectX == Double.MAX_VALUE || intersectY == Double.MAX_VALUE) {
			System.out.println("same");
			return false;
		}
		
		if(isBetween(intersectX, x, x2) &&
		   isBetween(intersectX, other.x, other.x2) &&
		   isBetween(intersectY, y, y2) &&
		   isBetween(intersectY, other.y, other.y2)) return true;
		return false;
	}
	
	private boolean isBetween(double pt, double x1, double x2) {
		if(pt >= x1 && pt <= x2) return true;
		else if(pt <= x1 && pt >= x2) return true;
		else return false;
	}
	
	private double getIntersectX(Line other) {
		try {
			double x3 = other.x;
			double x4 = other.x2;
			double y3 = other.y;
			double y4 = other.y2;
			double num = (x * y2 - y * x2)*(x3 - x4) - (x - x2)*(x3 * y4 - y3 * x4);
			double denom = (x - x2)*(y3 - y4) - (y - y2)*(x3 - x4);
			return num/denom;
		}
		catch(Exception e) {
			System.out.println(1);
			return Double.MAX_VALUE;
		}
	}
	
	private double getIntersectY(Line other) {
		try {
			double x3 = other.x;
			double x4 = other.x2;
			double y3 = other.y;
			double y4 = other.y2;
			double num = (x * y2 - y * x2)*(y3 - y4) - (y - y2)*(x3 * y4 - y3 * x4);
			double denom = (x - x2)*(y3 - y4) - (y - y2)*(x3 - x4);
			return num/denom;
		}
		catch(Exception e) {
			System.out.println(2);
			return Double.MAX_VALUE;
		}
	}
	
	/** Returns the center point of the line
	* 
	* @return The center point of the line
	*/
	public Point2D getCenter() {
		return new Point2D.Double((x+x2)/2, (y+y2)/2);
	}
}
