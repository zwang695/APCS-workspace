import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static ArrayList<String> readFile(String filename) throws IOException{
		
		Scanner in = null;
		FileReader f = null;
		
		try {
			
			ArrayList<String> out = new ArrayList<String>();
			
			f = new FileReader(filename);
			in = new Scanner(f);
			
			while(in.hasNextLine()) {
				String line = in.nextLine();	
				out.add(line);
			}
		
			return out;
			
		} finally {
			if(in != null) in.close();
		}
	}
	
	public static void writeFile(String filename, ArrayList<String> fileData) throws IOException {
		FileWriter writer = new FileWriter(filename);
		
		for(String s : fileData) {
			writer.write(s + "\n");
		}
		
		writer.close();
	}
	
}
