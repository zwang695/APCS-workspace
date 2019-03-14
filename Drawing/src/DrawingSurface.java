import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PShape;

public class DrawingSurface extends PApplet {
//+ looks really good, I like the spray can thing
	
//- some code could be inside other classes. you can add more methods (example: changing the color of the house)
	// also you dont need all those fields in your house class. just use X and Y (the same way i mentioned below)
//Delta resizing the spray can:
	/*
	 * person constructor could take in x and y values and you can draw the person based on the values you pass in. 
	 * 
	 * spraycan doesnt scale because it is written above the scale method is being called and outside of the matrix statements.
	 */
	
	
	
	
	
	
	
	private House house;
	private Person person;
	public static boolean isWaving;
	public static final float sWidth = 400, sHeight = 300f;
	
	public DrawingSurface() {
		house = new House(this);
		person = new Person();
	}
	
	public void draw() {
		frameRate(20);
		background(255);
		
		house.draw(this);
		person.draw(this);
		
		if(house.getl1().intersects(person.getLine()) || house.getl2().intersects(person.getLine()) || house.getl3().intersects(person.getLine()) || house.getl4().intersects(person.getLine())) {
			house.setColor((float)Math.random()*255, (float)Math.random()*255, (float)Math.random()*255);
		}
		
		fill(0);
		textSize(15);
		text("Interactions: Arrow Keys, Shift Button, Mouse Clicks", 10, 15);
	}
	
	public void mousePressed() {
		house.move(mouseX, mouseY);
	}
	
	public void keyPressed() {
		if(key==CODED) {
			if(keyCode==UP) {
				house.resize(0.1f);
			}
			else if(keyCode==DOWN) {
				house.resize(-0.1f);
			}
			if(keyCode==LEFT) {
				person.move(-10);
			}
			else if(keyCode==RIGHT) {
				person.move(10);
			}
			else if(keyCode==SHIFT) {
				isWaving = true;
			}
		}
	}
}
