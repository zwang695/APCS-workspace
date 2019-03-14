package eraseObject;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*

	This program erases objects (connected stars) from a 2D grid. 

	Coded by: 
	Modified on: 

*/

public class Erase {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;
	private boolean[][] visited;

	// Constructs an empty grid
	public Erase() {
	}

	// Constructs the grid defined in the file specified
	public Erase(String filename) {
		data = new char[cols][rows];
		readData(filename, data);
	}
	
	// Erases an object beginning at x,y
	public void eraseObject(int x, int y) {
		visited = new boolean[data[0].length][data.length];
		char[][] copy = new char[data[0].length][data.length];
		for(int i = 0; i < data[0].length; i++) {
			for(int j = 0; j < data.length; j++) {
				copy[j][i] = data[j][i];
			}
		}
		eraseObject(copy, x, y);
	}
	
	private void eraseObject(char[][] copy, int x, int y) {
		if(x >= data.length || x < 0 || y >= data[0].length || y < 0) return;
		
		if(visited[y][x]) {
			return;
		}
		else {
			visited[y][x] = true;
		}
		
		if(copy[y][x]=='*') {
			data[y][x] = ' ';
		}
		else {
			return;
		}
		
		eraseObject(copy, x + 1, y);
		eraseObject(copy, x - 1, y);
		eraseObject(copy, x, y + 1);
		eraseObject(copy, x, y - 1);
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String result = "";
		for(int i = 0; i < data[0].length; i++) {
			for(int j = 0; j < data.length; j++) {
				
				result += data[j][i];
		
			}
			result += "\n";
		}
		
		return result;
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