
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

	private int id;
	private HashMap<Movie, Rating> ratings;
	private Genre[] avgR; //Genres the user rates
	
	public User(int id) {
		this.id = id;
		ratings = new HashMap<Movie, Rating>();
		avgR = new Genre[19];
		for(int i = 0; i < avgR.length; i++) {
			avgR[i] = new Genre(Genre.AVAILGENRES[i]);
		}
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
	
	public double getAvgR(int index) {
		return avgR[index].getAvgR();
	}
	
	public void calcAvgR() {
		double[] sum = new double[19];
		int[] count = new int[19];
		for(Map.Entry<Movie, Rating> e : ratings.entrySet()) {
			Movie m = e.getKey();
			Rating r = e.getValue();
			for(Genre g : m.getGenre()) {
				int index = g.getCount();
				sum[index] += r.getStars();
				count[index]++;
			}
		}
		for(int i = 0; i < sum.length; i++) {
			double n1 = sum[i];
			int n2 = count[i];
			avgR[i].setAvgR(n1/n2);
		}
	}
	
}