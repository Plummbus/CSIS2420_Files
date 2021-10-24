package BST_Practice;

public class BSTDemo {
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(10));
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		
		bst.preOrderTraverse(bst.getRoot());
		System.out.println();
		
		bst.inOrderTraverse(bst.getRoot());
		System.out.println();
		
		bst.postOrderTraverse(bst.getRoot());
		
	}

}
