import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NetflixPredictor {


	// Add fields to represent your database.
	HashMap<Integer, Movie> movies; //movieID, the movie                             
	HashMap<Integer, User> users; //userID, the user
	
	
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
		ArrayList<String> movieStrs = null;
		ArrayList<String> ratingStrs = null;
		
		movies = new HashMap<Integer, Movie>();
		users = new HashMap<Integer, User>();
		
		try {
			movieStrs = FileIO.readFile(movieFilePath);
			ratingStrs = FileIO.readFile(ratingFilePath);
			movieStrs.remove(0);
			ratingStrs.remove(0);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(String s : movieStrs) {
			Movie m = translator.translateMovie(s);
			movies.put(m.getID(), m);
		}
		
		for(String s : ratingStrs) {
			Rating r = translator.translateRating(s);
			User u = null;
			if(!users.containsKey(r.getUserID())) {
				u = new User(r.getUserID());
				users.put(r.getUserID(), u);
			}
			else {
				u = users.get(r.getUserID());
			}
			Movie m = movies.get(r.getMovieID());
			m.addRating(u, r);
			u.addRating(m, r);
		}
		
		//calculate average rating per genre per user
		for(Map.Entry<Integer, User> e : users.entrySet()) {
			User u = e.getValue();
			u.calcAvgR();
		}
		
		//calculate average rating per movie
		for(Map.Entry<Integer, Movie> e : movies.entrySet()) {
			e.getValue().calcAvgR();
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
		if (users.containsKey(userID)) {
			User u = users.get(userID);
			if(u.getRating(movies.get(movieID)) != null) return u.getRating(movies.get(movieID)).getStars();
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
		
		double stars = getRating(userID, movieID);
		if(stars != -1) return stars;
		
		//double sum = users.get(userID)
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
