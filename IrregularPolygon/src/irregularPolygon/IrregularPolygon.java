package irregularPolygon;

import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing
import zachary.shapes.Shape;

public class IrregularPolygon extends Shape {
   private ArrayList <Point2D.Double> myPolygon;
    
   // constructors
   public IrregularPolygon() {
	   super(0, 0);
	   myPolygon = new ArrayList<Point2D.Double>();
   }
   
   // public methods
   public void add(Point2D.Double aPoint) {
	   myPolygon.add(aPoint);
   }

   public void draw(PApplet marker) {
	   marker.pushMatrix();
	   marker.strokeWeight(1	);
	   for(int i = 0; i < myPolygon.size() - 1; i++) {
		   marker.line((float)myPolygon.get(i).getX(), (float)myPolygon.get(i).getY(), (float)myPolygon.get(i+1).getX(), (float)myPolygon.get(i+1).getY());
	   }
	   if(myPolygon.size()>1) marker.line((float)myPolygon.get(myPolygon.size()-1).getX(), (float)myPolygon.get(myPolygon.size()-1).getY(), (float)myPolygon.get(0).getX(), (float)myPolygon.get(0).getY());
	   marker.popMatrix();
   }

   public double calcPerimeter() {  
	   double perimeter = 0;
	   for(int i = 0; i < myPolygon.size() - 1; i++) {
		   perimeter += myPolygon.get(i).distance(myPolygon.get(i+1));
	   }
	   if(myPolygon.size()>1) perimeter += myPolygon.get(myPolygon.size() - 1).distance(myPolygon.get(0));
	   return perimeter;
   }

   public double calcArea() { 
	   double area = 0;
	   if(myPolygon.size() >= 1) area += myPolygon.get(myPolygon.size() - 1).getX() * myPolygon.get(0).getY() - myPolygon.get(myPolygon.size() - 1).getY() * myPolygon.get(0).getX();
	   for(int i = 0; i < myPolygon.size() - 1; i++) {
		   area += myPolygon.get(i).getX() * myPolygon.get(i + 1).getY() - myPolygon.get(i).getY() * myPolygon.get(i + 1).getX();
	   }
	   //area += myPolygon.get(myPolygon.size()-1).getX() * myPolygon.get(0).getY() - myPolygon.get(myPolygon.size() - 1).getY() * myPolygon.get(0).getX();
	   
	   return Math.abs(area/2); 
   }
   
	public Point2D getCenter() {
		double cX = 0, cY = 0;

        for(Point2D v : myPolygon) {
            cX += v.getX();
            cY += v.getY();
        }
        return new Point2D.Double(cX / myPolygon.size(), cY / myPolygon.size());
	}
	
	public int findSides() {
		if(myPolygon.size() > 2) return myPolygon.size();
		else if(myPolygon.size() == 0) return 0;
		else
			return myPolygon.size() - 1;
	}
	
}
