import java.util.Random;

public class Character {
	
	// Instance Variables
	protected String name;
	protected String charType;
	protected int hp;
	protected int lvl;
	protected int def;
	protected int atk;
	protected int location;

	// Constructors
	public Character(String n) {
		name = n;
		charType = getClass().getName();
		hp = 50;
		lvl = 1;
		atk = 10;
		def = 5;
		location = 1;
	}

	// Accessors
	public String getName() {
		return name;
	}

	public int getHP() {
		return hp;
	}

	public int getLvl() {
		return lvl;
	}

	public int getDef() {
		return def;
	}

	public int getAtk() {
		return atk;
	}

	public int getLocation() {
		return location;
	}

	// Mutators
	public void setName(String newName) {
		name = newName;
	}

	public void setHP(int newHP) {
		hp = newHP;
	}

	public void lvlUp() {
		lvl++;
	}

	public void setDef(int newDef) {
		def = newDef;
	}

	public void setAtk(int newAtk) {
		atk = newAtk;
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
		// Makes it so there is a chance to "miss"
		if (chance == 1) {
		    dmg = 0;
		}
		// Makes it so we dont have cases of negative damage
		if (dmg < 0) {
			dmg = 0;		
		}
		enemy.hp -= dmg;

		return dmg;
	}

	public void nextRoom () {
		location++;
	}

    public boolean isAlive() {
		return (hp > 0);
    }

    public void setZero() {
    	hp = 0;
    }

	public String toString() {
		String s = "";
		s += "Name: " + name + " (" + charType + ")" + "\n";
		s += "Health: " + hp + "\n";
		s += "Attack: " + atk + "\n";
		s += "Defense: " + def + "\n";
		s += "Level: " + lvl + "\n";
		return s;
	}
}
