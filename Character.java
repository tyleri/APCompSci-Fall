public class Character {
		
	String name;
	protected int health;
	int xp;
	int damage;

	public Character() {
		xp = 0;
		name = "Bob";
}

	public Character(String n) {
		name = n;
	}

	public void attack() {
		System.out.println( "I'm attacking!" );
	}

	public void attack( Character c ) {

	}

	public String toString() {
		String s = name + " ";
		s += health + " ";
		s += damage + " ";
		s += xp + " ";

		return s;
	}

}
