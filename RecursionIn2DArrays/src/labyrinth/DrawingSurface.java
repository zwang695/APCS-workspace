package labyrinth;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Labyrinth board;
	
	public DrawingSurface() {
		board = new Labyrinth("data/data3/test1.txt");
		System.out.println(board);
	}

}
