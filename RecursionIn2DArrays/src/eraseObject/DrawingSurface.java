package eraseObject;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Erase board;
	
	public DrawingSurface() {
		board = new Erase("data/data1/digital.txt");
		board.eraseObject(8, 5);
		System.out.println(board);
	}

}
