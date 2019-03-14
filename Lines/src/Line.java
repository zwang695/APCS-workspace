import processing.core.PApplet;

public class Line {

	private double x1, y1, x2, y2;
	
	private double ix, iy;
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.line((float) x1,(float) y1,(float) x2,(float) y2);
		p.ellipse((float)ix, (float)iy, 3, 3);
		p.popMatrix();
	}
	
	public boolean intersects(Line other) {
		double intersectX = getIntersectX(other);
		double intersectY = getIntersectY(other);
		if(intersectX == Double.MAX_VALUE || intersectY == Double.MAX_VALUE) {
			System.out.println("same");
			return false;
		}
		
		if(isBetween(intersectX, x1, x2) &&
		   isBetween(intersectX, other.x1, other.x2) &&
		   isBetween(intersectY, y1, y2) &&
		   isBetween(intersectY, other.y1, other.y2)) return true;
		return false;
	}
	
	private boolean isBetween(double pt, double x1, double x2) {
		if(pt >= x1 && pt <= x2) return true;
		else if(pt <= x1 && pt >= x2) return true;
		else return false;
	}
	
	private double getIntersectX(Line other) {
		try {
			double x3 = other.x1;
			double x4 = other.x2;
			double y3 = other.y1;
			double y4 = other.y2;
			double num = (x1 * y2 - y1 * x2)*(x3 - x4) - (x1 - x2)*(x3 * y4 - y3 * x4);
			double denom = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
			ix = num/denom;
			return num/denom;
		}
		catch(Exception e) {
			System.out.println(1);
			return Double.MAX_VALUE;
		}
	}
	
	private double getIntersectY(Line other) {
		try {
			double x3 = other.x1;
			double x4 = other.x2;
			double y3 = other.y1;
			double y4 = other.y2;
			double num = (x1 * y2 - y1 * x2)*(y3 - y4) - (y1 - y2)*(x3 * y4 - y3 * x4);
			double denom = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
			iy = num/denom;
			return num/denom;
		}
		catch(Exception e) {
			System.out.println(2);
			return Double.MAX_VALUE;
		}
	}
}
