package BST_Practice;

public class BinarySearchTree {

	
	private BSTNode root;
	
	public BinarySearchTree(BSTNode root) {
		this.root = root;
	}
	
	public BSTNode getRoot() {
		return this.root;
	}
	
	public void insert(int data) {
		BSTNode newNode = new BSTNode(data);
		if (root == null) {
			this.root = newNode;
		} else {
			BSTNode current = root;
			BSTNode parent = null;
			boolean insertComplete = false;
			while (!insertComplete) {
				parent = current;
				if (newNode.getData() < current.getData()) {
					current = current.getLeft();
					if (current == null) {
						parent.setLeft(newNode);
						insertComplete = true;
					}
				} else {
					current = current.getRight();
					if (current == null) {
						parent.setRight(newNode);
						insertComplete = true;
					}
				}
			}
		}
	}
	
	//prints contents of tree in order of: root, left side, then right side
	//must pass the root as the parameter on first method call.
	//method takes a parameter like this for recursion.
	public void preOrderTraverse(BSTNode node) {
		//base case?
		if (root == null) {
			System.out.println("Tree is empty.");
			return;	//just want to make sure we stop function at this point;
		} else {
			System.out.println(node.getData() + " ");
			if (node.getLeft() != null) {
				preOrderTraverse(node.getLeft());
			}
			if (node.getRight() != null) {
				preOrderTraverse(node.getRight());
			}
		}
	}
	
	//same concept as preOrderTraverse(node)
	//this time it prints: left side, root, right side
	public void inOrderTraverse(BSTNode node) {
		if (root == null) {
			System.out.println("Tree is empty.");
			return;
		} else {
			if (node.getLeft() != null) {
				inOrderTraverse(node.getLeft());
			}
			System.out.println(node.getData() + " ");
			if (node.getRight() != null) {
				inOrderTraverse(node.getRight());
			}
		}
	}
	
	//same concept as preOrderTraverse(node)
	//this time it prints: right side, root, left side
	public void postOrderTraverse(BSTNode node) {
		if (root == null) {
			System.out.println("Tree is empty.");
		} else {
			if (node.getRight() != null) {
				postOrderTraverse(node.getRight());
			}
			System.out.println(node.getData() + " ");
			if (node.getLeft() != null) {
				postOrderTraverse(node.getLeft());
			}
		}
	}
	
	public BSTNode search(int data) {
		return null;
	}
}
