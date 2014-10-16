public class Game {
	public static void main(String[] args) {

		Mage m = new Mage();
		Warrior w = new Warrior();
		Character c = new Character();

		System.out.println(m);
		m.attack();
		System.out.println(w);
		w.attack();
		System.out.println(c);
		c.attack();

		Object o = new Warrior();
		System.out.println(o);
	}
}
