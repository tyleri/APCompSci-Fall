import java.util.Scanner;
import java.util.Random;

public class Room {

	private int type; // 1 = fighting, 2 = shop, 3 = nothing
	private int location; // map class will have a list of #'d rooms
	
	public Room (int roomNum) {
		type = 1; // making all the rooms fighting for now
		location = roomNum;
	}

	// Returns the number of the room
	public int getLocation() {
		return location;
	}

	public boolean battle(Character player, Character enemy) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String pChoice = "";
		int eChoice = -1;

		while (player.getHealth() > 0 && enemy.getHealth() > 0) {

			// Player's turn
			while (pChoice == "") {
				System.out.println("Pick an action:");
				System.out.println("(A) Attack");
				System.out.println("(B) Do Nothing");

				pChoice = scan.nextLine();
				if (pChoice == "A")
					player.attack(enemy);
				else if (pChoice == "B");
				else
					pChoice = "";
			}

			// Enemy's turn
			eChoice = rand.nextInt(2);
			if (eChoice == 0)
				enemy.attack(player);
		}

		// After the battle
		if (enemy.getHealth() == 0) {
			System.out.println("You win!");
			return true;
		}
		else {
			System.out.println("You lose!");
			return false;
		}
	}

}
