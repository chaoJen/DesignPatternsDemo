public class Main {

	public static void main(String[] args) {

		if (args.length != 1) {
			
			usage();
			System.exit(0);
		}

		if (args[0].equals("plain")) { 
			
			Director direct = new Director(new TextBuilder());
			String result = (String) direct.construct();
			System.out.println(result);
		} else if (args[0].equals("html")) {

			Director direct = new Director(new HTMLBuilder());
			String filename = (String) direct.construct();
			System.out.println("new " + filename + ".");
		} else {
			
			usage();
			System.exit(0);
		}
	}

	public static void usage() {

		System.out.println("Usage: java Main plain 產生一般文件");
		System.out.println("Usage: java Main html 產生 HTML 格式文件");
	}
}