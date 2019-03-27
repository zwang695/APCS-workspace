import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			String moviesFile = "data" + FileIO.fileSep + "movies.csv";
			ArrayList<String> movieStrs = FileIO.readFile(moviesFile);
			int count = 0;
			for(String s : movieStrs) {
				if(count == 0) {
					count++;
					continue;
				}
				Movie m = translator.translateMovie(s);
				movies.add(m);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}