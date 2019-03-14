package cchen;

import processing.core.PApplet;
import zachary.shapes.*;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

public class PhysicsShape {

	private Shape2D s;
	private double vx, vy;
	private long life;

	public PhysicsShape(Shape2D s) {
		this.s = s;
		this.vx = 0;
		this.vy = 0;
		life = 0;
	}

	public PhysicsShape(Shape2D s, double vx, double vy) {
		this.s = s;
		this.vx = vx;
		this.vy = vy;
	}

	public void moveTo(double x, double y) {
		s.move(x, y);
	}

	public void moveBy(double x1, double y1) {
		s.move(s.getX() + x1, s.getY() + y1);
	}

	public void draw(PApplet p) {
		s.draw(p);
	}

	public double getSpeed() {
		return Math.sqrt(this.vx * this.vx + this.vy * this.vy);
	}

	public double getAngle() {
		double angle = Math.atan(this.vy / this.vx);
		if (this.vx < 0.0) {
			angle += Math.PI;
		}
		return angle;
	}

	public long getLife() {
		return this.life;
	}

	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void accelerate(double ax, double ay) {
		this.vx += ax;
		this.vy += ay;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.s.getX(), this.s.getY(),
				this.s.getX() + 2 * (this.s.getCenter().getX() - this.s.getX()),
				this.s.getY() + 2 * (this.s.getCenter().getY() - this.s.getY()));
	}

	public Point2D.Double[] getCorners() {
		Rectangle r = this.getBounds();
		Point2D.Double[] points = new Point2D.Double[4];
		points[0] = new Point2D.Double(r.getX(), r.getY());
		points[1] = new Point2D.Double(r.getX() + r.getWidth(), r.getY());
		points[2] = new Point2D.Double(r.getX(), r.getY() + r.getHeight());
		points[3] = new Point2D.Double(r.getX() + r.getWidth(), r.getY() + r.getHeight());
		return points;
	}

	public boolean intersects(ArrayList<PhysicsShape> obstacles) {
		Point2D.Double[] points = getCorners();
		for (PhysicsShape s : obstacles) {
			if (s != this) {
				Point2D.Double[] doubles;
				int j = (doubles = points).length;
				for (int i = 0; i < j; i++) {
					Point2D.Double p = doubles[i];
					if (s.getBounds().isPointInside(p.x, p.y)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void act(Rectangle window) {
		this.life++;

		double x = this.s.getX();
		double y = this.s.getY();
		if (!window.isPointInside(x, y)) {
			double changeX = Math.max(window.getX() - x, 0) + Math.min(window.getX() + window.getWidth() - x, 0);
			double changeY = Math.max(window.getY() - y, 0) + Math.min(window.getY() + window.getHeight() - y, 0);

			this.moveBy(changeX, changeY);
		}

		this.moveBy(this.vx, 0);
		if (!window.isPointInside(this.s.getX(), this.s.getY())) {
			this.vx = (-this.vx);
			this.moveBy(this.vx, 0);
		}
		this.moveBy(0, this.vy);
		if (!window.isPointInside(this.s.getX(), this.s.getY())) {
			this.vy = (-this.vy);
			this.moveBy(0, this.vy);
		}
		this.vx *= 0.9;
		this.vy *= 0.9;
	}

	public void act(Rectangle window, ArrayList<Line> obstacles) {
		double x = this.s.getX();
		double y = this.s.getY();
		double x2 = this.s.getX() + this.vx;
		double y2 = this.s.getY() + this.vy;
		Line motionLine = new Line(x, y, x2, y2, 1);
		for (Line l : obstacles) {
			if (l.intersects(motionLine)) {
				double angle = getAngle();
				double speed = getSpeed();

				double angle2 = Math.atan(
						((2 * l.getCenter().getY() - l.getY()) - l.getY()) / ((2 * l.getCenter().getX()) - l.getX()));

				angle += Math.PI - (angle2 + angle);

				this.vx = (speed * Math.sin(angle));
				this.vy = (speed * Math.cos(angle));
			}
		}
		act(window);
	}

	public void act(ArrayList<PhysicsShape> obstacles) {
		this.life++;

		this.moveBy(0, this.vy);
		if (intersects(obstacles)) {
			this.vy = (-this.vy);
			this.moveBy(0, this.vy);
		}
		this.moveBy(this.vx, 0);
		if (intersects(obstacles)) {
			this.vx = (-this.vx);
			this.moveBy(this.vx, 0);
		}
		this.vx *= 0.98;
		this.vy *= 0.98;
	}

}
