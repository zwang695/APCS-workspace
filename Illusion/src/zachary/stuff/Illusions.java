package zachary.stuff;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import zachary.testers.Illusion;

public class Illusions {

	public static void main(String args[]) {
		Illusion drawing = new Illusion();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(600, 490);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}
}
