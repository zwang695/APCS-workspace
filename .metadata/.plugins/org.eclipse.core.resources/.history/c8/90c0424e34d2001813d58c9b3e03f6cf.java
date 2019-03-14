package cchen.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/*
 * +
 * Great methods in Shape class - good choices
 * Great job making Shape2D class
 * -
 * you probably shouldn't put fill inside Shape as you can't fill a shape
 * also javadoc your protected values
 * delta
 * try moving fill into shape2D
 */

public abstract class Shape {
	/**
	 * This class represents a Shape with a starting coordinate and certain outline
	 * colors.
	 * 
	 * @author Claire Chen
	 * @version 10/10/18
	 */

	// Fields
	/**
	 * @param strokeR red value for stroke color
	 * @param strokeG green value for stroke color
	 * @param strokeB blue value for stroke color
	 */
	private float strokeWeight;
	protected float strokeR, strokeG, strokeB; // color values
	/**
	 * @param x1 x-coordinate of shape
	 * @param y1 y-coordinate of shape
	 */
	protected double x1, y1;

	/**
	 * Creates a new Shape object with black outline
	 * 
	 * @param x x-coordinate of shape
	 * @param y y-coordinate of shape
	 */
	public Shape(double x, double y) {
		this.x1 = x;
		this.y1 = y;
		strokeWeight = 1;
		strokeR = 0;
		strokeG = 0;
		strokeB = 0;
	}

	// Methods

	/**
	 * Sets stroke width of the shape
	 * 
	 * @param x How wide (in pixels) the stroke will be
	 */
	public void setStrokeWeight(int x) {
		strokeWeight = x;
	}

	/**
	 * @return the stroke width
	 */
	public float getStrokeWeight() {
		return strokeWeight;
	}

	/**
	 * Moves the shape by the given amount
	 * 
	 * @param x amount the shape will be translated horizontally by
	 * @param y amount the shape will be translated vertically by
	 */
	public void move(double x, double y) {
		this.x1 = x;
		this.y1 = y;
	}

	/**
	 * 
	 * @return x coordinate of shape
	 */
	public double getX() {
		return this.x1;
	}

	/**
	 * 
	 * @return y coordinate of shape
	 */
	public double getY() {
		return this.y1;
	}

	/**
	 * Set stroke color of shape
	 * 
	 * @param r value for stroke color
	 * @param g green value for stroke color
	 * @param b blue value for stroke color
	 */
	public void setStroke(float r, float g, float b) {
		this.strokeR = r;
		this.strokeG = g;
		this.strokeB = b;
	}

	/**
	 * 
	 * @return an array containing the RGB values of the stroke color
	 */
	public float[] getStroke() {
		return new float[] { strokeR, strokeG, strokeB };
	}

	/**
	 * Draws the shape to a PApplet
	 * @param p the PApplet used to draw the shape
	 */
	public void draw(PApplet p) {
		p.strokeWeight(strokeWeight);
		p.stroke(getStroke()[0], getStroke()[1], getStroke()[2]);
	};

	public abstract Point2D.Double getCenter();

}
