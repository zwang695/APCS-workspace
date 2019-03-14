package irs;

import java.text.NumberFormat;

/*
 * 450000 Married: 4
 * 170000 Single: 4
 * 30000 Married: 8
 * 45000 Single: 6
 */
public class TaxForm {

	private int filingStatus;
	private double taxableIncome;
	private double tax;
	
	public TaxForm(int filingStatus, double taxableIncome) {
		this.filingStatus = filingStatus;
		this.taxableIncome = taxableIncome;
		calcTax();
	}
	
	public int getFilingStatus() {
		return filingStatus;
	}
	
	public double getTaxableIncome() {
		return taxableIncome;
	}
	
	public double getTax() {
		return tax;
	}
	
	private void calcTax() {
		//if single
		if(filingStatus== 1) {
			if(taxableIncome > 500000) {
				tax = 150689.5 + 0.37 * (taxableIncome - 500000);
			}
			else if(taxableIncome > 200000) {
				tax = 45689.5 + 0.35 * (taxableIncome - 200000);
			}
			else if(taxableIncome > 157500) {
				tax = 32089.5 + 0.32 * (taxableIncome - 157500);
			}
			else if(taxableIncome > 82500) {
				tax = 14089.5 + 0.24 * (taxableIncome - 82500);
			}
			else if(taxableIncome > 38700) {
				tax = 4453.5 + 0.22 * (taxableIncome - 38700);
			}
			else if(taxableIncome > 9525) {
				tax = 952.5 + 0.12 * (taxableIncome - 9252);
			}
			else {
				tax = 0.1 * (taxableIncome);
			}
		}
		//if married
		else if(filingStatus == 2) {
			if(taxableIncome > 600000) {
				tax = 150689.5 + 0.37 * (taxableIncome - 600000);
			}
			else if(taxableIncome > 400000) {
				tax = 45689.5 + 0.35 * (taxableIncome - 400000);
			}
			else if(taxableIncome > 315000) {
				tax = 32089.5 + 0.32 * (taxableIncome - 315000);
			}
			else if(taxableIncome > 165000) {
				tax = 14089.5 + 0.24 * (taxableIncome - 165000);
			}
			else if(taxableIncome > 77400) {
				tax = 4453.5 + 0.22 * (taxableIncome - 77400);
			}
			else if(taxableIncome > 19050) {
				tax = 952.5 + 0.12 * (taxableIncome - 19050);
			}
			else {
				tax = 0.1 * (taxableIncome);
			}
		}
	}
	
}
