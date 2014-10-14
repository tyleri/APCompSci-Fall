public class Mage extends Character {

	int energy;

	public Mage() {
		health = 10;
		damage = 18;
		energy = 5;
	}

	public String toString() {
		String s = super.toString() + energy;
		return s;
}

	public void attack() {
		System.out.println( "pew pew" );
	}

}
