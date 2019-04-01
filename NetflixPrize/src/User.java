
import java.util.ArrayList;

public class User {

	private int id;
	private ArrayList<String> tags;
	private ArrayList<String> ratings;
	
	public User(int id) {
		this.id = id;
	}
	
	public void setRatings(ArrayList<String> ratings) {
		this.ratings = ratings;
	}
}