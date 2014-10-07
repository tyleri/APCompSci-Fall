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

	public void display() {
		System.out.println( numer + "/" + denom );
	}

	public double floatValue() {
		return (double) numer / denom;
	}

	public void multiply( RationalNumber rn ) {
		numer *= rn.numer;
		denom *= rn.denom;
	}

	public void add( RationalNumber rn ) {
		int n1 = numer;
		int d1 = denom;
		int n2 = rn.numer;
		int d2 = rn.denom;
		denom = d1 * d2;
		numer = n1 * d2 + n2 * d1;
	}

	public void subtract( RationalNumber rn ) {
		int n1 = numer, d1 = denom, n2 = rn.numer, d2 = rn.denom;
		denom = d1 * d2;
		numer = n1 * d2 - n2 * d1;
	}

	public int gcd() {
		int a = denom, b = numer;
		if (a % b == 0)
			return b;
		else {
			while (a % b != 0) {
				int temp = a % b;
				a = b;
				b = temp;
			}
			return b;
		}

	}

	public String toString() {
		return numer + "/" + denom;
	}

	public void reduce() {
		int gcd = gcd();
		numer /= gcd;
		denom /= gcd;
	}

	// Main method

	public static void main(String[] args) {

		RationalNumber a = new RationalNumber();
		RationalNumber b = new RationalNumber(5, 2);
		System.out.printf("a = %f = ", a.floatValue());
		a.display();
		System.out.printf("b = %f = ", b.floatValue());
		b.display();

		System.out.println();
		a = new RationalNumber(2, 7);
		System.out.printf("a = %f = ", a.floatValue());
		a.display();

		System.out.println();
		System.out.println("Multiplying b by a");
		b.multiply(a);
		System.out.printf("b = %f = ", b.floatValue());
		b.display();

		System.out.println();
		System.out.println("Adding a to b");
		b.add(a);
		System.out.printf("b = %f = ", b.floatValue());
		b.display();

		System.out.println();
		System.out.println("Subtracting b by a");
		b.subtract(a);
		System.out.printf("b = %f = ", b.floatValue());
		b.display();

		System.out.println();
		System.out.printf("The GCD of b is %d\n", b.gcd());

		System.out.println();
		System.out.println("Reducing b");
		b.reduce();
		System.out.printf("b = %f = ", b.floatValue());
		b.display();
		System.out.println();
		System.out.println("b is equal to " + b);
	}

}
