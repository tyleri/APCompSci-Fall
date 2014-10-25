public class Boss extends Character {

	public Boss() {}

	public Boss( Character player ) {

		hp += 100;
		lvl = player.getLvl();
		def += 50;
		atk += 50;
		location = 10;
	}

}
