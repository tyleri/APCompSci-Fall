public class Predator extends Alien{

    public Predator(String n) {
	super(n);
	hp += 30;
	atk -= 2;
	def++;
    }

}
