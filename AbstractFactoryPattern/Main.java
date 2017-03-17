import factory.*;

public class Main {

	public static void main(String[] args) {

		if (args.length != 1) {

			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}

		Factory factory = Factory.getFactory(args[0]);

		Link asahi = factory.createLink("朝日新聞", "http://www.asahi.cpm/");
		Link yomiuri = factory.createLink("讀賣新聞", "http://www.yomiuri.co.jp");
		Link usYahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jpYahoo = factory.createLink("Yahoo! Japan", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("Excite", "http://www.excite.com");
		Link google = factory.createLink("Google", "http://www.google.com/");

		Tray traynews = factory.createTray("News");
		traynews.add(asahi);
		traynews.add(yomiuri);

		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(usYahoo);
		trayyahoo.add(jpYahoo);

		Tray traysearch = factory.createTray("Search Site");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);

		Page page = factory.createPage("LinkPage", "Elliot");
		page.add(traynews);
		page.add(traysearch);
		page.output();
	}
}