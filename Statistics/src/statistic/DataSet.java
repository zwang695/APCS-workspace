package statistic;

import java.util.Arrays;

public class DataSet {
	
	private int[] data;
	
	private final int MAX_DATA_AMOUNT = 10000;
	
	private int realLength;
	
	public DataSet() {
		data = new int[MAX_DATA_AMOUNT];
	}
	
	public int[] readFile(String filename) {
		ArrayReader reader = new ArrayReader(filename);
		realLength = reader.fillArray(data);
		compact(0);
		return data;
	}
	
	public double calcAvg() {
		double sum = 0;
		for(int i = 0; i < realLength; i++) {
			int x = data[i];
			sum += x;
		}
		return sum/realLength;
	}
	
	public double calcStandardD() {
		double avg = calcAvg();
		int sum = 0;
		for(int i = 0; i < realLength; i++) {
			int x = data[i];
			sum += Math.pow(avg - x, 2);
		}
		return Math.sqrt(sum/(realLength-1));
	}
	
	public int calcMode() {
		int mode;
		mode = data[0];
	    int currCount = 0;
	    int index = 0;
	    for (int i = 0; i < realLength; i++) {
	        int count = 1;
	        for (int j = 0; j < realLength; j++) {
	            if (data[j] == data[i]) count++;
	            if (count > currCount) {
	            	if(j == realLength - 1) {
	            		index++;
	            		mode = data[i];
	            		break;
	            	}
	                mode = data[i];
	                currCount = count;
	            }
	        }
	    }
	    return mode;
	}
	
	public void compact(int val) {
		for(int i = 0; i < realLength; i++) {
			if(data[i]==val) {
				for(int j = i; j < realLength; j++) {
					data[j] = data[j + 1];
				}
				realLength--;
				i--;
			}
		}
	}
	
	public void insert(int val, int i) {
		for(int j = realLength - 1; j != i-1; j--) {
			data[j+1] = data[j];
		}
		data[i] = val;
		realLength++;
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
}
