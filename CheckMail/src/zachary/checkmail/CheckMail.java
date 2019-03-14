package zachary.checkmail;

import javax.swing.JOptionPane;

public class CheckMail {

	public static void main(String[] args) {
		
		double in1 = Double.parseDouble(JOptionPane.showInputDialog("Input first dimension"));
		double in2 = Double.parseDouble(JOptionPane.showInputDialog("Input second dimension"));
		double in3 = Double.parseDouble(JOptionPane.showInputDialog("Input third dimension"));
		double in4 = Double.parseDouble(JOptionPane.showInputDialog("Input weight"));
	
		Box b = new Box(in1, in2, in3, in4);
		
		JOptionPane.showMessageDialog(null, b.getStatus());
	}
	
}
