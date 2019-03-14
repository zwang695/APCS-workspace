import java.awt.geom.Point2D;

import processing.core.PApplet;
import zachary.shapes.Line;

public class DragonCurve {
	
	private int level;
	private double length;

    public DragonCurve(int level, int length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker) {
    	drawDragonCurve(new MemoryDrawer(marker,marker.width/2,marker.height/2,0), level, length, 1);
    }

    private void drawDragonCurve(MemoryDrawer marker, int level, double length, int sign) {
    	if(level == 0) {
    		marker.drawForward(length);
    	}
    	else {
    		drawDragonCurve(marker, level - 1, length*Math.sqrt(0.5), 1);
    		marker.turn(sign *- 90);
    		drawDragonCurve(marker, level - 1, length*Math.sqrt(0.5), -1);
    	}
    }

}
