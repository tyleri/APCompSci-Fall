public class Test {

	public static void main(String[] args) {

		Map s = new Map();

		for (int i = 1; i < 11; i++) {
			System.out.println("Level " + i);
			System.out.println(s);
			s.nextRoom();
		}
	}
}
