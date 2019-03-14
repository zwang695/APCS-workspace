package cchen.shapes;

import java.awt.geom.Point2D;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import java.awt.Color;
import processing.core.PApplet;

public class Rectangle extends Shape2D {

	/**
	 * This class represents a double-precision rectangle. It can do common
	 * calculations and draw a representation of the rectangle to a Processing
	 * PApplet.
	 *
	 * @author Claire Chen
	 * 
	 * @version 08 Oct 2018
	 * 
	 */

	private double width, height, rotation;
	/**
	 * Creates a default instance of a Rectangle object with all dimensions set to
	 * zero.
	 */
	public Rectangle() {
		super(0, 0);
		transform(0.0D, 0.0D, 0.0D, 0.0D);
	}

	/**
	 * Creates a new Rectangle object with the left and right edges of the rectangle
	 * at x and x + width. The top and bottom edges are at y and y + height.
	 * 
	 * @param x      x-coordinate of the upper left corner of the rectangle
	 * 
	 * @param y      y-coordinate of the upper left corner of the rectangle
	 * 
	 * @param width  width of the rectangle
	 * 
	 * @param height height of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		transform(x, y, width, height);
	}

	/**
	 * Translates and scales the rectangle
	 * @param x Amount to move x by
	 * @param y Amount to move y by
	 * @param width Amount to scale width by
	 * @param height AMount to scale height by
	 */
	public void transform(double x, double y, double width, double height) {
		setLocation(x, y);
		setScale(width, height);
	}

	/**
	 * Sets location of rectangle
	 * @param x x coord of new location
	 * @param y y coord of new location
	 */
	public void setLocation(double x, double y) {
		x1 = x;
		y1 = y;
	}

	/**
	 * set amount to scale rectangle by
	 * @param width amount to scale width
	 * @param height amount to scale height by
	 */
	public void setScale(double width, double height) {
		this.width = width;
		this.height = height;
	}


	/** 
	 * @return the perimeter of the rectangle
	 */
	
	public double getPerimeter() {
		return 2.0D * (this.width + this.height);
	}
	
	/**
	 * @return area of rectangle
	 */
	public double getArea() {
		return this.width * this.height;
	}

	/**
	 * 
	 * @return width of rectangle
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @return height of rectangle
	 */
	public double getHeight() {
		return this.height;
	}

	
	/**
	 * checks if point is inside the shape 
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 * @return true if point is inside, false if not
	 */
	public boolean isPointInside(double x, double y) {
		if ((inbetween(x, this.x1, this.x1 + this.width)) && (inbetween(y, this.y1, this.y1 + this.height))) {
			return true;
		}
		return false;
	}

	/**
	 * checks if 2 rectangles are congruent
	 * @param other rectangle to compare with this one
	 * @return true if congruent, false if not
	 */
	public boolean isCongruentTo(Rectangle other) {
		if ((Math.abs(this.width - other.width) < 1.0E-5D) && (Math.abs(this.height - other.height) < 1.0E-5D)) {
			return true;
		}
		if ((Math.abs(this.width - other.height) < 1.0E-5D) && (Math.abs(this.height - other.width) < 1.0E-5D)) {
			return true;
		}
		return false;
	}

	/**
	 * checks if 2 rectangles are similar
	 * @param other rectangle to compare
	 * @return true if similar, false if not
	 */
	public boolean isSimilarTo(Rectangle other) {
		if (Math.abs(this.width / other.width - this.height / other.height) < 1.0E-5D) {
			return true;
		}
		if (Math.abs(this.width / other.height - this.height / other.width) < 1.0E-5D) {
			return true;
		}
		return false;
	}

	/**
	 * draws this rectangle to a PApplet
	 * @param p PApplet to draw the rectangle to
	 */
	public void draw(PApplet g) {
		this.getStroke();
		g.stroke(getStroke()[0], getStroke()[1], getStroke()[2]);
		if (this.getFill() != null) {
			g.pushStyle();
			g.stroke(this.getFill()[0], this.getFill()[1], this.getFill()[2]);
			g.fill(this.getFill()[0], this.getFill()[1], this.getFill()[2]);
			g.rect((float) this.x1, (float) this.y1, (float) this.width, (float) this.height);
			g.popStyle();
		}
	}


	private boolean inbetween(double x, double min, double max) {
		if (((x >= min) && (x <= max)) || ((x <= min) && (x >= max))) {
			return true;
		}
		return false;
	}

	public Point2D.Double getCenter() {
		return new Point2D.Double(x1 + width / 2, y1 + height / 2);
	}

	public void setBottomRight(double x, double y) {
		width = x - this.x1;
		height = y - this.y1;
	}

}

/*
 * public class Rectangle {
 * 
 * /** This class represents a double-precision rectangle. It can do common
 * calculations and draw a representation of the rectangle to a Processing
 * PApplet.
 *
 * @author Claire Chen
 * 
 * @version 26 Sept 2018
 * 
 */
/*
 * private double x, y, width, height, scaleBy;
 * 
 * /** Creates a default instance of a Rectangle object with all dimensions set
 * to zero.
 *//*
	 * public Rectangle() { scaleBy = 1.0D; x = 0; y = 0; width = 0; height = 0; }
	 * 
	 * /** Creates a new Rectangle object with the left and right edges of the
	 * rectangle at x and x + width. The top and bottom edges are at y and y +
	 * height.
	 * 
	 * @param x x-coordinate of the upper left corner of the rectangle
	 * 
	 * @param y y-coordinate of the upper left corner of the rectangle
	 * 
	 * @param width width of the rectangle
	 * 
	 * @param height height of the rectangle
	 *//*
		 * public Rectangle(double x, double y, double width, double height) { scaleBy =
		 * 1.0D; this.x = x; this.y = y; this.width = width; this.height = height; }
		 * 
		 * /** Calculates and returns the perimeter of the rectangle
		 * 
		 * @return the perimeter of the rectangle
		 *//*
			 * public double getPerimeter() { return 2 * Math.abs(width) + 2 *
			 * Math.abs(height); }
			 * 
			 * /** Calculates and returns the area of the rectangle
			 * 
			 * @return the area of the rectangle
			 *//*
				 * public double getArea() { return Math.abs(width) * Math.abs(height); }
				 * 
				 * /** Determines whether the point x,y is contained inside this rectangle
				 * 
				 * @param x the x-coordinate of the point to check
				 * 
				 * @param y the y-coordinate of the point to check
				 * 
				 * @return true if (x,y) is inside or on the perimeter of the rectangle.
				 *//*
					 * public boolean isPointInside(double x, double y) { return (x >= this.x && y
					 * >= this.y && x <= this.x + width && y <= this.y + height); }
					 * 
					 * /** Draws a new instance of a Rectangle object with the dimensions provided
					 * 
					 * @param drawer the PApplet that will be used to draw the rectangle
					 * 
					 * @pre drawer can't be null, and color, fill, etc. settings need to have been
					 * set
					 *//*
						 * public void draw(PApplet marker) { marker.scale((float) scaleBy, (float)
						 * scaleBy); marker.rect((float) (this.x), (float) (this.y), (float)
						 * (this.width), (float) (this.height)); }
						 * 
						 * public boolean areCongruent(Rectangle r2) { if ((this.width == r2.width) &&
						 * (this.height == r2.height)) return true; else return false; }
						 * 
						 * /** Changes the scale factor of the rectangle
						 * 
						 * @param The amount to scale the rectangle by
						 *//*
							 * public void increaseScale(double amount) { scaleBy += amount; }
							 * 
							 * /** Returns the center point of the rectangle
							 * 
							 * @return The center point of the rectangle
							 *//*
								 * public Point2D.Double getCenter() { return new Point2D.Double(x + width / 2,
								 * y + height / 2); }
								 * 
								 * /** Sets the coordinate of the bottom right corner of the rectangle
								 * 
								 * @param x the x-coordinate of the new bottom right point
								 * 
								 * @param y the y-coordinate of the new bottom right point
								 *//*
									 * public void setBottomRight(double x, double y) { width = x - this.x; height =
									 * y - this.y; }
									 * 
									 * }
									 */
