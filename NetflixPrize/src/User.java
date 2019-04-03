
import java.util.ArrayList;
import java.util.HashMap;

public class User {

	private int id;
	private HashMap<Movie, Rating> ratings;
	
	
	public User(int id) {
		this.id = id;
		ratings = new HashMap<Movie, Rating>();
	}
	
	public void addRating(Movie m, Rating r) {
		ratings.put(m, r);
	}
	
	public Rating getRating(Movie m) {
		return ratings.get(m);
	}
	
	public String toString() {
		return id + "";
	}
	
	public int getID() {
		return id;
	}
}