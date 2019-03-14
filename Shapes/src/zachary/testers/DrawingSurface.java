package zachary.testers;

import processing.core.PApplet;
import zachary.shapes.*;

public class DrawingSurface extends PApplet{
	
	private RegularPolygon rp;
	
	public DrawingSurface() {
		rp = new RegularPolygon(1, 50);
	}
	
	public void draw() {
		background(255);
		rp.drawBoundingCircles(this);
		rp.draw(this);
	}
}
