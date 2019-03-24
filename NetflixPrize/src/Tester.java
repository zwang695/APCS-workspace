import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			String moviesFile = "data" + FileIO.fileSep + "movies2.csv";
			System.out.println(1);
			ArrayList<String> movieStrs = FileIO.readFile(moviesFile);
			for(String s : movieStrs) {
				Movie m = translator.translateMovie(s);
				System.out.println(2);
				movies.add(m);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
