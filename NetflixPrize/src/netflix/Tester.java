package netflix;

import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		try {
			String movieCSV = "data" + FileIO.fileSep + "movies.csv";
			ArrayList<String> movieStrs = FileIO.readFile(movieCSV);
			
			for(String s : movieStrs) {
				Movie m = translator.translateMovie(s);
				movies.add(m);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Movie m : movies) {
			System.out.println(m);
		}
		
	}

}
