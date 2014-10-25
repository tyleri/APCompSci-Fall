public class Martian extends Alien{

	public Martian(String n) {
		super(n);
		hp -= 10;
		atk += 3;
		def -= 2;
	}
}
