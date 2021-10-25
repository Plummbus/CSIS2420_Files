package BST_Assignment1;

import java.util.Random;

public class BSTDemo {
	
	static int nanoDivisor = 1000000000;
	static int range = 10000;
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		//tests to see if methods work
		/*
		testTraverses();
		System.out.println("-----------------------");
		testSearch();
		System.out.println("-----------------------");
		testDepth();
		System.out.println("-----------------------");
		testDelete();
		*/
		
		testTraversalTiming(1000);
		testTraversalTiming(10000);
		testTraversalTiming(100000);
		testTraversalTiming(1000000);
		testTraversalTiming(10000000);
		testTraversalTiming(100000000);	//BEYOND THRESHOLD
		testTraversalTiming(1000000000);	//BEYOND THRESHOLD
		
	}
	
	private static void testTraversalTiming(int number) {
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(r.nextInt(range)));
		for (int i = 0; i < number; i++) {
			bst.insert(r.nextInt(range));
		}
		long start = System.nanoTime();
		bst.inOrderTraverse(bst.getRoot());
		long end = System.nanoTime();
		
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
	
	private static void testTraverses() {
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(10));
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		
		System.out.println(String.format("BST Root: %d", bst.getRoot().getData()));
		System.out.println("Pre-Order Traversal:");
		bst.preOrderTraverse(bst.getRoot());
		
		System.out.println("\nIn-Order Traversal:");
		bst.inOrderTraverse(bst.getRoot());
		
		System.out.println("\nPost-Order Traversal:");
		bst.postOrderTraverse(bst.getRoot());
	}
	
	private static void testSearch() {
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(9));
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(5);
		bst.insert(14);
		bst.insert(15);
		bst.insert(13);
		bst.insert(17);
		
		
		System.out.println(String.format("BST Root: %d", bst.getRoot().getData()));
		System.out.println("In-Order Traversal:");
		bst.inOrderTraverse(bst.getRoot());
		int searchSUCCESS = 4;
		int searchFAILURE = -10;
		BSTNode result;
		
		System.out.println(String.format("Search for %d...", searchSUCCESS));
		result = bst.search(bst.getRoot(), searchSUCCESS);
		searchHelper(result);
		
		System.out.println(String.format("Search for %d...", searchFAILURE));
		result = bst.search(bst.getRoot(), searchFAILURE);
		searchHelper(result);
	}
	
	private static void searchHelper(BSTNode node) {
		if (node != null) {
			System.out.println("Search was a success.");
		} else {
			System.out.println("Search was a failure!");
		}
	}
	
	private static void testDepth() {
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(10));
		
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		
		
		System.out.println(String.format("BST Root: %d", bst.getRoot().getData()));
		bst.preOrderTraverse(bst.getRoot());
		System.out.println("BST should have a depth of 4");
		System.out.println(String.format("BST actual depth: %d", bst.depth(bst.getRoot())));
	}
	
	private static void testDelete() {
		BinarySearchTree bst = new BinarySearchTree(new BSTNode(9));
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(5);
		bst.insert(14);
		bst.insert(15);
		bst.insert(13);
		bst.insert(17);
		System.out.println(String.format("BST Root: %d", bst.getRoot().getData()));
		System.out.println("Pre-Order Traversal:");
		bst.preOrderTraverse(bst.getRoot());
		System.out.println("Deleting 6...");
		bst.delete(bst.getRoot(), 6);
		System.out.println("Pre-Order Traversal:");
		bst.preOrderTraverse(bst.getRoot());
	}

}
