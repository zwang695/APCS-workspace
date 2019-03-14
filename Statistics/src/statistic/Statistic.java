package statistic;

import java.util.Arrays;

public class Statistic {

	public static void main(String[] args) {
		DataSet d = new DataSet();
		int[] data = d.readFile("data/compact.txt");
		System.out.println(d.calcAvg());
		System.out.println(d.calcMode());
		System.out.println(d.calcStandardD());
		d.insert(3, 2);
		System.out.println(d.toString());
	}
}
