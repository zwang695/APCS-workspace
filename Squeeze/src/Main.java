import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Text file", "txt", "java");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	       System.out.println("You chose to open this file: " +
//	            chooser.getSelectedFile().getName());
	    	try {
		    	ArrayList<String> fileData = FileIO.readFile(chooser.getSelectedFile().getPath());
		    	
		    	for(int i = 0; i < fileData.size(); i++) {
		    		String s = fileData.get(i);
		    		int count = 0;
		    		for(int j = 0; j < s.length(); j++) {
		    			if(!Character.isWhitespace(s.charAt(j))) {
		    				break;
		    			}
		    			count++;
		    		}
		    		fileData.set(i, count + " " + s.substring(count));
		    	}
		    	
		    	FileIO.writeFile("squeeze.out.txt", fileData);
		    	
		    	unSqueeze("squeeze.out.txt", fileData);
		  
	    	} catch(IOException e) {
	    		JOptionPane.showMessageDialog(null, "Please select a different file");
	    	}
	    }
	    
	    //Improve ux (reprompt for exceptions)
	    // Mess with the Strings in the ArrayList to put the number of spaces in front of each line
	    // Write out that file data 
	    
	    
	}
	
	public static void unSqueeze(String filename, ArrayList<String> fileData) {
		for(int i = 0; i < fileData.size(); i++) {
    		String s = fileData.get(i);
    		int count = Character.getNumericValue(s.charAt(0));
    		s = s.substring(2);
    		for(int j = 0; j < count; j++) {
    			s = " " + s;
    		}
    		fileData.set(i, s);
		}
		try {
			FileIO.writeFile("squeeze.out.txt", fileData);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Please select a different file");
		}
	}
}
