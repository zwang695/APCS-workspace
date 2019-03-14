import processing.core.PApplet;

/**
 * 
 * This class is a wrapper for a PApplet that has a "memory" about its location and angle. In this sense, it acts more like a marker held to paper, drawing as it moves.
 * 
 * 
 * @author john_shelby
 *
 */
public class MemoryDrawer {

	private double x,y,angle;
	
	private PApplet drawer;
	
	/**
	 * Sets the initial state of the drawer.
	 * 
	 * @param drawer The PApplet that will be drawn on.
	 * @param x Initial x location.
	 * @param y Initial y location.
	 * @param angle Initial angle, in degrees counterclockwise. Right is 0.
	 */
	public MemoryDrawer(PApplet drawer, double x, double y, double angle) 
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.drawer = drawer;
	}
	
	/**
	 * Moves forward (in the direction the drawer is pointed) by amount length, drawing a line in the process.
	 * 
	 * @param length The length of the line to draw.
	 */
	public void drawForward(double length)
	{
		double x2 = x + length*Math.cos(Math.toRadians(angle));
		double y2 = y - length*Math.sin(Math.toRadians(angle));
		drawer.line((float)x, (float)y, (float)x2, (float)y2);
		x = x2;
		y = y2;
	}
	
	/**
	 * Jumps to coordinate newX,newY, drawing a line in the process.
	 * 
	 * @param newX The new X coordinate of the drawer and end point of the line.
	 * @param newY The new Y coordinate of the drawer and end point of the line.
	 */
	public void drawLineTo(double newX, double newY)
	{
		drawer.line((float)x, (float)y, (float)newX, (float)newY);
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Turns the drawer counter-clockwise by a certain angle. Does not draw anything in the process.
	 * 
	 * @param angleChange The angle to turn by.
	 */
	public void turn(double angleChange)
	{
		this.angle += angleChange;
	}
	
	/**
	 * Moves the drawer to a new location without drawing a line in the process.
	 * 
	 * @param newX A new x coordinate.
	 * @param newY A new y coordinate.
	 */
	public void move(double newX, double newY)
	{
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Sets the angle of the drawer.
	 * 
	 * @param newAngle A new angle.
	 */
	public void setDirection(double newAngle)
	{
		this.angle = newAngle;
	}
	
	/**
	 * Gets the x coordinate of the drawer.
	 * 
	 * @return The x coordinate.
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Gets the y coordinate of the drawer.
	 * 
	 * @return The y coordinate.
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Gets the angle of the drawer.
	 * 
	 * @return The angle.
	 */
	public double getAngle()
	{
		return angle;
	}
	
	
}
