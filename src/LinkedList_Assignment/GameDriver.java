package LinkedList_Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameDriver {
	
	private static PlayerLinkedList list = new PlayerLinkedList();
	private static Scanner scan = new Scanner(System.in);
	private static Random rand = new Random();
	private static boolean playGame = true;

	public static void main(String[] args) throws FileNotFoundException{
		
			
		populateList();
		playGame();
		
	}
	
	private static void playGame() {
		do {
			displayMenu();
			try {
				int input = scan.nextInt();
				switch(input) {
				case 1:
					addPlayer();
					break;
				case 2:
					deletePlayer();
					break;
				case 3:
					numberOfPlayers();
					break;
				case 4:
					printList();
					break;
				case 5:
					searchByID();
					break;
				case 6:
					searchByRealName();
					break;
				case 7:
					searchByGameName();
					break;
				case 8:
					searchByHighestScore();
					break;
				case 9:
					searchByLowestScore();
					break;
				case 0:
					exit();
					break;
				default:
					String errorMsg = String.format("\n%d isn't a valid input. Must be an integer between 0 and 9. Going back to menu.\n", input);
					System.out.println(errorMsg);
				}
			} catch (InputMismatchException e){
				System.out.println("\nInvalid User Input, please enter an integer from 0 to 9.\n");
				scan.next();	//consume Scanner token to avoid infinite loop
			}
		} while (playGame);
		
		System.out.println("\n\n\nGoodbye!\n\n\n");
	}
	
	private static void exit() {
		list.setHead(null);//deleting whole list before exiting program
		playGame = false;
	}
	
	private static void searchByHighestScore() {
		String message = list.highScore();
		System.out.println(message);
		returningToMenu();
	}
	
	private static void searchByLowestScore() {
		String message = list.lowScore();
		System.out.println(message);
		returningToMenu();
	}
	
	private static void searchByGameName() {
		System.out.println("-----------------------------------"
				 + "\nPlease enter the Game Name of the Player you wish to search for: ");
		String gameName = scan.next();
		PlayerNode player = list.search(gameName);
		if (player != null) {
			diagnosticMessage(player);
		} else {
			String message = String.format("Player %s was not found in the list", gameName);
			System.out.println(message);
		}
		
		returningToMenu();
	}
	
	private static void searchByRealName() {
		System.out.println("-----------------------------------"
						 + "\nPlease enter the First and Last Name of the Player you wish to search for: ");
		String fname = scan.next();
		String lname = scan.next();
		PlayerNode player = list.search(fname, lname);
		if (player != null) {
			diagnosticMessage(player);
		} else {
			String message = String.format("Player %s %s was not found in the list", fname, lname);
			System.out.println(message);
		}
		
		returningToMenu();
	}
	
	private static void searchByID() {
		System.out.println("-----------------------------------"
				 + "\nPlease enter the ID of the Player you wish to search for: ");
		int id = Integer.parseInt(scan.next());
		PlayerNode player = list.search(id);
		if (player != null ) {
			diagnosticMessage(player);
		} else {
			String message = String.format("Player %d was not found in the list", id);
			System.out.println(message);
		}
	}
	
	private static void printList() {
		System.out.println("-----------------------------------\nLIST OF ALL PLAYERS\n-----------------------------------");
		list.printPlayerList();
		returningToMenu();
	}
	
	private static void numberOfPlayers() {
		int length = list.length();
		String message = String.format("-----------------------------------"
									 + "\n\nCurrent number of Players in list: %d\n\n", length);
		System.out.println(message);
		returningToMenu();
	}
	
	private static void deletePlayer() {
		System.out.println("-----------------------------------"
				 + "\nPlease enter a Player ID: ");
		int id = Integer.parseInt(scan.next());
		
		list.delete(id);
		returningToMenu();
	}
	
	private static void addPlayer() {
		System.out.println("-----------------------------------"
						 + "\nPlease enter a First Name: ");
		String fname = scan.next();
		System.out.println("Please enter a Last Name: ");
		String lname = scan.next();
		System.out.println("Please enter an In-Game Name: ");
		String player = scan.next();
		System.out.println("Please enter a Player Type: ");
		String type = scan.next();
		
		int id = uniqueID();
		double life = 0;
		double score = 0;
		PlayerNode newPlayer = new PlayerNode(id, fname, lname, player, type, life, score);
		list.append(newPlayer);
		System.out.println("\n\nNEW PLAYER CREATED!\n\n");
		diagnosticMessage(newPlayer);
		returningToMenu();
	}
	
	private static int uniqueID() {
		PlayerNode player;
		int id = rand.nextInt(20000);	//current ID's go up to 9999, so this value should be fine
		
		do {
			player = list.search(id);
		} while(player != null);
		
		return id;
	}
	
	private static void diagnosticMessage(PlayerNode player) {
		String diagnosticMsg = String.format(
				  "\n%-12s: %-12d"
				+ "\n%-12s: %-12s"
				+ "\n%-12s: %-12s"
				+ "\n%-12s: %-12s"
				+ "\n%-12s: %-12s"
				+ "\n%-12s: %-12.2f"
				+ "\n%-12s: %-12.2f",
				"ID", player.getPlayedID(), "First Name", player.getFirstName(), "Last Name", player.getLastName(),
				"Player", player.getPlayerName(), "Class", player.getPlayerType(),
				"Life", player.getLifePoints(), "Score", player.getTotalScore());
		System.out.println(diagnosticMsg);
	}
	
	private static void returningToMenu() {
		System.out.println("\nReturning to menu...\n\n");
	}
	
	private static void displayMenu() {
		String message = "-----------------------------------"
				   + "\nPlease select an option:"
				   + "\n 1. Add a Player"
				   + "\n 2. Delete a Player"
				   + "\n 3. Report total number of Players"
				   + "\n 4. Print full Player list"
				   + "\n 5. Search by Player ID"
				   + "\n 6. Search by Player's Real Name"
				   + "\n 7. Search by Player's Game Name"
				   + "\n 8. Search by Player Type"
				   + "\n 9. Report Player with highest score"
				   + "\n10. Report Player with lowest score"
				   + "\n 0. Exit"
				   + "\n-----------------------------------"
				   + "\nEnter menu choice (0-10): ";
		System.out.println(message);
	}
	
	private static void populateList() throws FileNotFoundException {
		File file = new File(".\\src\\GameAssignment\\Players.csv");
		Scanner sc = new Scanner(file);
		
		int id;
		String fname;
		String lname;
		String player;
		String type;
		double life;
		double score;
		
		while (sc.hasNextLine()) {
			String[] temp = sc.nextLine().split(",");

			id = Integer.parseInt(temp[0]);
			fname = temp[1];
			lname = temp[2];
			player = temp[3];
			type = temp[4];
			life = Double.parseDouble(temp[5]);
			score = Double.parseDouble(temp[6]);
						
			list.append(new PlayerNode(id, fname, lname, player, type, life, score));
		}
	}

	

}
