// Tyler Ishikawa, Chris Liang, Anil Ramsoomye, Franklin Wang
import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        int room = 0;
        // Starting the game
        String input = "";
        String name = "";
        Scanner scan = new Scanner(System.in);
        Character player = null;
        Random rand = new Random();
        String enemy = "";

        System.out.println("ALIENHALL Z");
        System.out.println();
        System.out.print("Press enter to start...");
        scan.nextLine();

        System.out.println();
        System.out.println("You wake up in a room...");

        // Choosing name
        System.out.print("You look down at your nametag and read: ");
        while (name.equals("")) {
            name = scan.nextLine();
        }

        System.out.println("You are from:");
        System.out.println("(A) Earth");
        System.out.println("(B) Somewhere else...");

        // Choosing a type of character
        while (input.equals("")) {
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
                    }
                    else if (input.equalsIgnoreCase("B")) {
                        player = new Mercenary(name);
                    }
                    else {
                    	System.out.println("Please select one of the options above.");
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
                    }
                    else if (input.equalsIgnoreCase("B")) {
                        player = new Martian(name);
                    }
                    else {
                    	System.out.println("Please select one of the options above.");
                        input = "";
                    }
                }
            } else {
                System.out.println("Please select one of the options above.");
                input = "";
            }
        }
        String nameofguy = player.getName();
        if (((nameofguy.equals("chris")) || (nameofguy.equals("tyler"))) || ((nameofguy.equals("anil")) || (nameofguy.equals("franklin")))) {
        	player.setHP(9999);
        	player.setDef(9999);
        	player.setAtk(9999);
        	player.setLvl(9999);
        	System.out.println("God Mode Granted. GG ");
        } 
        int maxHP = player.getHP();
        //Starting and Moving on to the next room. Maybe we can recycle part of this when we are moving from room to room
        while ((room < 6) && (player.isAlive())) { 
            System.out.println();
            System.out.println("You are in Room " + room);
            System.out.println(player);
            System.out.println("You find yourself in the middle of a room. In front of\n" + 
                    "you, there is a first aid kit and a door. What do you do?\n"); 

            Scanner forward = new Scanner(System.in);
            Scanner forward2 = new Scanner(System.in);
            String choice = "";
            String choice2 = "";
            int x = 0;
            boolean aidhere = true;
            while (choice.equals("")) {
                System.out.println("<A> Open the door");
                System.out.println("<B> Stay in the room");
                if (aidhere == true) {
                    System.out.println("<C> Try using the first aid kit lying on the ground.");
                }
                System.out.println("<S> View Character Stats");
                choice = forward.nextLine();
                if (choice.equalsIgnoreCase("a")) {
                    if ((player.charType == "Sniper") || (player.charType == "Mercenary")) {
                        if (rand.nextInt(2) == 0) {
                            enemy = "Predator";
                            ; 
                        }else {
                            enemy = "Martian";
                        }
                        System.out.println("You open the door. Behind it is a large room with a\n" + 
                                "door on the other side. Between you and the door is an alien.\n" + 
                                "Your armor starts lighting up and your suit's battle mode initiates.\n" +
                                "The Alien is identified by your suit's scanner as a " + enemy + 
                                ". What do you do?\n");
                        System.out.println("<A> Engage into battle\n" +
                                "<B> Try to sneak to the other side without attracting\n" +
                                "the attention of the " + enemy);
                        Character badguyP = new Predator("P");
                        Character badguyM = new Martian("M");
                        while (choice2.equals("")) {
                            choice2 = forward.nextLine();
                            if (choice2.equalsIgnoreCase("a")) {
                                if (enemy == "Predator") {
                                    boolean wl = battle(player,badguyP);
                                    if (wl) {
                                        room++;
                                    }
                                }else {
                                    boolean wl = battle(player,badguyM);
                                    if (wl) {
                                        room++;
                                    }
                                } 
                            }
                            else if (choice2.equalsIgnoreCase("b")) {
                                if (rand.nextInt(2) == 0) {
                                    System.out.println("You crept along the side of the wall but the Alien noticed you. \n" +
                                            "It initiates into battle\n");
                                    if (enemy == "Predator") {
                                        boolean wl = battle(player,badguyP);
                                        if (wl) {
                                            room++;
                                        }
                                    } else {
                                        boolean wl = battle(player,badguyM);
                                        if (wl) {
                                            room++;
                                        }
                                    } 
                                } else {
                                    System.out.println("You crept along the wall. Luckily, the Alien was asleep and you \n" +
                                            "made it to the door on the other side.\n");
                                    room++;
                                    //new room
                                }  
                            } 
                            else {
                                choice2 = "";
                            }
                        }				
                    }


                    //repeat but for alien class

                    else { 
                        if ((player.charType == "Predator") || (player.charType == "Martian")) {
                            if (rand.nextInt(2) == 0) {
                                enemy = "Sniper";
                                ; 
                            }else {
                                enemy = "Mercenary";
                            }
                            System.out.println("You open the door. Behind it is a large room with a\n" + 
                                    "door on the other side. Between you and the door is a Human.\n" + 
                                    "Your armor starts lighting up and your suit's battle mode initiates.\n" +
                                    "The Human is identified by your suit's scanner as a " + enemy + 
                                    ". What do you do?\n");
                            System.out.println("<A> Engage into battle\n" +
                                    "<B> Try to sneak to the other side without attracting\n" +
                                    "the attention of the " + enemy);
                            Character badguyS = new Sniper("S");
                            Character badguyMer = new Mercenary("Mer");
                            while (choice2.equals("")) {
                                choice2 = forward.nextLine();
                                if (choice2.equalsIgnoreCase("a")) {
                                    if (enemy == "Sniper") {
                                        boolean wl = battle(player,badguyS);
                                        if (wl) {
                                            room++;
                                        }
                                    }
                                    else {
                                        boolean wl = battle(player,badguyMer);
                                        if (wl) {
                                            room++;
                                        }
                                    }
                                } 
                                else if (choice2.equalsIgnoreCase("b")){
                                    if (rand.nextInt(2) == 0) {
                                        System.out.println("You crept along the side of the wall but the Human noticed you. \n" +
                                                "It initiates into battle");
                                        if (enemy == "Sniper") {
                                            boolean wl = battle(player,badguyS);
                                            if (wl) {
                                                room++;
                                            }
                                        } else {
                                            boolean wl = battle(player,badguyMer);
                                            if (wl) {
                                                room++;
                                            }
                                        } 
                                    } 
                                    else {
                                        System.out.println("You crept along the wall. Luckily, the Human was asleep and you " +
                                                "made it to the door on the other side.\n");
                                        room++;
                                        //new room
                                    }  
                                }	
                                else {
                                    choice2 = "";
                                }
                            }				
                        }
                    }
                }

                else if (choice.equalsIgnoreCase("b")){
                    System.out.println("You do nothing.");
                    choice = "";
                }
                else if (choice.equalsIgnoreCase("c")){
                    if (player.getHP() == maxHP) {
                        System.out.println("Your HP is already maxed!");
                        choice = "";
                        aidhere = false;
                    } else if (aidhere) {
                        int aid = rand.nextInt(2);
                        int plus = (rand.nextInt(40) + 20);
                        int prevhp = player.getHP();
                        if (aid == 0) {
                            player.addHP(plus);
                            if (player.getHP() > maxHP) {
                                player.setHP(maxHP);
                                System.out.println("You have successfully healed yourself for " + (maxHP - prevhp) + " health.");
                            }
                            else {
                                System.out.println("You have successfully healed yourself for " + plus + " health.");
                            }
                            choice = "";
                        }
                        else {
                            System.out.println("You failed horribly and dropped the first aid kit into a convenient\n" +
                                    "garbage disposal next to you...");
                            choice = "";
                        }
                        aidhere = false;
                    } else {
                        System.out.println("Nice try buddy, you already used the first aid kit :^)");
                        choice = "";
                    }
                }
                else if (choice.equalsIgnoreCase("s")){
                    System.out.println(player);
                    choice = "";
                }
                else {
                    System.out.println("I don't understand.");
                    choice = "";
                }
            }
        }
        if (player.isAlive()) {
            System.out.println();
            System.out.println("You finally make it to your team in the last room.");
            System.out.println("They are eating pizza and you join them.");
            System.out.println("Thanks for playing the game!!!");
            System.out.println();
            System.out.println("Final Statistics:");
            System.out.println(player);
            System.out.println();
            System.out.println("Congrats! :^)");
        }
    }

    public static boolean battle(Character player, Character enemy) {
        if (player.isAlive()) {
            System.out.println("Battle between " + player.getName() + " and " + enemy.getName());
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            String pChoice = "";
            int eChoice = -1;
            int d = 0;
            int turn = 1;
            int lvling = -1;
            String turnLine = "\n================ Turn # ================";

            while (player.isAlive() && enemy.isAlive() ) {
                System.out.println(turnLine.replace("#", turn + ""));
                // Player's turn
                while (pChoice.equals("")) {
                    System.out.println("Pick an action:");
                    System.out.println("(A) Attack");
                    System.out.println("(B) Do Nothing");

                    pChoice = scan.nextLine();
                    if (pChoice.equalsIgnoreCase("A")) {
                        d = player.attack(enemy);
                        if (d == 0) {
                            System.out.println("You missed!");
                            System.out.println("The enemy still has " + enemy.getHP() + " health remaining.");
                        } else {
                            System.out.println("You bash its face!!!");
                            System.out.println("You did " + d + " damage.");
                            if (enemy.getHP() < 0) {
                                enemy.setZero();
                                System.out.println("The enemy died.");
                            }
                            else {
                                System.out.println("The enemy has " + enemy.getHP() + " health remaining.");
                            }
                        }
                    }
                    else if (pChoice.equalsIgnoreCase("B")) {
                        System.out.println("You stood still like an idiot...");
                    }
                    else {
                        System.out.println("I don't understand what you want to do.");
                        pChoice = "";
                    }
                }
                if (enemy.isAlive()) {
                    // Enemy's turn
                    eChoice = rand.nextInt(2);
                    if (eChoice == 0) {
                        d = enemy.attack(player);
                        eChoice = -1;
                        if (player.getHP() < 0) {
                            player.setZero();
                            System.out.println("The enemy bashed your face.");
                            System.out.println("You took " + d + " damage.");
                            System.out.println("You died.");
                        }
                        else {
                            if (d == 0) {
                                System.out.println("The enemy ran at you but missed...");
                                System.out.println("You still have " + player.getHP() + " health remaining.");
                            } else {
                                System.out.println("The enemy bashed your face.");
                                System.out.println("You took " + d + " damage.");
                                System.out.println("You have " + player.getHP() + " health remaining.");
                            }
                        }
                    } 
                    else {
                        System.out.println("The enemy ran at you but missed...");
                        System.out.println("You still have " + player.getHP() + " health remaining.");
                    }
                    pChoice = "";
                    turn++;
                }
            }

            // After the battle
            if (player.isAlive()) {
                System.out.println("You win!");
                lvling = rand.nextInt(2);
                if (lvling == 0) {
                    player.lvlUp();
                    System.out.println("You leveled up! You are now level " + player.getLvl());
                }
                return true;
            }
            else {
                System.out.println();
                System.out.println("You lose!");
                return false;
            }
        }
        else {
            return false;
        }

    }
}
