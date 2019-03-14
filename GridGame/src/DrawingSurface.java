


import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private FloodGrid board;
	private int runCount;
	private int speed;
	private Point prevToggle;
	private int stepsLeft;
	
	private final int MAX_SPEED = 480, MIN_SPEED = 15;
	
	
	public DrawingSurface() {
		board = new FloodGrid();
		runCount = -1;
		speed = 120;
		prevToggle = null;
		stepsLeft = 25;
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(0);
		textAlign(CENTER);
		textSize(25);
		
		text("Steps:" + stepsLeft, height+100, 30);
		if(board.isWin()) {
			text("You win", height+100, 80);
		}
		else if(stepsLeft == 0) {
			text("You Lose", height+100, 80);
		}
		
		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}
		
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			Point click = new Point(mouseX,mouseY);
			float dimension = height;
			Point cellCoord = board.clickToIndex(click,0,0,dimension,dimension);
			if (cellCoord != null) {
				int result = board.step(cellCoord.x, cellCoord.y);
				prevToggle = cellCoord;
				if(result == 1) stepsLeft--;
			}
		} 
	}
	
}










