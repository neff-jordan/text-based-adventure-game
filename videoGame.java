package testBasedAdventure;

import java.util.Random;
import java.util.Scanner;

public class videoGame {

	public static void main(String[] args) {

		// System objects
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		// Game Variables 
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassain"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		// Player Variables 
		int health = 100; 
		int attackDamage = 50;
		int numStimContainers = 3;
		int healthStimAmount = 30;
		int healthStimDropChance = 50; // percentage
		
		boolean running = true; 
		
		System.out.println("welcome to the world");
		
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
				System.out.println(" # The " + enemy + "dropped a stim container # ");
				System.out.println(" # YOu have " + numStimContainers + " stim containers # ");
				
			}
			
			System.out.println("---------------------------------------");
			System.out.println(" WHat would you  like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit Dungeon");
			
			String in = input.nextLine();
			
			while (!in.equals("1") && !in.equals("2")) {
				System.out.println("invalid command");
				in = input.nextLine();
			}

			if(input.equals("1")) { 
				
				System.out.println("You continue on your adventure");
			}
			else if (in.equals("2")) { 
				System.out.println("You have exitied the dungeon");
				break;
			}
			
			
		}

		System.out.println("#######################");
		System.out.println("Thanks for playing!");
		System.out.println("#######################");

		
	}

}
























