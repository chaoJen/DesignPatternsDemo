package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {

	private PageMaker() {

	}

	public static void makeWelcomePage(String mailaddr, String filename) {

		try {

			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph("歡迎來到" + username + "的網頁。");
			writer.paragraph("等你來信喔！");
			writer.mailto(mailaddr, username);
			writer.close();

			System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}