import java.awt.geom.Point2D;

import processing.core.PApplet;
import zachary.shapes.Line;

public class KochSnowflake {
	
	private int level;
	private double length;

    public KochSnowflake(int level, int length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker) {
    	Point2D p = drawKochSnowflake(marker, level, length, marker.width / 2 - length / 2, marker.height / 2, -60);
    	p = drawKochSnowflake(marker, level, length, p.getX(), p.getY(), 60);
    	drawKochSnowflake(marker, level, length, p.getX(), p.getY(), 180);
    }

    private Point2D drawKochSnowflake(PApplet marker, int k, double len, double x, double y, double angle) {
    	if(k < 1) {
    		Line l = Line.generateLine(x, y, angle, len, 1);
    		l.draw(marker);
    		return new Point2D.Double(l.getPoint2().getX(), l.getPoint2().getY());
    	}
    	len = len / 3;
    	Point2D p = drawKochSnowflake(marker, k - 1, len, x, y, angle);
		
    	p = drawKochSnowflake(marker, k - 1, len, p.getX(), p.getY(), angle - 60);

    	p = drawKochSnowflake(marker, k - 1, len, p.getX(), p.getY(), angle + 60);
    
    	return drawKochSnowflake(marker, k - 1, len, p.getX(), p.getY(), angle);
    }

}
