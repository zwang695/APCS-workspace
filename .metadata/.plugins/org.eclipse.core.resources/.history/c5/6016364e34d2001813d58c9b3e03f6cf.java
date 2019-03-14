package cchen.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * Represents line segments. This is my original Line class.
 * 
 * @author ClaireC
 * @version 9 Sept 2018
 */
public class Line_Original extends Shape {

	private double x2, y2;

	/**
	 * Creates an object representing a line segment of 0 length, at (0,0).
	 */
	public Line_Original() {
		super(0, 0);
		this.y1 = 0;
		this.y2 = 0;
	}

	/**
	 * Creates an object representing a line segment with endpoints (x1, y1) and
	 * (x2, y2).
	 * 
	 * @param x1 The x-coordinate of the 1st endpoint
	 * @param y1 The y-coordinate of the 1st endpoint
	 * @param x2 The x-coordinate of the 2nd endpoint
	 * @param y2 The y-coordinate of the 2nd endpoint
	 */

	public Line_Original(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Generates line segment starting at (x1, y1), but with a given length and
	 * angle above the horizontal.
	 * 
	 * @param x1    The x-coordinate of the 1st endpoint
	 * @param y1    The y-coordinate of the 1st endpoint
	 * @param theta Angle above the horizontal of this line
	 * @length Length of the segment
	 */
	public void generateDegreeLengthLine(double x1, double y1, double theta, double length) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + length * Math.cos(theta);
		this.y2 = y1 + length * Math.sin(theta);
	}

	/**
	 * Draws a representation of this Line object to a Processing PApplet
	 * 
	 * @param drawer The PApplet used to draw the Line object
	 */
	public void draw(PApplet p) {
		this.getStroke();
		p.stroke(getStroke()[0], getStroke()[1], getStroke()[2]);
		p.line((float) (this.x1), (float) (this.y1), (float) (this.x2), (float) (this.y2));

	}

	/**
	 * Sets the endpoints of the Line to the given endpoints
	 * @param x1 The x-coordinate of the 1st endpoint
	 * @param y1 The y-coordinate of the 1st endpoint
	 * @param x2 The x-coordinate of the 2nd endpoint
	 * @param y2 The y-coordinate of the 2nd endpoint
	 */
	public void setPoints(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Calculates and returns the slope of a segment between the given endpoints
	 * 
	 * @param x1 The x-coordinate of the 1st endpoint
	 * @param y1 The y-coordinate of the 1st endpoint
	 * @param x2 The x-coordinate of the 2nd endpoint
	 * @param y2 The y-coordinate of the 2nd endpoint
	 */
	public double slope(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			return Double.MAX_VALUE;
		}
		if (y1 == y2) {
			return 0.0D;
		}
		return (y2 - y1) / (x2 - x1);
	}

	/**
	 * Returns the slope for horizontal and vertical lines
	 * 
	 * @return The slope of the Line. If the Line is vertical (that is, x1 = x2),
	 *         the method returns Double.MAX_VALUE
	 */
	public double slope() {
		if (this.x1 == this.x2) {
			return Double.MAX_VALUE;
		}
		if (this.y1 == this.y2) {
			return 0.0D;
		}
		return (this.y2 - this.y1) / (this.x2 - this.x1);
	}

	/**
	 * Checks if this Line intersects another Line object
	 * 
	 * @param other The Line to check for intersection with
	 * @return true if the Lines intersect, false if otherwise
	 */
	public boolean intersects(Line_Original other) {

		Point2D.Double hit = calculateIntersectionPoint(other);
		if (hit == null)
			return false;

		double bigX = Math.max(x1, x2);
		double bigX2 = Math.max(other.x1, other.x2);
		double upperX = Math.min(bigX, bigX2);

		double smallX = Math.min(x1, x2);
		double smallX2 = Math.min(other.x1, other.x2);
		double lowerX = Math.max(smallX, smallX2);

		double bigY = Math.max(y1, y2);
		double bigY2 = Math.max(other.y1, other.y2);
		double upperY = Math.min(bigY, bigY2);

		double smallY = Math.min(y1, y2);
		double smallY2 = Math.min(other.y1, other.y2);
		double lowerY = Math.max(smallY, smallY2);

		if (lowerX <= hit.x + 0.000001 && hit.x - 0.000001 <= upperX && lowerY <= hit.y + 0.000001
				&& hit.y - 0.000001 <= upperY)
			return true;
		else
			return false;

	}

	/**
	 * Finds and returns intersection point of 2 Lines
	 * 
	 * @param other Line object to check for intersection with
	 * @return intersection point as a Point2D
	 */
	public Point2D.Double calculateIntersectionPoint(Line_Original other) {

		double denom = (x1 - x2) * (other.y1 - other.y2) - (y1 - y2) * (other.x1 - other.x2);
		if (denom == 0)
			return null;

		double xHit = ((x1 * y2 - y1 * x2) * (other.x1 - other.x2)
				- (x1 - x2) * (other.x1 * other.y2 - other.y1 * other.x2)) / denom;
		double yHit = ((x1 * y2 - y1 * x2) * (other.y1 - other.y2)
				- (y1 - y2) * (other.x1 * other.y2 - other.y1 * other.x2)) / denom;

		return new Point2D.Double(xHit, yHit);

	}
	/*
	 * public boolean intersects(Line_Original l2) { // Point-on-point case boolean
	 * isPoint1 = false, isPoint2 = false; if (this.x1 == this.x2 && this.y1 ==
	 * this.y2) isPoint1 = true; if (l2.x1 == l2.x2 && l2.y1 == l2.y2) isPoint2 =
	 * true; if (isPoint1 == true && isPoint2 == true) { if ((this.x1 == l2.x1) &&
	 * (this.y1 == l2.y1) && (this.x2 == l2.x2) && (this.y2 == l2.y2)) return true;
	 * }
	 * 
	 * // We can use properties of determinants to see if the segments do intersect
	 * double determinant = (this.x2 - this.x1) * (l2.y2 - l2.y1) - (this.y2 -
	 * this.y1) * (l2.x2 - l2.x1); if (determinant != 0) { // The Line_Originals
	 * intersect, so we check if intersection point is on both // segments:
	 * 
	 * double determinantu = (l2.x1 - this.x1) * (l2.y2 - l2.y1) - (l2.y1 - this.y1)
	 * * (l2.x2 - l2.x1); double determinantv = (l2.x1 - this.x1) * (this.y2 -
	 * this.y1) - (l2.y1 - this.y1) * (this.x2 - this.x1); if (determinant < 0) { //
	 * Normalise to determinant>0 to simplify the following check. determinant =
	 * -determinant; determinantu = -determinantu; determinantv = -determinantv; }
	 * if (determinantu >= 0 && determinantu <= determinant && determinantv >= 0 &&
	 * determinantv <= determinant) { // Yes intersect return true; } else { // No
	 * intersect return false; } } else { // determinant = 0, so either parallel or
	 * collinear. // TO-DO: check parallel vs collinear return false; } }
	 */

	/**
	 * Sets 2nd endpoint of the Line object.
	 * 
	 * @param x2 x-coordinate of endpoint
	 * @param y2 y-coordinate of endpoint
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Finds and returns the midpoint of the Line.
	 */
	public java.awt.geom.Point2D.Double getCenter() {
		return new Point2D.Double((x1 + x2) / 2.0, (y1 + y2) / 2.0);
	}

}
