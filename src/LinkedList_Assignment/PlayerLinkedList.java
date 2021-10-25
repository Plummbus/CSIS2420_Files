package LinkedList_Assignment;


public class PlayerLinkedList {

	
	private PlayerNode head;
	
	//no arg passed is empty list
	//for testing empty list cases
	public PlayerLinkedList() {
		this.head = null;
	}
	
	public PlayerLinkedList(PlayerNode head) {
		this.head = head;
	}

	public PlayerNode getHead() {
		return head;
	}

	public void setHead(PlayerNode head) {
		this.head = head;
	}
	
	/*
	 * NON-GETTER/SETTER METHODS FOR LINKED LIST
	 */
	
	//appends player to end of list.
	//if list is empty, player becomes head
	public void append(PlayerNode node) {

		if (head == null) {
			head = node; 
			return;
		}
		
		PlayerNode current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
	}
	
	//deletes player from list based on playerID
	public void delete(int playerID) {
		if (head.getPlayedID() == playerID) {
			head = head.getNext();
		}
		
		PlayerNode current = head;
		while (current.getNext() != null) {
			if (current.getNext().getPlayedID() == playerID) {
				String success = String.format("\nPlayer %d successfully deleted from list\n", playerID);
				System.out.println(success);
				current.setNext(current.getNext().getNext());
				return;
			} else {
				current = current.getNext();
			}
		}
		
		String failure = String.format("\nPlayer %d could not be found in list. Delete action could not be performed.\n", playerID);
		System.out.println(failure);
	}
	
	//returns length(int) of the list
	public int length() {
		if (head == null) {
			return 0;
		}
		int length = 1;
		PlayerNode current = head;
		while (current.getNext() != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}
	
	//adds a PlayerNode to the front of the list
	public void prepend(PlayerNode node) {
		PlayerNode temp = head;
		head = node;
		head.setNext(temp);
	}
	
	//Prints a well-formatted report of all players and all 
	//of their attributes in columns
	public void printPlayerList() {
		PlayerNode current = head;
		System.out.printf("\n\n %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "ID", "First Name", "Last Name", "Character", "Class", "Life", "Score");
		while (current != null) {
			String message = String.format(" %-12d %-12s %-12s %-12s %-12s %12.2f %12.2f", current.getPlayedID(), current.getFirstName(),
							 current.getLastName(), current.getPlayerName(), current.getPlayerType(), current.getLifePoints(), current.getTotalScore());
			System.out.println(message);
			current = current.getNext();
		}
	}
	
	/*
	 * Overloaded search methods that allow the following searching options:
	 */
	
	//Returns the reference to the node that contains the specified playerID,
	//or null if not found in the list.
	public PlayerNode search(int playerID) {
		PlayerNode current = head;
		while (current != null) {
			if (current.getPlayedID() == playerID) {
				return current;
			} else {
				current = current.getNext();
			}
		}
		
		return null;
	}
	
	
	//Returns the reference to the node that contains the specified playerName,
	//or null if not found in the list.
	public PlayerNode search(String playerName) {
		PlayerNode current = head;
		while (current != null) {
			if (current.getPlayerName().compareTo(playerName) == 0) {
				return current;
			} else {
				current = current.getNext();
			}
		}
		
		return null;
	}
	
	//Returns the reference to the node that contains the specified name 
	//(firstName lastName combination), or null if not found in the list.
	public PlayerNode search(String firstName, String lastName) {
		PlayerNode current = head;
		while (current != null) {
			if (current.getFirstName().compareTo(firstName) == 0 &&
					current.getLastName().compareTo(lastName) == 0) {
				return current;
			} else {
				current = current.getNext();
			}
		}
			
		return null;
	}
	
	//Finds all players who are the specified playerType and prints a well-formatted
	//report of all of those players and all of their attributes in columns who are 
	//of the playerType specified.
	//Not overloaded because it has the same method signature as search(String playerName) --> ILLEGAL
	public void searchByClass(String playerType) {
		PlayerNode current = head;
		System.out.println("\nAll players with class: " + playerType);
		System.out.printf("\n\n %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "ID", "First Name", "Last Name", "Character", "Class", "Life", "Score");
		while (current != null) {
			if (current.getPlayerType().compareTo(playerType) == 0) {
				String message = String.format(" %-12d %-12s %-12s %-12s %-12s %12.2f %12.2f", current.getPlayedID(), current.getFirstName(),
						 current.getLastName(), current.getPlayerName(), current.getPlayerType(), current.getLifePoints(), current.getTotalScore());
				System.out.println(message);
			}
			current = current.getNext();
		}
	}
	
	//Returns a well-formatted string containing the player with the highest
	//totalScore in the list. This method should not print the player,
	//it should return a compound string back to the calling program.
	public String highScore() {
		PlayerNode current = head;
		PlayerNode bestPlayer = current;
		while (current != null) {
			if (current.getTotalScore() > bestPlayer.getTotalScore()) {
				bestPlayer = current;
			}
			current = current.getNext();
		}
		String message = String.format("\nPlayer with the highest score of %f is %s!"
				+ "\nFull stats:"
				+ "\n\n%-12s %-12s %-12s %-12s %-12s %-12s %-12s\n"
				+ "\n%-12d %-12s %-12s %-12s %-12s %-12.2f %-12.2f",
				bestPlayer.getTotalScore(), bestPlayer.getPlayerName(),	//header of string
				"ID", "First Name", "Last Name", "Character", "Class", "Life", "Score",	//stats labels
				bestPlayer.getPlayedID(), bestPlayer.getFirstName(), bestPlayer.getLastName(), bestPlayer.getPlayerName(),
				bestPlayer.getPlayerType(), bestPlayer.getLifePoints(), bestPlayer.getTotalScore());
		return message;
	}
	
	//Returns a well-formatted string containing the player with the lowest totalScore in the list. This
	//method should not print the player, it should return a compound string back to the calling program.
	public String lowScore() {
		PlayerNode current = head;
		PlayerNode worstPlayer = current;
		while (current != null) {
			if (current.getTotalScore() < worstPlayer.getTotalScore()) {
				worstPlayer = current;
			}
			current = current.getNext();
		}
		String message = String.format("\nPlayer with the lowest score of %f is %s!"
				+ "\nFull stats:"
				+ "\n\n%-12s %-12s %-12s %-12s %-12s %-12s %-12s\n"
				+ "\n%-12d %-12s %-12s %-12s %-12s %-12.2f %-12.2f",
				worstPlayer.getTotalScore(), worstPlayer.getPlayerName(),	//header of string
				"ID", "First Name", "Last Name", "Character", "Class", "Life", "Score",	//stats labels
				worstPlayer.getPlayedID(), worstPlayer.getFirstName(), worstPlayer.getLastName(), worstPlayer.getPlayerName(),
				worstPlayer.getPlayerType(), worstPlayer.getLifePoints(), worstPlayer.getTotalScore());
		return message;
	}
	
	
}
