package irs;

import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * +2 classes, good I/O, good real world modeling, nice fields and constructors
 * - lazy programming by making me enter a number to represent a string
 * ^ add a drop down menu for filing status
 */
public class IRS {

	public static void main(String args[]) {
		int status = Integer.parseInt(JOptionPane.showInputDialog("Choose Marital Status - 1 for Single, 2 for married"));
		double taxableIncome = Double.parseDouble(JOptionPane.showInputDialog("Enter taxable income:"));
		TaxForm tf = new TaxForm(status, taxableIncome);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		try {
			JOptionPane.showMessageDialog(null, "Enter marital status (1=single, 2=married): " + tf.getFilingStatus() + "\n" + "Enter taxable income: " + nf.format(tf.getTaxableIncome()) + "\n" + "Your Federal tax = " + nf.format(tf.getTax()), "Tax Information", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(java.lang.NumberFormatException e) {
			System.out.println("ok");
		}
	}
}
