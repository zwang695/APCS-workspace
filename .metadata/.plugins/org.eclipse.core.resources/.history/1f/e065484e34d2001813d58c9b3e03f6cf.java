package cchen.shapes;

import processing.core.PApplet;


public abstract class Shape2D extends Shape{
	/**
	 * Represents a 2-dimensional shape
	 * @author Claire Chen
	 * @version 10/10/18
	 */
	private boolean filled;
	/**
	 * @param fillR red component of fill color
	 * @param fillG green component of fill color
	 * @param fillB blue component of fill color
	 */
	protected float fillR, fillG, fillB;
	
	/**
	 * Creates 2d shape at given starting coordinate, with white fill
	 * @param x x coordinate of shape
	 * @param y y coordinate of shape
	 */
	public Shape2D(double x, double y) {
		super(x, y);
		filled = true;
		fillR = 255;
		fillG = 255;
		fillB = 255;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return true for filled shape, false for not
	 */
	public boolean getFilled() {
		return this.filled;
	}
	/**
	 * Sets whether shape will be filled or not
	 * @param bool true for filled, false for not filled
	 */
	public void setFilled(boolean bool) {
		filled = bool;
	}
	
	/**
	 * sets fill color
	 * @param r red component of fill color 
	 * @param g green component of fill color
	 * @param b blue component of fill color
	 */
	public void setFill(float r, float g, float b) {
		this.fillR = r;
		this.fillG = g;
		this.fillB = b;
	}
	
	/**
	 * 
	 * @return array with RGB values of fill color
	 */
	public float[] getFill(){
		return new float[]{fillR, fillG, fillB};		
	}
	
	/**
	 * draws the 2d shape to a PApplet
	 * @param p the PApplet the shape will be drawn to
	 */
	public void draw(PApplet p) {
		super.draw(p);
		if(filled)p.fill(getFill()[0], getFill()[1], getFill()[2]);
	}
	
	/**
	 * 
	 * @return perimeter of the 2d shape
	 */
	public abstract double getPerimeter(); // maybe circle and rectangle only? for line it could be length of line

	/**
	 * 
	 * @return area of the 2d shape
	 */
	public abstract double getArea(); // maybe circle and rectangle only
	
	
	/**
	 * checks if point is inside the shape 
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 * @return true if point is inside, false if not
	 */
	public abstract boolean isPointInside(double x, double y); // maybe circle and rectangle only? for line it could be
																// point is on line
}
