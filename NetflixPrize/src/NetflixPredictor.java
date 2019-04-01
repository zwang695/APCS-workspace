import java.io.IOException;
import java.util.ArrayList;


public class NetflixPredictor {


	// Add fields to represent your database.
	ArrayList<Movie> movies;
	ArrayList<Rating> ratings;
	ArrayList<Tag> tags;
	ArrayList<User> users;                                               
	

	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	public NetflixPredictor (String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		movies = new ArrayList<Movie>();
		tags = new ArrayList<Tag>();
		ratings = new ArrayList<Rating>();
		users = new ArrayList<User>();
		try {
			ArrayList<String> movieStrs = FileIO.readFile(movieFilePath);
			ArrayList<String> linkStrs = FileIO.readFile(linkFilePath);
			for(int i = 0; i < movieStrs.size(); i++) {
				Movie m = translator.translateMovie(movieStrs.get(i));
				System.out.println(m);
				if(m == null) continue;
				translator.translateLinks(m, linkStrs.get(i));
				movies.add(m);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}		
		
		try {
			ArrayList<String> ratingStrs = FileIO.readFile(ratingFilePath);
			for(String s : ratingStrs) {
				Rating r = translator.translateRating(s);
				if(r == null) continue;
				ratings.add(r);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		for(Rating r : ratings) {
			if(r.getUserID() != userID) continue;
			if(r.getMovieID() != movieID) continue;
			return r.getStars();
		}
		
		return -1;
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {

		return 0;
	}
	
	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		return 0;
	}
	
}
