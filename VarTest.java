public class VarTest {

	private int i;
	private double d;
	private char c;
	private boolean b;
	private String s;

	public VarTest() {
		i = 98;
		c = '&';
		s = "yo yo yo";
	}

	public VarTest( String t ) {

	}

	public int getI() {
		return i;
	}
	public double getD() {
		return d;
	}
	public char getC() {
		return c;
	}
	public boolean getB() {
		return b;
	}
	public String getS() {
		return s;
	}

	public statuc void main(String[] args) {

		VarTest v = new VarTest();

		System.out.println( v.getI() + " " + v.getD() + " " + v.getC() + " " + v.getB() + " " + v.getS() );

	}
}

