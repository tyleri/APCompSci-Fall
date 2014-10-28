import java.util.Scanner;
import java.util.Random;

public class Game {

	public static void main(String[] args) {

		// Starting the game
		String input = "";
		String name = "";
		Scanner scan = new Scanner(System.in);
		Character player = null;
		Random rand = new Random();
		String enemy = "";
		String job = "";

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

			if (input.equalsIgnoreCase("A")) {
				input = "";
				System.out.println("Pick your job:");
				System.out.println("(A) Sniper");
				System.out.println("(B) Mercenary");

				while (input.equals("")) {
					input = scan.nextLine();

					if (input.equalsIgnoreCase("A")) {
						player = new Sniper(name);
						job = "Sniper";
					}
					else if (input.equalsIgnoreCase("B")) {
						player = new Merc(name);
						job = "Mercenary";
					}
					else {
						input = "";
					}
				}

			} else if (input.equalsIgnoreCase("B")) {
				input = "";
				System.out.println("Pick your race:");
				System.out.println("(A) Predator");
				System.out.println("(B) Martian");

				while (input.equals("")) {
					input = scan.nextLine();

					if (input.equalsIgnoreCase("A")) {
						player = new Predator(name);
						job = "Predator";
					}
					else if (input.equalsIgnoreCase("B")) {
						player = new Martian(name);
						job = "Martian";
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
		System.out.println("You find yourself in the middle of a room. In front of,\n" + 
			"you, there are two doors. The left door is blue and the \n" +
			"right door is red. What do you do?"); 

		Scanner forward = new Scanner(System.in);
		Scanner forward2 = new Scanner(System.in);
		String choice = "";
		String choice2 = "";
		int x = 0;
		while (choice.equals("")) {
			System.out.println("<A> Left door (blue)");
			System.out.println("<B> Right door (red)");
			System.out.println("<C> Stay in the room");
			choice = forward.nextLine();
			if (choice.equalsIgnoreCase("a")) {
				if ((job == "Sniper") || (job == "Mercenary")) {
					if (rand.nextInt(2) == 0) {
						enemy = "Predator";
						; 
					}else {
						enemy = "Martian";
					}
					System.out.println("You open the left door. Behind it is a big room with a\n" + 
						"door on the other side. Between you and the door is an alien.\n" + 
						"Your armor which is so light that you did not realize you even had it,\n" +
						"starts lighting up and your suit's battle mode initates.\n" +
						"The alien is identified by your suit's scanner as a " + enemy + 
						". What do you do?");
					System.out.println("<A> Engage into battle\n" +
						"<B> Try to sneak to the other side without attracting\n" +
						"the attention of the " + enemy);
					Character badguyP = new Predator("P");
					Character badguyM = new Martian("M");
					choice = forward.nextLine();
					if (choice.equalsIgnoreCase("a")) {
						if (enemy == "Predator") {
							battle(player,badguyP);
						}else {
							battle(player,badguyM);
						} 

					} else{
						System.out.println("u suck.");
					}
				}
			}
			if (choice.equalsIgnoreCase("b")) {
				System.out.println("What room do you choose?");
			}
			if (choice.equalsIgnoreCase("c")) {
				System.out.println("What room do you choose?");
			}
			
			/*
			if (choice.equalsIgnoreCase("b")) {
				while (x == 0) {
					System.out.println("You sit down and try and remember what happened. \n" +
						"Your head starts to hurt and you black out. You \n" + 
						"wake up and find yourself in a room. Ahead of you, you\n" +
						"can see then rooms each illuminated by a dark light. The \n" +
						"last thing you can remember is that you were on your ship \n" + 
						"and were attacked by the enemy. You cannot remember anything \n" +
						"past that. Do you wish to move forward?");
					System.out.println("<A> Yes");
					System.out.println("<B> No");
					choice2 = forward2.nextLine();
					if (choice2.equalsIgnoreCase("a")) {
						x = 1;
					}
					else {
						x = 0;
						player.nextRoom();
					}
				}
			}
			else {
				player.nextRoom();
			}*/

		}



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




