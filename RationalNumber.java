public class RationalNumber {

	private int numer;
	private int denom;

	// Constructors

	public RationalNumber() {
		numer = 0;
		denom = 1;
	}

	public RationalNumber( int n, int d ) {
		if (d == 0) {
			System.out.println("Invalid denominator");
			numer = 0;
			denom = 1;
		} else {
			numer = n;
			denom = d;
		}
	}

	// Methods

	public int getNumer() {
		return numer;
	}

	public int getDenom() {
		return denom;
	}

	public void display() {
		System.out.println( numer + "/" + denom );
	}

	public float floatValue() {
		return (float) numer / denom;
	}

	public void multiply( RationalNumber rn ) {
		numer *= rn.getNumer();
		denom *= rn.getDenom();
	}

	// Main method

	public static void main(String[] args) {

		RationalNumber a = new RationalNumber();
		RationalNumber b = new RationalNumber(5, 2);
		a.display();
		b.display();
		System.out.printf("The float value of a is %f\n", a.floatValue());
		System.out.printf("The float value of b is %f\n", b.floatValue());

		a = new RationalNumber(2, 7);
		a.display();

		b.multiply(a);
		b.display();
		System.out.printf("The float value of b is now %f\n", b.floatValue());

	}

}
