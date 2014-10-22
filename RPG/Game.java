import java.util.Scanner;
import java.util.Random;

public class Game {

	public static void main(String[] args) {

		//Starting the game
		Character player1 = new Character("John");
		Character player2 = new Character("Tyler");
		// battle(player1, player2);
		for (int i = 0; i < 10; i++) {
			player1.attack(player2);
			System.out.println( player2.getHP() );
		}
	}

	public static boolean battle(Character player, Character enemy) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String pChoice = "";
		int eChoice = -1;
		int d = 0;

		while (player.isAlive() && enemy.isAlive() ) {

			// Player's turn
			while (pChoice == "") {
				System.out.println("Pick an action:");
				System.out.println("(A) Attack");
				System.out.println("(B) Do Nothing");

				pChoice = scan.nextLine();
				if (pChoice.equals("A")) {
					d = player.attack(enemy);
					System.out.println("You did " + d + " damage");
				}
				else if (pChoice.equals("B")) {}
				else {
					pChoice = "";
				}
			}

			// Enemy's turn
			eChoice = rand.nextInt(2);
			if (eChoice == 0) {
				d = enemy.attack(player);
				eChoice = -1;
			}
			System.out.println("You were dealt " + d + " damage");
			System.out.println("Your health is " + player.getHP());
		}

		// After the battle
		if (player.isAlive()) {
			System.out.println("You win!");
			return true;
		}
		else {
			System.out.println("You lose!");
			return false;
		}
	}
}
