package BST_Assignment2;

import java.util.Random;

/**
 * Node class for a BST. Each Node contains data in the form of an IP (int) and a name (String). Each
 * Node also has a reference to it's left and right children, which are defaulted to null.
 * 
 * @author Franz Jacob Hernandez
 * @since 10/31/2021
 *
 */
public class Node {

	private Node leftChild;
	private Node rightChild;
	private int IP;
	private String name;
	
	private Random r = new Random();
	
	/**
	 * Node Constructor
	 * @param IP
	 * @param name
	 */
	public Node(int IP, String name) {
		this.IP = IP;
		this.name = name;
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * Getter for Left Child
	 * @return left child of node
	 */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child of this node
	 * @param leftChild
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Getter for Right Child
	 * @return right child of node
	 */
	public Node getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child of this node
	 * @param rightChild
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * Returns the IP field of the node
	 * @return IP associated with node
	 */
	public int getIp() {
		return IP;
	}

	/**
	 * Sets the IP field of the node
	 * @param IP
	 */
	public void setIP(int IP) {
		this.IP = IP;
	}

	/**
	 * Returns the name field of the node
	 * @return name field
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name field of the node
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a string in the correct format for dislaying in the console
	 * @return Custom formatted string
	 */
	public String getIPString() {
		StringBuilder sb = new StringBuilder();
		sb.append("10.0.0.");
		sb.append(this.IP);
		return sb.toString();
	}
}
