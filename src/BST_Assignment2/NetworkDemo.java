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
					System.out.println("2 has been called!");
					break;
				case 3:
					System.out.println("3 has been called!");
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
	}
}
