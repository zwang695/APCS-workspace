package maze;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs an empty grid
	public Maze() {
		
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		grid = new char[cols][rows];
		readData(filename, grid);
	}

	// Attempts to find a path through the maze and returns whether a path was found or not
	public boolean solve() {
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'C') {
					return solve(i, j);
				}
			}
		}
		return false;
	}
	
	// Private recursive version of solve()
	private boolean solve(int i, int j) {
		if(i < 0 || i > rows - 1 || j < 0 || j > cols - 1) return false;
		if(grid[i][j]=='X') return true;
		if(grid[i][j]=='#') return false;
		if(grid[i][j]=='!') return false;
		
		grid[i][j] = '!';
		
		if(solve(i + 1, j)) return true;
		if(solve(i - 1, j)) return true;
		if(solve(i, j + 1)) return true;
		if(solve(i, j - 1)) return true;
		
		grid[i][j] = '.';
		
		return false;
	}
	

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				output += grid[j][i];
			}
			output += "\n";
		}
		return output;
	}

		public void readData (String filename, char[][] gameData) {
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
							if (i < gameData.length && count < gameData[i].length)
								gameData[i][count] = line.charAt(i);

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

}