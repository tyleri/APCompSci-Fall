import java.util.Scanner;
import java.util.Random;

public class Game {

	public static void main(String[] args) {

		// Starting the game
		String input = "";
		String name = "";
		Scanner scan = new Scanner(System.in);
		Character player = null;

		System.out.println("ALIENHALL Z");
		System.out.println();
		System.out.print("Press enter to start...");
		scan.nextLine();

		System.out.println();
		System.out.println("You wake up in a room...");

		// Choosing name
		System.out.print("You look down at your nametag and read: ");
		while (name.equals(""))
			name = scan.nextLine();

		System.out.println("You are from:");
		System.out.println("(A) Earth");
		System.out.println("(B) Somewhere else...");

		// Choosing a type of character
		while (input.equals("")){
			input = scan.nextLine();

			if (input.equalsIgnoreCase("A")) { // chose human
				input = "";
				System.out.println("Pick your job:");
				System.out.println("(A) Sniper");
				System.out.println("(B) Merc");

				while (input.equals("")) {
					input = scan.nextLine();

					if (input.equalsIgnoreCase("A")) {
						player = new Sniper(name); // Sniper class
					}
					else if (input.equalsIgnoreCase("B")) {
						player = new Merc(name); //Merc class
					}
					else {
						input = "";
					}
				}
			} else if (input.equalsIgnoreCase("B")) { // chose Alien
				input = "";
				System.out.println("Pick your race:");
				System.out.println("(A) Predator");
				System.out.println("(B) Martian");

				while (input.equals("")) {
					input = scan.nextLine();

					if (input.equalsIgnoreCase("A")) {
						player = new Predator(name); // Predator class
					}
					else if (input.equalsIgnoreCase("B")) {
						player = new Martian(name); // Martian class
					}
					else {
						input = "";
					}
				}
			} else {
				System.out.println("Please pick one of the options above");
				input = "";
			}
		}
		//Starting and Moving on to the next room. Maybe we can recycle part of this when we are moving from room to room

		System.out.println(player);

		String choice = "";
		Scanner forward = new Scanner(System.in);
		while (choice.equalsIgnoreCase("")) {
			System.out.println("You find yourself in a room. Ahead of you, you can see ten rooms each illuminated by a dark light. The last thing you can remember is that you were on your ship and were attacked by the enemy. You cannot remember anything past that. Do you wish to move forward?"); 
			System.out.println("<A> Yes");
			System.out.println("<B> No");
			choice = forward.nextLine();
			if (choice.equalsIgnoreCase("B")) {
				System.out.print("You sit down and try and remember what happened. Your head starts to hurt and you black out. ");
				choice = "";
			}
		}

			player.nextRoom();

	}

	public static boolean battle(Character player, Character enemy) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String pChoice = "";
		int eChoice = -1;
		int d = 0;
		int turn = 1;
		String turnLine = "================ Turn # ================";

		while (player.isAlive() && enemy.isAlive() ) {
			System.out.println(turnLine.replace("#", turn + ""));
			// Player's turn
			while (pChoice.equals("")) {
				System.out.println("Pick an action:");
				System.out.println("(A) Attack");
				System.out.println("(B) Do Nothing");

				pChoice = scan.nextLine();
				if (pChoice.equals("A") || pChoice.equals("a")) {
					System.out.println("You charge in!!!");
					d = player.attack(enemy);
					if (enemy.getHP() < 0) {
						enemy.setZero();
					}
					System.out.println("You did " + d + " damage");
					System.out.println("The enemy has " + enemy.getHP() + " health remaining.");
				}
				else if (pChoice.equals("B") || pChoice.equals("b")) {
					System.out.println("You stood still like an idiot...");
				}else {
					System.out.println("Invalid choice");
					pChoice = "";
				}
			}

			// Enemy's turn
			eChoice = rand.nextInt(2);
			if (eChoice == 0) {
				d = enemy.attack(player);
				eChoice = -1;
				if (player.getHP() < 0) {
					player.setZero();
					System.out.println("You died.");
				}
				System.out.println("The enemy came crashing towards you.");
				System.out.println("You took " + d + " damage");
				System.out.println("You have " + player.getHP() + " health remaining.");
			} else {
				System.out.println("The enemy ran at you but missed...");
				System.out.println("You still have " + player.getHP() + " health remaining.");
			}
			pChoice = "";
			turn++;
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
