import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import processing.core.PApplet;

public class House{
//+ The comments are clear and concise
//- The "PApplet p" parameter in the constructor is unused and therefore unnecessary
//Delta Change line 20 to "public House() {"
	private float scaleFactor;
	private float x, y;
	private float rX2, rY2, rX3, rY3; //roof dimensions - point 1 has the same location as bX/bY
	private float bX, bY, bW, bH; //main building dimensions
	private float dX, dY, dW, dH; //door dimensions
	private float wR; //window length/width
	private float wY, wX1, wX2; //window dimensions
	
	private float c1, c2, c3;
	
	private Line l1, l2, l3, l4;
	
	public House(PApplet p) {
		scaleFactor = 1;
	
		x = p.width*2f;
		y = p.height*1.4f;
		
		bX = 100f;  
		bY = 100f;
		rX2 = 300f;
		rY2 = 100f;
		rX3 = 200f;
		rY3 = 75f;
		bW = 200f;
		bH = 100f;
		dX = 185f;
		dY = 160f;
		dW = 30f;
		dH = 40f;
		wR = 30f;
		wY = 120f;
		wX1 = 120f;
		wX2 = 250f;
		
		c1 = 255;
		c2 = 255;
		c3 = 255;
		
	}
	
	public void draw(PApplet p) {
		
		p.pushMatrix();
		
		p.translate(x - p.width*scaleFactor/2, y - p.height*scaleFactor/2);
		p.scale(scaleFactor*p.width/DrawingSurface.sWidth, scaleFactor*p.height/DrawingSurface.sHeight);
		
		//roof
		p.triangle(bX, bY, rX2, rY2, rX3, rY3);
		//main building
		p.fill(c1, c2, c3);
		p.stroke(255);
		p.rect(bX, bY, bW, bY);
		p.stroke(0);
		p.fill(255);
		//door
		p.rect(dX, dY, dW, dH);
		//window right
		p.rect(wX1, wY, wR, wR);
		//window left
		p.rect(wX2, wY, wR, wR);
		p.popMatrix();
		
		l1 = new Line(-100 * scaleFactor * p.width/DrawingSurface.sWidth + x, -50 * scaleFactor * p.height/DrawingSurface.sHeight + y, -100 * scaleFactor * p.width/DrawingSurface.sWidth + x, 50 * scaleFactor * p.height/DrawingSurface.sHeight + y);
		l2 = new Line(-100 * scaleFactor * p.width/DrawingSurface.sWidth + x, 50 * scaleFactor * p.height/DrawingSurface.sHeight + y, 100 * scaleFactor * p.width/DrawingSurface.sWidth + x, 50 * scaleFactor * p.height/DrawingSurface.sHeight + y);
		l3 = new Line(-100 * scaleFactor * p.width/DrawingSurface.sWidth + x, -50 * scaleFactor * p.height/DrawingSurface.sHeight + y, 100 * scaleFactor * p.width/DrawingSurface.sWidth + x, -50 * scaleFactor * p.height/DrawingSurface.sHeight + y);
		l4 = new Line(100 * scaleFactor * p.width/DrawingSurface.sWidth + x, -50 * scaleFactor * p.height/DrawingSurface.sHeight + y, 100 * scaleFactor * p.width/DrawingSurface.sWidth + x, 50 * scaleFactor * p.height/DrawingSurface.sHeight + y);
		p.strokeWeight(3);
		l1.draw(p);
		l2.draw(p);
		l3.draw(p);
		l4.draw(p);
		p.strokeWeight(1);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void resize(float add) {
		scaleFactor+=add;
	}
	
	public Line getl1() {
		return l1;
	}
	
	public Line getl2() {
		return l2;
	}
	
	public Line getl3() {
		return l3;
	}
	
	public Line getl4() {
		return l4;
	}
	
	public void setColor(float c1, float c2, float c3) {
		this.c1 = c1;
		this.c2 = c2; 
		this.c3 = c3;
	}
	
}
