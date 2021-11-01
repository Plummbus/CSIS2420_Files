package BST_Assignment2;

/**
 * A Binary Search Tree, takes Nodes that contain an IP (int) field and a name (string) field. Has basic functionality
 * like inserting, deleting, and searching
 * 
 * @author Franz Jacob Hernandez
 * @since 10/31/2021
 *
 */
public class BinarySearchTree {

	private Node root;
	
	/**
	 * Default Constructor, starts with a null root
	 */
	public BinarySearchTree() {
		this(null);
	}
	
	/**
	 * Constructor, can specify the root
	 * @param root (Node)
	 */
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	/**
	 * Returns the root Node
	 * @return root
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * Creates a new Node based on parameters, then
	 * inserts that Node into the BST. Does not auto-balance on insert.
	 * @param IP
	 * @param name
	 */
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
	
	/**
	 * Searches BST for a Node with the same IP field that is passed.
	 * If no Node is found that matches the IP parameter, method returns null.
	 * @param node
	 * @param IP
	 * @return Node, if found
	 */
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
	
	/**
	 * Searches BST for a Node with the same name field that is passed.
	 * If no Node is found that matches the name parameter, method returns null.
	 * @param node
	 * @param name
	 * @return Node, if found
	 */
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
	
	/**
	 * Traverses entire BST and counts how many Nodes are present.
	 * @param root
	 * @return number of nodes
	 */
	public int countNodes(Node root) {
		//if node passed is empty, return 0
		if (root == null) {
			return 0;
		} else {	//otherwise recursive call method and add 1 to call (1 for counting the root);
			return 1 + countNodes(root.getLeftChild()) + countNodes(root.getRightChild());
		}
	}
	
	/**
	 * Traverses the BST in-order and prints the Nodes to the console.
	 * Prints Nodes from left-most child, to root, to right-most child.
	 * @param node
	 */
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
