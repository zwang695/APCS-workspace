import java.util.ArrayList;

public class Movie {
	
	private int id;
	private int year;
	private String title;
	private String[] genres;
	private ArrayList<String> Tags;
	private ArrayList<String> Ratings;
	private String imdb;
	private String tmdb;
	
	public Movie(int id, int year, String title, String[] genres) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.genres = genres;
	}
	
	public String toString() {
		
		return null;
	}

}
