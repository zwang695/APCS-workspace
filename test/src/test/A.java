package test;

public class A {

	private int x;
	protected int y;
	
	public A() {
		x = 15;
		y = 20;
	}
	
	public A(int x_, int y_) {
		x = x_;
		y = y_;
	}
	
	public void print1() {
		System.out.println(x);
	}
	
	public void print2() {
		System.out.println(y);
	}
	
}
