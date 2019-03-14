package irregularPolygon;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private IrregularPolygon poly;
	
	private int ANIMATION_TIME = 100;
	private float x,y,time;
	
	public DrawingSurface() {
		poly = new IrregularPolygon();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
//		poly.add(new Point2D.Double(20,10));
//		poly.add(new Point2D.Double(70,20));
//		poly.add(new Point2D.Double(50,50));
//		poly.add(new Point2D.Double(0,40));
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		textSize(12);
		
		if (poly != null) {
			poly.draw(this);
		
			fill(0);
			text("Perimeter: " + poly.calcPerimeter() + "\nArea: " + poly.calcArea() + "\nSides: " + poly.findSides(),(float)width/2,(float)20);
			
			pushMatrix();
			strokeWeight(5);
			point((float)poly.getCenter().getX(), (float)poly.getCenter().getY());	
			popMatrix();
			
		}
		if (time > 0) {
			time-=2;
			float size = (float)Math.sin((ANIMATION_TIME-time)/ANIMATION_TIME*Math.PI)*10;
			pushMatrix();
			strokeWeight(1);
			ellipse(x, y, size, size);
			popMatrix();		
		}
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			poly.add(new Point2D.Double(mouseX,mouseY));
			x = mouseX;
			y = mouseY;
			time = ANIMATION_TIME;
		} 
	}
	
	
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_SPACE) {
			poly = new IrregularPolygon();
		} 
	}
	
	
}










