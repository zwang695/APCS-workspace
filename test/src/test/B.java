package test;

public class B extends A{

	private int z;
	
	public B(int z) {
		this.z = z;
	}
	
	public B(int x, int y) {
		super(x, y);
		z = 30;
	}
	
	public void print1() {
		System.out.println(z);
	}
	
}
