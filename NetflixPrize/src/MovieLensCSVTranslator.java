
public class MovieLensCSVTranslator {

	public Movie translateMovie(String line) {
		
		int id;
		String title;
		int year;
		String[] genre;
		
		int count = 0;
		
		while(line.charAt(0) != ',') {
			count++;
		}
		
		id = Integer.parseInt(line.substring(0, count));
		
		System.out.println(id);
		
		
		
		
		
		return null;
	}
		
}
