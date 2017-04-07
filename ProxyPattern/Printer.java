public class Printer implements Printable {

	private String name;

	public Printer() {

		heavyJob("creating Printer instance.");
	}

	public Printer(String name) {

		this.name = name;
		heavyJob("creating Printer instance(" + name + ").");
	}

	public void setPrinterName(String name) {

		this.name = name;
	}

	public String getPrinterName() {

		return name;
	}

	public void print(String string) {

		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}

	private void heavyJob(String string) {

		System.out.print(string);

		for (int i = 0; i < 5; ++i) {
			
			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

			}

			System.out.print(".");
		}

		System.out.println("done.");
	}
}