import java.awt.geom.Point2D;

import processing.core.PApplet;
import zachary.shapes.*;

/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve {

	// TO DO
	
	private int level;
	private double length;

    public KochCurve(int level, int length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(marker, level, length, marker.width / 2 - length / 2, marker.height / 2, 0);
    }

    private Point2D drawKochCurve(PApplet marker, int k, double len, double x, double y, double angle) {
    	if(k < 1) {
    		Line l = Line.generateLine(x, y, angle, len, 1);
    		l.draw(marker);
    		return new Point2D.Double(l.getPoint2().getX(), l.getPoint2().getY());
    	}
    	len = len / 3;
    	Point2D p = drawKochCurve(marker, k - 1, len, x, y, angle);
		
    	p = drawKochCurve(marker, k - 1, len, p.getX(), p.getY(), angle - 60);

    	p = drawKochCurve(marker, k - 1, len, p.getX(), p.getY(), angle + 60);
    
    	return drawKochCurve(marker, k - 1, len, p.getX(), p.getY(), angle);
    }
}
