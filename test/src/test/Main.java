package test;

public class Main {

	public static void main(String[] args) {
		A obj1 = new A();
		obj1.print1();
		B obj2 = new B(5);
		obj2.print1();
		B obj3 = new B(5);
		obj3.print2();
		A obj4 = new A(5, 10);
		obj4.print1();
		A obj5 = new B(5, 10);
		obj5.print1();
		A obj6 = new B(5, 10);
		obj6.print2();
	}
}
