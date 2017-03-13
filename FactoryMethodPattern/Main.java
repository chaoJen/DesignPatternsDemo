import framework.*;
import idcard.*;

public class Main {

	public static void main(String[] args) {

		Factory factory = new IDCardFactory();
		Product product1 = factory.create("Elliot");
		Product product2 = factory.create("Rey");
		Product product3 = factory.create("Leah");
		Product product4 = factory.create("Lara");
		
		product1.use();
		product2.use();
		product3.use();
		product4.use();
	}
}