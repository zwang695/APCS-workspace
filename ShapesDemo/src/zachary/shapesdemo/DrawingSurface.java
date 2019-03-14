package zachary.shapesdemo;
import java.util.ArrayList;

import cchen.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{

	private PhysicsShape circles[];
	private ArrayList<Line> lines;
	
	public DrawingSurface() {
		lines = new ArrayList<Line>();
		circles = new PhysicsShape[1000];
	}
	
	public void draw() {
		background(255);
		createCircles();
		for(int i = 0; i < circles.length; i++) {
			if(circles[i] != null && circles[i].getShape() != null) {
				circles[i].draw(this);
				circles[i].act(lines);
			}
		}
		for(Line l : lines) {
			l.setStrokeWeight(3);
			l.draw(this);
		}
	}
	
	public void createCircles() {
		if(Math.random()>0.5) return;
		
		for(int i = 0; i < circles.length; i++) {
			if(circles[i] == null || circles[i].getShape() == null) {
				double x = Math.random() * 390;
				circles[i] = new PhysicsShape(new Circle(x, -5, 10));
				return;
			}
		}
	}
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			lines.add(new Line(mouseX,mouseY,mouseX,mouseY));
		} else if (mouseButton == RIGHT) {
			if(lines.size() > 0) lines.remove((lines.size()-1));
		}
	}
	
	public void mouseDragged() {
		if(lines.size() > 0) (lines.get(lines.size()-1)).setPoint2(mouseX, mouseY);
	}
	
}
