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
		    	
		    	for(String s: fileData) {
		    		System.out.println(s);
		    		for(int i = 0; i < s.length(); i++) {
		    			
		    		}
		    	}
		  
	    	} catch(IOException e) {
	    		JOptionPane.showMessageDialog(null, "Please select a different file");
	    	}
	    }
	    
	    
	    //Improve ux (reprompt for exceptions)
	    // Mess with the Strings in the ArrayList to put the number of spaces in front of each line
	    // Write out that file data 
	    
	    
	}
}
