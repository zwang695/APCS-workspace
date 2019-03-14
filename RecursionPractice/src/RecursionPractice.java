import java.util.Stack;

public class RecursionPractice {

	static int iterations;
	private static Stack<Integer> s1, s2, s3;
	private static Stack[] towers;
	
	public static int factorial(int n) {
		if(n==0) return 1;
		
		return n * factorial(n-1);
	}


	public static int squareNumber(int n) {
		if(n==1) return 1;
		
		return squareNumber(n - 1) + 2 * n - 1;
	}


	public static int logBase2(int n) {
		if(n==1) return 0;
		return 1 + logBase2(n / 2);
	}


	public static int pow(int n) {
		if(n==0) return 1;
		return 2 * pow(n - 1);
	}


	public static int pentagonalNumber(int n) {
		if (n == 1)
			return 1;
		else
			return 3 * n - 2 + pentagonalNumber(n - 1);
	}
	
	public static int fibonacciRec(int n) {
		iterations++;
		if (n == 1) return 1;
		else if (n == 2) return 1;
		else {
			return fibonacciRec(n - 1) + fibonacciRec(n - 2);
		}
	}
	
	public static int fibonacciLoop(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		int pNum = 1, sPNum = 1;
		for(int i = 3; i < n; i++) {
			iterations++;
			int sum = pNum + sPNum;
			sPNum = pNum;
			pNum = sum;
		}
		return pNum + sPNum;
	}
	
	public static void printHanoiSolution(int numberOfDisks) {
		solveHanoi(numberOfDisks, 1, 3);
	}

	private static void solveHanoi(int numDisks, int fromPeg, int toPeg) {
		iterations++;
		
		if(numDisks == 1) {
			System.out.println("Move the top disc from tower " + fromPeg + " to tower " + toPeg);
		}
		else {
			int otherPeg = 6 - (fromPeg + toPeg);
			solveHanoi(numDisks - 1, fromPeg, otherPeg);
			System.out.println("Move the top disc from tower " + fromPeg + " to tower " + toPeg);
			solveHanoi(numDisks - 1, otherPeg, toPeg);
		}
	}
	
	public static void main(String[] args) {
//		int n = 5;
//		int test = factorial(n);
//		System.out.println(n + " factorial is " + test);
//		n = 5;
//		test = squareNumber(n);
//		System.out.println(n + " squared is " + test);
//		n = 32;
//		test = logBase2(n);
//		System.out.println(n + " logBase2 is " + test);
//		n = 5;
//		test = pow(n);
//		System.out.println(n + " pow base 2 is " + test);
//		n = 5;
//		test = pentagonalNumber(n);
//		System.out.println(n + " pentagon Number is " + test);
//		n = 10;
//		iterations = 0;
//		long start = System.nanoTime();
//		test = fibonacciRec(n);
//		long end = System.nanoTime();
//		System.out.println("Output was " + test + " and it took " + (end-start) + " nanoseconds");
//		System.out.println(iterations);
//		n = 10;
//		iterations = 0;
//		start = System.nanoTime();
//		test = fibonacciLoop(n);
//		end = System.nanoTime();
//		System.out.println("Output was " + test + " and it took " + (end-start) + " nanoseconds");
//		System.out.println(iterations);
		
		iterations = 0;
		printHanoiSolution(3);
		System.out.println(iterations);
		
		
	}


}