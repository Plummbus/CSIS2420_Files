package BST_Assignment2;

public class BinarySearchTree {
	/*
	 * TODO
	 *  1 (X) - Insert
	 *  2 (X) - Count Nodes
	 *  3 () - Search by IP
	 *  4 () - Search by Name
	 *  5 (X) - Print In-Order IPs
	 */

	private Node root;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void insert(int IP, String name) {
		Node newNode = new Node(IP, name);
		//if BST is empty
		if (root == null) {
			this.root = newNode;
		} else {
			Node current = root;
			Node parent = null;	//just initializing here, will get set at start of while loop
			boolean insertComplete = false;
			while (!insertComplete) {
				parent = current;
				if (newNode.getIp() < current.getIp()) {
					current = current.getLeftChild();
					if (current == null) {
						parent.setLeftChild(newNode);
						insertComplete = true;
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(newNode);
						insertComplete = true;
					}
				}
			}
		}
	}
	
	public Node search(Node node, int IP) {
		if (node == null || node.getIp() == IP) {
			return node;
		}
		
		if (node.getIp() < IP) {
			return search(node.getRightChild(),  IP);
		}
		
		if (node.getIp() > IP) {
			return search(node.getLeftChild(), IP);
		}
		
		return null;
	}
	
	public Node search(Node node, String name) {
		if (node == null || node.getName().compareTo(name) == 0) {
			return node;
		}
		
		if (node.getName().compareTo(name) < 0) {
			return search(node.getLeftChild(), name);
		}
		
		if (node.getName().compareTo(name) > 0) {
			return search(node.getRightChild(), name);
		}
		
		return null;
	}
	
	public int countNodes(Node root) {
		//if node passed is empty, return 0
		if (root == null) {
			return 0;
		} else {	//otherwise recursive call method and add 1 to call (1 for counting the root);
			return 1 + countNodes(root.getLeftChild()) + countNodes(root.getRightChild());
		}
	}
	
	//REMOVE getName(), only for testing!
	public void printInOrderIPs(Node node) {
		if (node == null) {
			System.out.println("BST is empty.");
			return;
		} else {
			if (node.getLeftChild() != null) {
				printInOrderIPs(node.getLeftChild());
			}
			System.out.println(node.getIPString() + ", " + node.getName());
			if (node.getRightChild() != null) {
				printInOrderIPs(node.getRightChild());
			}
		}
	}
}
