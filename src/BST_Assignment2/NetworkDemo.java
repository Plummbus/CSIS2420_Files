package BST_Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NetworkDemo {

	private static Scanner sc = new Scanner(System.in);
	private static boolean runProgram = true;
	private static BinarySearchTree bst = new BinarySearchTree();
	
	public static void main(String[] args) throws FileNotFoundException {

		run();
		
	}
	
	private static void run() throws FileNotFoundException {
		do {
			displayMenu();
			try {
				int input = sc.nextInt();
				switch(input) {
				case 1:
					buildTree();
					break;
				case 2:
					findByIP();
					break;
				case 3:
					findByName();
					break;
				case 4:
					System.out.println("Number of nodes in BST: " + bst.countNodes(bst.getRoot()));
					break;
				case 5:
					bst.printInOrderIPs(bst.getRoot());
					break;
				case 6:
					runProgram = false;
					break;
				default:
					String errorMsg = String.format("\n%d isn't a valid input. Must be an integer between 1 and 6. Going back to menu.\n", input);
					System.out.println(errorMsg);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid User Input, please enter an integer from 1 to 6.\n");
				sc.next();	//consume Scanner token to avoid infinite loop
			}
		} while (runProgram);
		
		System.out.println("\n\n\nProgram terminated. Goodbye.\n\n\n");
	}
	
	private static void displayMenu() {
		System.out.println("--------------------------------"
				+ "\n1 Build Users Tree"
				+ "\n2 Find by IP Address"
				+ "\n3 Find by Username"
				+ "\n4 Report Number of Nodes"
				+ "\n5 Print Entire Tree"
				+ "\n6 Exit"
				+ "\n--------------------------------"
				+ "\nEnter 1, 2, 3, 4, 5, or 6");
	}
	
	public static void findByIP() {
		boolean end = false;
		while (!end) {
			System.out.println("Please enter an integer up to 3 digits long. Type a non-number to return to menu.");
			try {
				int input = sc.nextInt();
				Node result = bst.search(bst.getRoot(), input);
				if (result == null) {
					System.out.println("Sorry, the IP ending in \"" + input + "\" was not found in the network. Try again");
				} else {
					String message = String.format("User with IP ending in \"%d\" was found!"
							+ "\n%12s: %s"
							+ "\n%12s: %s"
							+ "\nReturning to menu...",
							input, "Full Address", result.getIPString(), "F/L Name", result.getName());
					System.out.println(message);
					end = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("User inputted a non-number, returning to menu.");
				end = true;
				sc.next();
			}
		}
	}
	
	public static void findByName() {
		boolean end = false;
		while (!end) {
		System.out.println("Please enter the name of the user(ex. \"Jake Hernandez\" -> jhernandez). Type in an integer to return to the menu.");
			String input = sc.next();
			if (isInteger(input)) {
					System.out.println("User inputted an integer, returning to menu.");
					end = true;
			} else {
				Node result = bst.search(bst.getRoot(), input);
				if (result == null) {
					System.out.println("Sorry, the user with name \"" + input + "\" not found in the network. Try again");
				} else {
					String message = String.format("User with name \"%s\" was found!"
							+ "\n%12s: %s"
							+ "\n%12s: %s"
							+ "\nReturning to menu...",
							input, "Full Address", result.getIPString(), "F/L Name", result.getName());
					System.out.println(message);
					end = true;
				}
			}
		}
	}
	
	public static boolean isInteger(String str) {
		int length = str.length();
		
		if (str == null || length == 0) {
			return false;
		}
		
		int i = 0;
		if (str.charAt(i) == '-') {
			if (str.length() == 0) {
				return false;
			} else {
				i = 1;
			}
		}
		
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isIntegerRegex(String str) {
		return str.matches("^-?\\d+$");
	}
	
	public static void buildTree() throws FileNotFoundException {
		File file = new File(".\\src\\BST_Assignment2\\users.csv");
		Scanner scan = new Scanner(file);
		
		int IP;
		String name;
		
		while (scan.hasNextLine()) {
			String[] temp = scan.nextLine().split(",");
			
			IP = Integer.parseInt(temp[0]);
			name = temp[1];
			
			bst.insert(IP, name);
		}
		System.out.println("Binary Search Tree is now built and populated!");
	}
}
