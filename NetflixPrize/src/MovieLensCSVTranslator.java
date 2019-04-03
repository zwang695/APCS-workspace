import java.util.ArrayList;
import java.util.Arrays;

public class MovieLensCSVTranslator {
	
	public Movie translateMovie(String line) {
		int id;
		int year;
		String title;
		String[] genres = new String[0];
		boolean hasQuotes = false;
		int index = line.indexOf(',');
		
		id = Integer.parseInt(line.substring(0, index));
		
		line = line.substring(index + 1);
		
		title = line.substring(0, line.lastIndexOf(','));
		
		
		if(title.lastIndexOf('(') == -1) year = -1;
		else {
			year = Integer.parseInt(title.substring(title.lastIndexOf('(') + 1, title.lastIndexOf('(') + 5));
			title = title.substring(0, title.lastIndexOf('(')) + title.substring(title.lastIndexOf(')') + 1);
		}
		
		line = line.substring(line.lastIndexOf(',') + 1);
		
		if(line.indexOf("(no genres listed") == -1) {
			genres = line.split("\\|");
		}
		
		return new Movie(id, year, title, genres);
	}
	
	public void translateLinks(Movie m, String line) {
		line = line.substring(line.indexOf(",") + 1);
		String imdb = line.substring(0, line.indexOf(","));
		line = line.substring(line.indexOf(",") + 1);
		String tmdb;
		try {
			tmdb = line.substring(0);
		} catch(StringIndexOutOfBoundsException e) {
			tmdb = "-1";
		}
		
		m.setLinks(imdb, tmdb);
	}
	
	public Rating translateRating(String line) {
		int userID;
		int movieID;
		double stars;
		long timeStamp;
		userID = Integer.parseInt(line.substring(0, line.indexOf(",")));
		line = line.substring(line.indexOf(",") + 1);
		movieID = Integer.parseInt(line.substring(0, line.indexOf(",")));
		line = line.substring(line.indexOf(",") + 1);
		stars = Double.parseDouble(line.substring(0, line.indexOf(",")));
		line = line.substring(line.indexOf(",") + 1);
		timeStamp = Long.parseLong(line.substring(0));
		return new Rating(userID, movieID, stars, timeStamp);
	}
	
	
}
