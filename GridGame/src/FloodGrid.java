import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

//3 colors for now
public class FloodGrid {
	
	private Color[][] grid;
	private boolean[][] visited;
	
	public FloodGrid() {
		grid = new Color[14][14];
		fillGrid();
	}
	
	public FloodGrid(int size) {
		grid = new Color[size][size];
		fillGrid();
	}
	
	public int step(int x, int y) {
		visited = new boolean[grid.length][grid[0].length];
		Color selected = grid[x][y];
		Color[][] copy = new Color[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				copy[i][j] = grid[i][j];
			}
		}
		if(selected.equals(grid[0][0])) return -1;
		changeColors(copy, selected, 0, 0);
		return 1;
	}
	
	public void changeColors(Color[][] copy, Color c, int x, int y) {
		if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0) return;
		
		if(visited[x][y]) {
			return;
		}
		else {
			visited[x][y] = true;
		}
		
		if(copy[x][y].equals(copy[0][0])) {
			grid[x][y] = c;
		}
		else {
			return;
		}
		
		changeColors(copy, c, x + 1, y);
		changeColors(copy, c, x - 1, y);
		changeColors(copy, c, x, y + 1);
		changeColors(copy, c, x, y - 1);
		
	}
	
	
	
	private void fillGrid() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				int rando = (int) (Math.random()*6);
				if(rando==0) grid[i][j] = new Color(128, 0, 128);
				else if(rando==1) grid[i][j] = new Color(0, 187, 0);
				else if(rando==2) grid[i][j] = new Color(255,255,0);
				else if(rando==3) grid[i][j] = new Color(0, 255, 255);
				else if(rando==4) grid[i][j] = new Color(255, 204, 102);
				else if(rando==5) grid[i][j] = new Color(255, 0, 0);
			}
		}
	}
	
	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	
	public void draw(PApplet marker, float x, float y, float width, float height) {
		
		float cellWidth = width / grid[0].length;
		float cellHeight = height / grid.length;
		
		marker.stroke(255);
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				marker.fill(grid[i][j].getRGB());
				marker.rect(x + j*cellWidth, y + i*cellHeight, cellWidth, cellHeight);
			}
		}
	}
	
	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width / grid[0].length;
		float cellHeight = height / grid.length;
		
		double xop = (int) p.getX();
		double yop = (int) p.getY();
		
		Point result = new Point( (int) (yop / cellWidth), (int) (xop / cellHeight));
		if(result.x <= 0 || result.x >= grid[0].length || result.y <= 0 || result.x >= grid.length) return null;
		return result;
	}
	
	public boolean isWin() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(!grid[i][j].equals(grid[0][0])) return false;
			}
		}
		return true;
	}
		
	/*
	private boolean[][] grid;

	// Constructs an empty grid
	public FloodGrid() {
		grid = new boolean[20][20];
	}

	// Constructs the grid defined in the file specified
	public FloodGrid(String filename) {
		grid = new boolean[20][20];
		readData(filename, grid);
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		boolean[][] copy = new boolean[grid[0].length][grid.length];
		for(int i = 0; i < copy.length; i++) {
			for(int j = 0; j < copy[0].length; j++) {
				int num = checkNeighbors(i, j);
				if(num == 3) copy[i][j] = true;
				if(num == 2) copy[i][j] = grid[i][j];
			}
		}
		grid = copy.clone();
	}
	
	private int checkNeighbors(int x, int y) {
		int count = 0;
		for(int i = x - 1; i <= x + 1; i++) {
			for(int j = y - 1; j <= y + 1; j++) {
				if(i == x && j == y) continue;
				if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j]) count++;
			}
		}
		return count;
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i = 0; i < n; i++) {
			step();
		}
	}
	
	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String result = "";
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				
				if(grid[i][j]) result += '*';
				else result += ' ';
		
			}
			result += "\n";
		}
		
		return result;
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (count < gameData.length && i < gameData[count].length && line.charAt(i)=='*')
								gameData[count][i] = true;

						count++;
					}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }
	
	
	
	
	
	
	
	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	/*
	public void draw(PApplet marker, float x, float y, float width, float height) {
		
		float cellWidth = width / grid[0].length;
		float cellHeight = height / grid.length;
		
		marker.stroke(0);
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]) marker.fill(0);
				else marker.fill(255);
				
				marker.rect(x + j*cellWidth, y + i*cellHeight, cellWidth, cellHeight);
			}
		}
	}
	
	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	/*
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width / grid[0].length;
		float cellHeight = height / grid.length;
		
		double xop = (int) p.getX();
		double yop = (int) p.getY();
		
		Point result = new Point( (int) (yop / cellWidth), (int) (xop / cellHeight));
		return result;
	}
	
	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	/*
	public void toggleCell(int i, int j) {
		if(i <= 0 || i >= grid[0].length || j <= 0 || j >= grid.length) return;
		if(grid[i][j]) grid[i][j] = false;
		else grid[i][j] = true;
	}

	*/
	
}