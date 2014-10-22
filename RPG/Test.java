public class Test {

	public static void main(String[] args) {

		Character c = new Character("Bob");
		Map m = new Map();

		for (int i = 1; i < 11; i++) {
			System.out.println( "Level " + c.getLocation() );
			m.display( c.getLocation() );
			c.nextRoom();
		}
	}
}
