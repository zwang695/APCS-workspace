package zachary.testers;

import zachary.shapes.*;
import processing.*;
import processing.core.PApplet;

public class Illusion extends PApplet{
	
	private Rectangle[][] r;
	
	public Illusion() {
		r = new Rectangle[11][9];
		
		int c = 0;
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 11; j++) {
				if(i % 4 == 1) c = 5;
				else if(i % 4 == 2) c = 0;
				else if(i % 4 == 3) c = 5;
				else if(i % 4 == 0) c = 15;
				if(j % 2 == 0) r[j-1][i-1] = new Rectangle((j - 1)*50 + c, (i - 1)*50, 50, 50, 255);
				else r[j-1][i-1] = new Rectangle((j - 1)*50 + c, (i - 1)*50, 50, 50, 0);
			}
		}
	}
	
	public void draw() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 11; j++) {
				r[j][i].draw(this);
			}
		}
	}
	
}
