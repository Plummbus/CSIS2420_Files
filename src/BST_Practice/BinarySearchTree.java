package BST_Practice;

public class BinarySearchTree {

	
	private BSTNode root;
	
	public BinarySearchTree(BSTNode root) {
		this.root = root;
	}
	
	public void insert(int data) {
		BSTNode newNode = new BSTNode(data);
		if (root == null) {
			this.root = newNode;
		} else {
			BSTNode current = newNode;
			BSTNode parent = null;
			boolean insertComplete = false;
			while (!insertComplete) {
				parent = current;
				if (newNode.getData() < root.getData()) {
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
}
