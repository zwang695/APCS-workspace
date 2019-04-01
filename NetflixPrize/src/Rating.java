

public class Rating {

	private int userID;
	private int movieID;
	private double stars;
	private long timestamp;
	
	public Rating(int userID, int movieID, double stars, long timestamp) {
		this.userID = userID;
		this.movieID = movieID;
		this.stars = stars;
		this.timestamp = timestamp;
	}
	
	public String toString() {
		return userID + "," + movieID + "," + stars + "," + timestamp;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public int getMovieID() {
		return movieID;
	}
	
	public double getStars() {
		return stars;
	}
	
}