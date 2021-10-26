package BST_Assignment2;

import java.util.Random;

public class Node {

	private Node leftChild;
	private Node rightChild;
	private int IP;
	private String name;
	
	private Random r = new Random();
	
	public Node(int IP, String name) {
		this.IP = IP;
		this.name = name;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getIp() {
		return IP;
	}

	public void setIP(int IP) {
		this.IP = IP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getIPString() {
		StringBuilder sb = new StringBuilder();
		sb.append("10.0.0.");
		sb.append(this.IP);
		return sb.toString();
	}
}
