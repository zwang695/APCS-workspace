package maze;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Maze board;
	
	public DrawingSurface() {
		board = new Maze("data/data2/test6.txt");
		System.out.println(board.solve());
		System.out.println(board);
	}

}
