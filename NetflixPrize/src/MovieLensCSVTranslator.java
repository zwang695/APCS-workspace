import java.util.ArrayList;
import java.util.Arrays;

public class MovieLensCSVTranslator {
	
	public Movie translateMovie(String line) {
		int id;
		int year;
		String title;
		String[] genres;
		boolean hasQuotes = false;
		int index = line.indexOf(',');
		
		id = Integer.parseInt(line.substring(0, index));
		
		line = line.substring(index + 1);
		
		title = line.substring(0, line.lastIndexOf(','));
		
		
		if(title.lastIndexOf('(') == -1) year = -1;
		else {
			year = Integer.parseInt(title.substring(title.lastIndexOf('(') + 1, title.lastIndexOf(')')));
			title = title.substring(0, title.lastIndexOf('(')) + title.substring(title.lastIndexOf(')') + 1);
		}
		System.out.println(title + " " + year);
		
		line = line.substring(line.lastIndexOf(',') + 1);
		
		
		
		
		
		return null;
	}
	
}
