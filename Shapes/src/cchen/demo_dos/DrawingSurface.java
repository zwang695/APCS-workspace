package cchen.demo_dos;

import java.util.ArrayList;

import cchen.PhysicsShape;
import processing.core.PApplet;
import zachary.shapes.*;

public class DrawingSurface extends PApplet {
	private ArrayList<PhysicsShape> raindrops;
	private ArrayList<Line> lines;
	private Rectangle bounds;
	private static final float SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
	private float scaleX, scaleY;

	public DrawingSurface() {
		this.raindrops = new ArrayList();
		this.lines = new ArrayList();

		this.bounds = new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void setup() {
	}

	public void draw() {
		background(255);

		pushMatrix();

		this.scaleX = (this.width / SCREEN_WIDTH);
		this.scaleY = (this.height / SCREEN_HEIGHT);

		scale(this.scaleX, this.scaleY);
		for (PhysicsShape s : this.raindrops) {
			s.draw(this);
		}
		for (Line s : this.lines) {
			s.draw(this);
		}
		for (PhysicsShape s : this.raindrops) {
			s.act(this.bounds, this.lines);
		}
		for (PhysicsShape s : this.raindrops) {
			s.accelerate(0, 0.98);
		}
		for (int i = 0; i < this.raindrops.size(); i++) {
			if (((PhysicsShape) this.raindrops.get(i)).getLife() > 500) {
				this.raindrops.remove(i);
				i--;
			}
		}
		PhysicsShape newDrop = new PhysicsShape(new Circle(Math.random() * SCREEN_WIDTH, 5, 5));
		this.raindrops.add(newDrop);

		popMatrix();
	}

	public void mousePressed() {
		double mouseCoordX = this.mouseX / this.scaleX;
		double mouseCoordY = this.mouseY / this.scaleY;
		if (this.mouseButton == LEFT) {
			Line l = new Line(mouseCoordX, mouseCoordY, mouseCoordX, mouseCoordY, 5);
			this.lines.add(l);
		} else if (this.lines.size() > 0) {
			this.lines.remove(this.lines.size() - 1);
		}
	}

	public void mouseDragged() {
		double mouseCoordX = this.mouseX / this.scaleX;
		double mouseCoordY = this.mouseY / this.scaleY;
		if (this.mouseButton == LEFT) {
			((Line) this.lines.get(this.lines.size() - 1)).setPoint2(mouseCoordX, mouseCoordY);
		}
	}
}
