public class CountDisplay extends Display {

	public CountDisplay(DisplayImp1 imp1) {

		super(imp1);
	}

	public void multiDisplay(int times) {

		open();
		
		for (int i = 0; i < times; ++i) {
		
			print();
		}

		close();
	}
}