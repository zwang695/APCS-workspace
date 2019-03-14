package zachary.shapesdemo;
import java.util.ArrayList;

import cchen.shapes.Line;
import cchen.shapes.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s;

	private double vx, vy;

	private double gravity;
	
	private int lifeTimes;
	
	private Line l1, l2, l3;

	public PhysicsShape(Shape s) {
		this.s = s;
		vy = 0.01;
		gravity = 0.1;
		lifeTimes = 0;
	}

	public void draw(PApplet p) {
		if (s != null && lifeTimes < 500) {
			s.draw(p);
			lifeTimes++;
		}
		else {
			s = null;
			lifeTimes = 0;
		}
	}

	public void act(ArrayList<Line> lines) {
		if(s != null) {
			l1 = new Line(s.getX() - 10, s.getY() - 10 + vy, s.getX() + 10, s.getY() + 10 + vy);
			l2 = new Line(s.getX() + 10, s.getY() - 10 + vy, s.getX() - 10, s.getY() + 10 + vy);
			l3 = new Line(s.getX(), s.getY() - 10 + vy, s.getX(), s.getY() + 10 + vy);
			
			for(Line l : lines) { 
				if(l1.intersects(l) || l2.intersects(l) || l3.intersects(l)) {
					double angle = Math.atan((l.getPoint2().getY()-l.getY())/(l.getPoint2().getX()-l.getX()));
					angle += Math.PI;
					angle*=-1;
					double speed = Math.sqrt(vy*vy + vx*vx);
					vx = speed * Math.sin(angle)*0.55;
					vy = speed * Math.cos(angle)*0.55;
				}
			}
			
			if (s.getY() + vy >= 270 - 20) {
				vy *= -.5;
				return;
			}
	
			s.move(s.getX() + vx, s.getY() + vy);
	
			vy += gravity;
		}
	}
	
	public Shape getShape() {
		return s;
	}

}