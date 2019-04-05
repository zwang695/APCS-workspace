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
		ArrayList<String> linkStrs = null;
		
		movies = new HashMap<Integer, Movie>();
		users = new HashMap<Integer, User>();
		
		try {
			movieStrs = FileIO.readFile(movieFilePath);
			ratingStrs = FileIO.readFile(ratingFilePath);
			linkStrs = FileIO.readFile(linkFilePath);
			movieStrs.remove(0);
			ratingStrs.remove(0);
			linkStrs.remove(0);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < movieStrs.size(); i++) {
			Movie m = translator.translateMovie(movieStrs.get(i));
			movies.put(m.getID(), m);
			translator.translateLinks(m, linkStrs.get(i));
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
		
		Movie m = movies.get(movieID);
		
		double sum = 0;
		int count = 0;
		for(Genre g : m.getGenre()) {
			sum += users.get(userID).getAvgR(g.getCount());
			count++;
		}
		
		if(!Double.isNaN(m.getAvgR())) {
			sum += m.getAvgR();
			count++;
		}
		
		double ans = sum/count;
		if(Double.isNaN(ans)) return 3.5;
		
		return ans;
	}
	
	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {
		for(Map.Entry<Integer, Movie> e : movies.entrySet()) {
			double ratingGuessed = guessRating(userID, e.getValue().getID());
			if(ratingGuessed>4.5) {
				return e.getValue().getID();
			}
		}
		return 1;
	}

	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> a = new ArrayList<Movie>();
		for(Map.Entry<Integer, Movie> e : movies.entrySet()) {
			a.add(e.getValue());
		}
		return a;
	}
	
	public Movie getMovie(int movieID) {
		return movies.get(movieID);
	}
	
}
