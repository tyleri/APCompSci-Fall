public class Game {
	public static void main(String[] args) {

		Mage m = new Mage("Fred");
		Warrior w = new Warrior("Wilson");
		Character c = new Character();

		System.out.println("Mage:");
		System.out.println(m);
		System.out.println("Warrior:");
		System.out.println(w);
		System.out.println("Character:");
		System.out.println(c);
		System.out.println();

		while (m.isAlive()) {
			System.out.println(w.name + " attacks " + m.name);
			System.out.println(m.name + " takes " + w.attack(m) +
					" damage");
			System.out.println(m);
			System.out.println();
		}
		
		System.out.println(m.name + " has died");

	}
}
