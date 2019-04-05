
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;
	
	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}
	
	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}
			
			String title = movie.getTitle();
			drawer.text(title, x, y);
			
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}
	

	public void downloadArt(PApplet drawer) {
		
		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner s = null;
				String url = "https://www.imdb.com/title/tt" + movie.getImdb() + "/"; 
				//String url = "https://www.imdb.com/title/tt0114709/";
				String output = "";
				try {
					URL link = new URL(url);
					s = new Scanner(link.openStream());
					
					while(s.hasNextLine()) {
						String line = s.nextLine();
						output += line;
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					if(s != null) s.close();
				}
				
				int i = output.indexOf(movie.getTitle() + "Poster");
				//int i = output.indexOf("Toy Story Poster");
				int index = output.indexOf("src=", i+1);
				int index2 = output.indexOf("\"", index+1);
				output = output.substring(index2 + 1, output.indexOf("\"", index2 + 1));
				
				coverArt = drawer.loadImage(output, "jpg");
			}
			
		});
		
		downloader.start();

	}

	
}
