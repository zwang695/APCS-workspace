package cchen.testers;

import java.awt.Color;
import java.awt.geom.Point2D;

import cchen.shapes.*;
import processing.core.PApplet;

import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private Rectangle r1, r2, r3;
	private Line_Original l1;
	private Circle c1, c2, c3;
	private boolean clickC, clickR;

	public DrawingSurface() {
		r1 = null;
		r2 = null;
		c1 = new Circle();
		c2 = new Circle(100, 100, 50);
		c3 = new Circle(500, 230, 122);
		l1 = new Line_Original(200, 300, 50, 50);
	}

	public void setup() {

	}

	
	/**
	 * Draws rectangles and circle to this PApplet
	 */
	public void draw() {
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		if (r1 != null) {
			stroke(180,0,200);
			r1.setFill((float)(Math.random() * 255),(float)(Math.random() * 255),(float)(Math.random() * 255));
			r1.draw(this);
			Point2D.Double center = r1.getCenter();
			fill(0);
			text(r1.getPerimeter()+"\n"+r1.getArea(),(float)center.x,(float)center.y);
		}
		if (r2 != null) {
			stroke(10,150,130);
			r2.setFill((float)(Math.random() * 255),(float)(Math.random() * 255),(float)(Math.random() * 255));
			r2.draw(this);
			Point2D.Double center = r2.getCenter();
			fill(0);
			text(r2.getPerimeter()+"\n"+r2.getArea(),(float)center.x,(float)center.y);
		}
		if (r3 != null) {
			stroke(0, 0, 255);
			r3.draw(this);
		}
		if(l1 != null) {
			stroke(0, 0, 0);
			l1.draw(this);
		}
		if (c1 != null) {
			stroke(0, 255, 0);
			c1.draw(this);
		}
		if (c2 != null) {
			c2.setFill((float)(Math.random() * 255),(float)(Math.random() * 255),(float)(Math.random() * 255));
			c3.draw(this);
		}

		if (c3 != null) {
			c3.setFill((float)(Math.random() * 255),(float)(Math.random() * 255),(float)(Math.random() * 255));
			stroke(0, 255, 0);
			c3.draw(this);
		}

		fill(0);
		textSize(12);
	}

	/** New rectangle is created when mouse is pressed, with mouse position as top left corner
	 * 
	 */
	public void mousePressed() {
		if (mouseButton == LEFT) {
			r1 = new Rectangle(mouseX,mouseY,0,0);
		} else if (mouseButton == RIGHT)
			r2 = new Rectangle(mouseX,mouseY,0,0);
	}
	
	/** Sets bottom right corner of rectangle to location of the mouse when dragged
	 * 
	 */
	public void mouseDragged() {
		if (mouseButton == LEFT) {
			r1.setBottomRight(mouseX,mouseY);
		} else if (mouseButton == RIGHT)
			r2.setBottomRight(mouseX,mouseY);
	}
	
}
