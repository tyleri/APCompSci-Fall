import java.util.Random;

public class Character {
	
	//Instance Variables
	private int hp;
	private String name;
	private int exp;
	private int lvl;
	private int def;
	private int atk;
	private Room currRoom;

	//Constructors
	public Character(String n) {
		hp = 100;
		name = n;
		exp = 0;
		lvl = 1;
		atk = 5;
		def = 5;
		currRoom = new Room(1);
	}

	//Accessors
	public int getHP() {
		return hp;
	}

	//Methods
	public int attack(Character enemy) {
		Random d = new Random();
		int crit = 0;
		int dmg = ((lvl * atk) - enemy.def);
		int chance = d.nextInt(10);
		if (chance == 0) {
			crit = d.nextInt(6) + 5;
			dmg += crit;
			}
		//Makes it so there is a chance to "miss"
		if (chance == 1) {
		    dmg = 0;
		}
		//Makes it so we dont have cases of negative damage
		if (dmg > 0) {
		    enemy.hp -= dmg;
		}
		else {
		    dmg = 0;
		}
		return dmg;
	}

	public int getLocation() {
		return currRoom.getLocation();
	}

	public void nextRoom () {
		int nextLoc = currRoom.getLocation() + 1;
		currRoom = new Room(nextLoc);
	}

    public boolean isAlive() {
		return hp > 0;
    }

	public String toString() {
		String s = "";
		s += "Name: " + name + "\n";
		s += "Health: " + hp + "\n";
		s += "Attack: " + atk + "\n";
		s += "Defense: " + def + "\n";
		s += "Experience: " + exp + "\n";
		s += "Level: " + lvl + "\n";
		return s;
	}
}
