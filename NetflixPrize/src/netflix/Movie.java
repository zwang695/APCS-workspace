package netflix;

import java.util.ArrayList;

public class Movie {

	private int id;
	private String title;
	private String[] genres;
	private ArrayList<Tag> tags;
	private ArrayList<Rating> ratings;
	private int imdbLink;
	private int tmdbLink;
	private double averageRating;
	private int year;
	
	public Movie(int id, String title, String[] genres, int year) {
		this.id = id;
		this.title = title;
		this.genres = genres;
		this.year = year;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(id);
		s.append(",");
		boolean containsComma = false;
		boolean containsQuote = false;
		for(int i = 0; i < title.length(); i++) {
			if(s.charAt(i) == ',') {
				containsComma = true;
				continue;
			}
			if(s.charAt(i) == '\"') containsQuote = true;
			if(containsComma && containsQuote) break;
		}
		
		if(containsComma) {
			s.append("\"");
		}
		
		
		return null;
	}

}
