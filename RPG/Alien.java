public class Alien extends Character{

    public Alien(String n) {
	super(n);
	hp -= 10;
	atk += 5;
	def--;
    }

}
