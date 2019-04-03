
public class Genre {
	
	public static final String[] AVAILGENRES = {"Action", "Adventure", "Animation", "Children", "Comedy", "Crime", "Documentary", "Drama", "Fantasy", "Film-Noir", 
			"Horror", "Musical", "Mystery", "Romance", "Sci-Fi", "Thriller", "War", "Western", "(no genres listed)"};
	private String name;
	private double avgR;
	
	public Genre(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public void setAvgR(double avgR) {
		this.avgR = avgR;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCount() {
		for(int i = 0; i < AVAILGENRES.length; i++) {
			if(AVAILGENRES[i] == name) return i;
		}
		return -1;
	}
}
