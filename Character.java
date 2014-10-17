public class Character {
		
	String name;
	int life;
	int strength;
	int defense;
	int attRating;

	public Character() {
		name = "Bob";
		life = 500;
		strength = 10;
		defense = 10;
		attRating = 10;
	}

	public boolean isAlive() {
		return life > 0;
	}

	public int attack( Character c ) {
		int damage = strength * attRating - c.defense;
		if (damage < 0)
			damage = 0;
		else if (damage > c.life)
			damage = c.life;
		c.life -= damage;
		return damage;
	}

	public String toString() {
		String s = name + " ";
		s += life + " ";
		s += strength + " ";
		s += defense + " ";
		s += attRating;

		return s;
	}

}
