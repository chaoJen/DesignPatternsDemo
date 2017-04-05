package game;

import java.util.Vector;
import java.util.Iterator;
import java.util.Random;

public class Gamer {

	private int money;
	private Vector fruits = new Vector();
	private Random random = new Random();
	private static String[] fruitsname = {
		"Apple", "Grape", "Banana", "Orange"
	};

	public Gamer(int money) {

		this.money = money;
	}

	public int getMoney() {

		return money;
	}

	public void bet() {

		int dice = random.nextInt(6) + 1;

		if (dice == 1) {
			
			money += 100;
			System.out.println("get more money");

		} else if (dice == 2) {
			
			money /= 2;
			System.out.println("half money...");
		
		} else if(dice == 6) {

			String f = getFruit();
			System.out.println("get fruit ! (" + f + ")");
			fruits.add(f);

		} else {

			System.out.println("...");
		}
	}

	public Memento createMemento() {

		Memento m = new Memento(money);
		Iterator it = fruits.iterator();

		while (it.hasNext()) {

			String f = (String)it.next();

			if (f.startsWith("good")) {
				
				m.addFruit(f);
			}
		}

		return m;
	}

	public void restoreMemento(Memento memento) {

		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	public String toString() {

		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	private String getFruit() {

		String prefix = "";

		if (random.nextBoolean()) {
			
			prefix = "good";
		}

		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}