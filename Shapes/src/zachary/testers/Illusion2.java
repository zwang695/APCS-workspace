package zachary.testers;
import processing.core.PApplet;
import zachary.shapes.*;

public class Illusion2 extends PApplet{
	
	private Line[] lt; //thin lines
	private Line[] bl; //blue thick lines
	
	public Illusion2() {
		lt = new Line[11];
		bl = new Line[2];
		for(int i = 0; i < lt.length; i++) {
			lt[i] = Line.generateLine(-50, 120, 20 - 40.0/11*i, 450, 1);
		}
		int[] stroke = new int[3];
		stroke[0] = 0;
		stroke[1] = 0;
		stroke[2] = 255;
		bl[0] = new Line(150, 60, 150, 190, 5, stroke);
		bl[1] = new Line(190, 60, 190, 190, 5, stroke);
	}
	
	public void draw() {
		background(255);
		for(int i = 0; i < lt.length; i++) {
			lt[i].draw(this);
		}
		bl[0].draw(this);
		bl[1].draw(this);
	}
}
