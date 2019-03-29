import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			String moviesFile = "data" + FileIO.fileSep + "movies.csv";
			String linksFile = "data" + FileIO.fileSep + "links.csv";
			ArrayList<String> movieStrs = FileIO.readFile(moviesFile);
			ArrayList<String> linkStrs = FileIO.readFile(linksFile);
			int count = 0;
			for(int i = 0; i < movieStrs.size(); i++) {
				if(count == 0) {
					count++;
					continue;
				}
				Movie m = translator.translateMovie(movieStrs.get(i));
				translator.translateLinks(m, linkStrs.get(i));
				movies.add(m);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(Movie m : movies) {
			System.out.println(m);
		}
		
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		try {
			String ratingsFile = "data" + FileIO.fileSep + "ratings.csv";
			ArrayList<String> ratingStrs = FileIO.readFile(ratingsFile);
			int count = 0;
			for(String s : ratingStrs) {
				if(count == 0) {
					count++;
					continue;
				}
				Rating r = translator.translateRating(s);
				ratings.add(r);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(Rating r : ratings) {
			System.out.println(r);
		}
	}
	
}