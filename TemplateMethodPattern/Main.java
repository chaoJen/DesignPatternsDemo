public class Main {

	public static void main(String[] args) {

		AbstractDisplay d1 = new CharDisplay('E');
		AbstractDisplay d2 = new StringDisplay("hello, world");

		d1.display();
		d2.display();
	}
}