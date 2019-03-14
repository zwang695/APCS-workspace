import processing.core.PApplet;
//+ The waving is very smooth and it continues even when the person moves or when the house changes location/size
//- The arm sizes are very uneven
//Delta Change the stroke weight to match the rest of the body




public class Person {

	private int x;
	private int canX;
	
	private int wave_Angle;
	private int current_Angle;
	private int angle_Change;
	
	private int tanCount;
	
	private Line spraycan;
	
	public Person() {
		wave_Angle = 60;
		current_Angle = 0;
		angle_Change = 1;
		tanCount = 185;
		canX = 100;
		spraycan = new Line(100, 145, 110, 115);
	}
	
	public void draw(PApplet p) {
		
		p.strokeWeight(5);
		//spraycan = new Line(canX * p.width/400f, 165 * p.height/300f, (canX + 10) * p.width/400f, 125 * p.height/300f);
		spraycan = new Line(canX, 145, (canX + 10), 115);
		spraycan.draw(p);
		p.strokeWeight(3);
		
		p.pushMatrix();
		
		p.translate(x, 0);
		
		p.scale(p.width/400f, p.height/300f);
		
		//head
		p.fill(255, 218, 185);
		p.stroke(255, 218, 185);
		p.ellipse(75f, 125f, 50f, 50f);
		//body
		p.strokeWeight(3);
		p.line(75, 150, 75, 175);
		//arms
		p.stroke(255, 218, tanCount);
		if(DrawingSurface.isWaving) 
			drawWaving(p);
		else drawRight(p);
		p.stroke(255, 218, 185);
		p.line(75, 160, 100, 160);
		//legs
		p.line(50, 200, 75, 175);
		p.line(100, 200, 75, 175);
		
		p.fill(255);
		p.stroke(20);
		p.popMatrix();
		
		current_Angle += angle_Change;
		if(current_Angle > wave_Angle || current_Angle == 0) {
			angle_Change *= -1;
			if(current_Angle==0) {
				DrawingSurface.isWaving = false;
				if(tanCount > 9) tanCount-=10;
			}
		}
	}
	
	public void move(int step) {
		canX += step;
		x += step;
	}
	
	public void drawWaving(PApplet p) {
		p.pushMatrix();
		p.strokeWeight(10);
		p.translate(70, 160);
		p.rotate(p.radians(current_Angle));
		p.line(0, 0, -36, 0);
		p.strokeWeight(3);
		p.popMatrix();
	}
	
	public void drawRight(PApplet p) {
		p.pushMatrix();
		p.strokeWeight(10);
		p.translate(70, 160);
		p.line(0, 0, -36, 0);
		p.strokeWeight(3);
		p.popMatrix();
	}
	
	public Line getLine() {
		return spraycan;
	}
	
}
