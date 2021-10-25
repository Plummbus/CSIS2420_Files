package BST_Assignment1;

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
	
	public BSTNode search(BSTNode root, int value) {
		//base case
		if (root == null || root.getData() == value) {
			return root;
		}
		//recursive cases
		if (root.getData() < value) {
			return search(root.getRight(), value);
		}
		if (root.getData() > value) {
			return search(root.getLeft(), value);
		}
		
		return null;	//this won't get called, just need it to compile
	}
	
	public int depth(BSTNode root) {
		//base case
		if (root == null) {
			return 0;
		} else {
			int ldepth = depth(root.getLeft());
			int rdepth = depth(root.getRight());
			if (ldepth > rdepth) {
				return ldepth + 1;
			} else {
				return rdepth + 1;
			}
		}
	}
	
	//3 cases:
	//1) delete a leaf node
	//2) delete node with 1 child
	//3) delete node with 2 children
	//needs to have a return value so we can assign other nodes to new, correct positions
	public BSTNode delete(BSTNode node, int value) {
		if (node == null) {
			return null;
		}
		
		if (value < node.getData()) {
			node.setLeft(delete(node.getLeft(), value));
		} else if(value > node.getData()) {
			node.setRight(delete(node.getRight(), value));
		} else {
			//case 1
			if (node.getLeft() == null && node.getRight() == null) {
				return null;
			}
			//case 2
			if ((node.getLeft() != null && node.getRight() == null) || (node.getLeft() == null && node.getRight() != null)) {
				BSTNode temp = null;
				temp = node.getLeft() == null ? node.getRight() : node.getLeft();
				return temp;
			}
			//case 3
			if (node.getLeft() != null && node.getRight() != null) {
				BSTNode successor = getSuccessor(node);
				node.setData(successor.getData());
				node.setRight(delete(node.getRight(), successor.getData()));
				return node;
			}
		}
		return node;
	}
	
	private BSTNode getSuccessor(BSTNode node) {
		if (node == null) {
			return null;
		}
		
		BSTNode temp = node.getRight();
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		
		return temp;
	}
	
	
}
