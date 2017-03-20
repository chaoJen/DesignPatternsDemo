public class Main {

	public static void main(String[] args) {

		Display d1 = new Display(new StringDisplayImp1("hello, Japan"));
		Display d2 = new CountDisplay(new StringDisplayImp1("hello, world"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImp1("hello, Universe"));

		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);
	}
}