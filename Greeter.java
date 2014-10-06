public class Greeter {

	// Instance Variables
	private String message;
	private String receiver;
	private int times;

	// Methods
	public void setMessage( String m ) {
		message = m;
	}

	public void setReceiver (String r) {
		receiver = r;
	}

	public void setTimes( int t ) {
		times = t;
	}

	public String getMessage() {
		return message;
	}

	public String getReceiver() {
		return receiver;
	}

	public int getTimes() {
		return times;
	}

	public void greet() {
		System.out.println( message + " " + receiver );
	}

	public void greet( String name ) {
		System.out.println( message + " " + name );
	}

	public void greetMultiple() {
		for (int count = 0; count < times; count++) 
			System.out.println( message + " " + receiver);
	}

	public void greetMultiple( String name ) {
		for (int count = 0; count < times; count++) 
			System.out.println( message + " " + name);
	}

	public static void main( String[] args ) {
		Greeter g = new Greeter();

		g.setMessage( "Good afternoon" );
		g.greet();
		System.out.println();

		g.setReceiver( "George" );
		g.greet();
		System.out.println();

		g.setTimes( 5 );
		g.greetMultiple();
	}
}
