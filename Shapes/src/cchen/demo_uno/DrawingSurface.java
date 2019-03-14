package cchen.demo_uno;

import java.util.ArrayList;

import cchen.PhysicsShape;
import processing.core.PApplet;
import zachary.shapes.*;

public class DrawingSurface extends PApplet {
	private Line launcher;
	private ArrayList<PhysicsShape> balls;
	private ArrayList<Line> oof;
	private Rectangle bounds;
	private static final float SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
	private float scaleX;
	private float scaleY;
	int frames= 0;

	public DrawingSurface() {
		this.bounds = new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		this.balls = new ArrayList();
		this.oof = new ArrayList();
		this.launcher = new Line(400, 600, 400, 500, 20);

	}

	public void setup() {
	}

	public void draw() {

		background(255);

		pushMatrix();

		this.scaleX = (this.width / SCREEN_WIDTH);
		this.scaleY = (this.height / SCREEN_HEIGHT);

		scale(this.scaleX, this.scaleY);
		this.launcher.draw(this);
		for (PhysicsShape s : this.balls) {
			s.draw(this);
		}
		for (PhysicsShape s : this.balls) {
			s.act(this.bounds);
		}
		for (PhysicsShape s : this.balls) {
			s.accelerate(0, 0.98);
		}
		for (int i = 0; i < this.balls.size(); i++) {
			if (((PhysicsShape) this.balls.get(i)).getLife() > 500) {
				this.balls.remove(i);
				i--;
			}
		}
		for (PhysicsShape s : this.balls) {
			s.act(this.bounds, this.oof);
		}

		for (Line s : this.oof) {
			s.draw(this);
		}
		if (frames%100==0) {
			this.oof.add(new Line(Math.random()*SCREEN_WIDTH, Math.random()*SCREEN_HEIGHT, Math.random()*SCREEN_WIDTH, Math.random()*SCREEN_HEIGHT, 5));
		}
		for (int i = 0; i < this.oof.size(); i++) {
			if (frames%1000==0) {
				this.oof.remove(i);
				i--;
			}
		}
		popMatrix();
		frames++;
	}

	public void mousePressed() {
		double mouseCoordX = this.mouseX / this.scaleX;
		double mouseCoordY = this.mouseY / this.scaleY;
		if (this.mouseButton == RIGHT) {
			double x = this.launcher.getX();
			double y = this.launcher.getY();

			double angle = Math.atan((y - mouseCoordY) / (mouseCoordX - x));
			if (mouseCoordX < x) {
				angle += Math.PI;
			}
			this.launcher.setPoint2(x + Math.cos(angle) * 50, y - Math.sin(angle) * 50);
		} else {
			PhysicsShape x = new PhysicsShape(new Circle(this.launcher.getX(), this.launcher.getY(), 30));
			x.accelerate((2 * this.launcher.getCenter().getY() - this.launcher.getY()) - this.launcher.getX(),
					(2 * this.launcher.getCenter().getY() - this.launcher.getY()) - this.launcher.getY());
			this.balls.add(x);
		}
	}

	public void mouseDragged() {
		double mouseCoordX = this.mouseX / this.scaleX;
		double mouseCoordY = this.mouseY / this.scaleY;
		if (this.mouseButton == LEFT) {
			double x = this.launcher.getX();
			double y = this.launcher.getY();

			double angle = Math.atan((y - mouseCoordY) / (mouseCoordX - x));
			if (mouseCoordX < x) {
				angle += Math.PI;
			}
			this.launcher.setPoint2(x + Math.cos(angle) * 50, y - Math.sin(angle) * 50);
		}
	}
}
