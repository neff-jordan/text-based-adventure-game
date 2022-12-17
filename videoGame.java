package testBasedAdventure;

import java.util.Random;
import java.util.Scanner;

public class videoGame {

	public static void main(String[] args) {

		// System objects
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		// Game Variables level 1 
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassain"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 15;
		
		// Game variables level 2
		String[] beast = { "golum", "dragon"};
		int beasthealth = 100;
		int beastAttack = 50;
		
		// Game variables level 3
		String raidriar = "God King";
		int kingHealth = 150;
		int kingAttack = 100;
		
		// Player Variables 
		int health = 500; 
		int attackDamage = 100;
		int numStimContainers = 3;
		int healthStimAmount = 30;
		int healthStimDropChance = 50; // percentage
		int key = 0;
		int keyDropChance = 50; // percentage
		
		boolean running = true; 
		
		System.out.println("Welcome to level 1 - the battlefield ");
		
		// level 1 = Collect as many potion's as you can by killing the beasts
		
		GAME:
		while(running) {
			
			System.out.println("---------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\t Your HP " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\t What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");
				
				String in = input.nextLine();
				if(in.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage); 
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t You receive " + damageTaken + " in retalliation.");
					
					if(health < 1) { 
						System.out.println("\t> You have taken too much damage.");
						break;
					}
					
				}
				else if(in.equals("2")) {
					
					if(numStimContainers > 0) {
						health += healthStimAmount;
						numStimContainers --;
						System.out.println("\t> You drank a health potion and healed" + healthStimAmount + "." 
										 + "\n\t> You now have " + health + "HP."
										 + "\n\t> You have " + numStimContainers + "left. \n");
					}
					
					else { 
						System.out.println("\t> You have no health potions left. Defeat enemies for a chanve to get one. ");
					}
					
				}
				else if(in.equals("3")) {
					
					System.out.println("\t You run away from the " + enemy + ".");
					continue GAME;
					
				}
				else {
					System.out.println("\t invalid conmmand");
				}
				
			}
			
			
			if(health < 1) {
				System.out.println("you limp out the game");
				break;
			}
			
			System.out.println("---------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + "HP left # ");
			if(rand.nextInt(100) < healthStimDropChance) {
				numStimContainers++;
				System.out.println(" # The " + enemy + " dropped a stim container # ");
				System.out.println(" # YOu have " + numStimContainers + " stim containers # ");
				
			}
			
			System.out.println("---------------------------------------");
			System.out.println(" WHat would you  like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Climb the mountain - level 2");
			
			String in = input.nextLine();
			
			while (!in.equals("1") && !in.equals("2")) {
				System.out.println("invalid command");
				in = input.nextLine();
			}

			if(input.equals("1")) { 
				
				System.out.println("You continue on the fight");
			}
			else if (in.equals("2")) { 
				System.out.println("You have exitied the battlefield and climbed the mountain");
				break;
			}
			
		}
			
		// level 2 = kill the beasts until you get the key to the temple
		
		GAME2:
		while(running) {
			
			System.out.println("---------------------------------------");
			
			int beastHealth = rand.nextInt(maxEnemyHealth);
			String beasts = beast[rand.nextInt(beast.length)];
			System.out.println("\t# " + beasts + " has appeared! #\n");
			
			while(beastHealth > 0) {
				System.out.println("\t Your HP " + health);
				System.out.println("\t" + beasts + "'s HP: " + beastHealth);
				System.out.println("\n\t What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");
				
				String user = input.nextLine();
				if(user.equals("1")) {
					int damageDealt2 = rand.nextInt(attackDamage);
					int damageTaken2 = rand.nextInt(beastAttack); 
					
					beastHealth -= damageDealt2;
					health -= damageTaken2;
					
					System.out.println("\t You strike the " + beasts + " for " + damageDealt2 + " damage.");
					System.out.println("\t You receive " + damageTaken2 + " in retalliation.");
					
					if(health < 1) { 
						System.out.println("\t> You have taken too much damage.");
						break;
					}
					
				}
				else if(user.equals("2")) {
					
					if(numStimContainers > 0) {
						health += healthStimAmount;
						numStimContainers --;
						System.out.println("\t> You drank a health potion and healed" + healthStimAmount + "." 
										 + "\n\t> You now have " + health + "HP."
										 + "\n\t> You have " + numStimContainers + "left. \n");
					}
					
					else { 
						System.out.println("\t> You have no health potions left. Defeat enemies for a chanve to get one. ");
					}
					
				}
				else if(user.equals("3")) {
					
					System.out.println("\t You run away from the " + beast + ".");
					continue GAME2;
					
				}
				else {
					System.out.println("\t invalid conmmand");
				}
				
			}
			
			
			if(health < 1) {
				System.out.println("you're dead");
				break;
			}
			
			System.out.println("---------------------------------------");
			System.out.println(" # " + beasts + " was defeated! # ");
			System.out.println(" # You have " + health + "HP left # ");
			if(rand.nextInt(100) < keyDropChance) {
				key++;
				System.out.println(" # The " + beasts + " dropped the key to the temple # ");
				System.out.println(" # You have " + key + " key ");
			}
			
			
			
			System.out.println("---------------------------------------");
			System.out.println(" What would you  like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Enter the Temple - level 3");
			
			String user = input.nextLine();
			
			while (!user.equals("1") && !user.equals("2")) {
				System.out.println("invalid command");
				user = input.nextLine();
			}

			if(user.equals("1")) { 
				
				System.out.println("You continue on the fight");
			}
			else if (user.equals("2")) { 
				
				if(key>=1) {
				System.out.println("You continue your journey into the sacred temple of the Gods");
				break;
			    } else if(key<1) {
			    	System.out.println("---------------------------------------");
			    	System.out.println("you need to find the key to the temple to continue");
			    }
				
				
			}
			
		}
			
		// level 3 = defeat the god king in order to beat the game
		
		GAME3:
		while(running) {
			
			System.out.println("---------------------------------------");
			
			System.out.println("\t# " + raidriar + " has appeared! #\n");
			
			while(kingHealth > 0) {
				System.out.println("\t Your HP " + health);
				System.out.println("\t" + raidriar + "'s HP: " + kingHealth);
				System.out.println("\n\t What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");
				
				String user = input.nextLine();
				if(user.equals("1")) {
					int damageDealt3 = rand.nextInt(attackDamage);
					int damageTaken3 = rand.nextInt(beastAttack); 
					
					kingHealth -= damageDealt3;
					health -= damageTaken3;
					
					System.out.println("\t You strike the " + raidriar + " for " + damageDealt3 + " damage.");
					System.out.println("\t You receive " + damageTaken3 + " in retalliation.");
					
					if(health < 1) { 
						System.out.println("\t You have taken too much damage.");
						break;
					}
					
				}
				else if(user.equals("2")) {
					
					if(numStimContainers > 0) {
						health += healthStimAmount;
						numStimContainers --;
						System.out.println("\t> You drank a health potion and healed" + healthStimAmount + "." 
										 + "\n\t> You now have " + health + "HP."
										 + "\n\t> You have " + numStimContainers + "left. \n");
					}
					
					else { 
						System.out.println("\t> You have no health potions left. Defeat enemies for a chanve to get one. ");
					}
					
				}
				else if(user.equals("3")) {
					
					System.out.println("\t You ran away from the " + raidriar + ".");
					continue GAME3;
					
				}
				else {
					System.out.println("\t invalid conmmand");
				}
				
			}
			
			
			if(health < 1) {
				System.out.println("you're dead :(");
				break;
			}
			
			System.out.println("---------------------------------------");
			System.out.println(" # The" + raidriar + " was defeated! # ");
			System.out.println(" # You have saved the world from his tyranical reign! # ");
			break;
			
			
			}
		
		
		System.out.println("\n####################");
		System.out.println("\nThanks for playing!");
		System.out.println("\n####################");
		
		
		}

		}
	

	










