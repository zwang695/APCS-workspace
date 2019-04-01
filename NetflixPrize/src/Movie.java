import java.util.ArrayList;

public class Movie {
	
	private int id;
	private int year;
	private String title;
	private String[] genres;
	private ArrayList<String> Tags;
	private ArrayList<String> ratings;
	private String imdb;
	private String tmdb;
	
	public Movie(int id, int year, String title, String[] genres) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.genres = genres;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(id);
		s.append(",");
		if(title.indexOf("\"") == -1) {
			s.append(title);
			if(year != -1) s.append("(" + year + ")");
		}
		else {
			s.append("\"");
			s.append(title.substring(1, title.length() - 1));
			if(year != -1) s.append("(" + year + ")");
			s.append("\"");
		}
		s.append(",");
		for(String f : genres) {
			s.append(f);
			s.append("|");
		}
		s.append(",");
		s.append(imdb);
		s.append(",");
		s.append(tmdb);
		
		return s.toString();
	}
	
	public void setLinks(String imdb, String tmdb) {
		this.imdb = imdb;
		this.tmdb = tmdb;
	}
	
	public void setRatings(ArrayList<String> ratings) {
		this.ratings = ratings;
	}

}