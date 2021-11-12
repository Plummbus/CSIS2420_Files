package Hashing_Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashingDemo1
{
	/*
		hashArray[0] -> Barnes 
		hashArray[1] -> Andrews -> Mathison -> Jones
		hashArray[2] -> Yates   -> Carlson
	*/
	public static String[] dataArray = new String[] {"Yates","Andrews","Barnes","Mathison","Jones","Carlson"};
	public static int[] customerIDsArray = new int[] {1111, 2222, 3333, 4444, 5555, 6666};
	public static HashNode hashArray[] = new HashNode[1000];
	
	static int nanoDivisor = 1000000000;

	public static void main(String[] args) throws FileNotFoundException
	{
		displayDataArray();
		displayHashExampleOutput();
		for (int j = 0; j < dataArray.length; j++)
		{
			appendNode(hashIt(dataArray[j]), customerIDsArray[j], dataArray[j]);
		}
		displayHashArray();
		//these lines are for testing Part 1
//		searchHashArrayAndDisplay("Barnes");
//		searchHashArrayAndDisplay("Mathison");
//		searchHashArrayAndDisplay("Carlson");
//		searchHashArrayAndDisplay("Janette");
		
		populateFromCSV();
		displayHashArray();
		
		searchHashArrayAndDisplay("Zarate" );
		searchHashArrayAndDisplay("Mcclanahan");
		searchHashArrayAndDisplay("Urban");
		
		System.out.println("Empry indicies: " + countEmptyIndices());
		
	}
	
	private static int countEmptyIndices() {
		int count = 0;
		for (int i = 0; i < hashArray.length - 1; i++) {
			if (hashArray[i] == null) {
				count++;
			}
		}
		return count;
	}
	
	private static void populateFromCSV() throws FileNotFoundException {
		File file = new File(".\\src\\Hashing_Assignment\\HashingDemoDataFile.csv");
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			String[] temp = sc.nextLine().split(",");
			int customerID = Integer.parseInt(temp[0]);
			String lastName = temp[1];
			appendNode(hashIt(lastName), customerID, lastName);
		}
	}
	
	private static void displayHashExampleOutput() 
	{
		int asciiTotal = 0;
		for (int j = 0; j < dataArray.length; j++)
		{
			for (int k = 0; k < dataArray[j].length(); k++)
			{
				char c = dataArray[j].charAt(k);
				System.out.println(c + "  " + (int)c);
				asciiTotal = asciiTotal + (int)c;
			}
			System.out.print("asciiTotal: " + asciiTotal);
			System.out.println("\t[" + asciiTotal % hashArray.length + "]\n");
			asciiTotal = 0;
		}
	}

	private static void displayDataArray() 
	{
		for (int i = 0; i < dataArray.length; i++)
		{
			System.out.printf("dataArray[%d]: %s%n", i, dataArray[i]);
		}
		System.out.println();
		for (int i = 0; i < customerIDsArray.length; i++)
		{
			System.out.printf("customerIDsArray[%d]: %s%n", i, customerIDsArray[i]);
		}
		System.out.println();
	}

	public static int hashIt(String data)
	{
		int asciiTotal = 0;
		for (int n = 0; n < data.length(); n++)
		{
			char c = data.charAt(n);
			asciiTotal = asciiTotal + (int)c;
		}
		return asciiTotal % hashArray.length;
	}
	
	public static void appendNode(int arrayIndex, int customerID, String name)
	{
		if (hashArray[arrayIndex] == null)
		{
			hashArray[arrayIndex] = new HashNode(customerID, name);
		}
		else
		{
			HashNode current = hashArray[arrayIndex];
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = new HashNode(customerID, name);
		}
	}

	public static void displayHashArray()
	{
		for (int i = 0; i < hashArray.length; i++)
		{
			System.out.printf("hashArray[%d]", i);
			if (hashArray[i] != null)
			{
				HashNode current = hashArray[i];
				System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				while (current.next != null)
				{
					current = current.next;
					System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				}
			}
			System.out.println();;
		}
	}
	

	public static HashNode searchHashArray(String data) {
		
		boolean isFound = false;
		HashNode target = null;
		long start = System.nanoTime();
		int hashResult = hashIt(data);
		HashNode current = hashArray[hashResult];
		
		if (current.lastName.equals(data)) {
			target = current;
		} else {
			while (current.next != null && !isFound) {
				current = current.next;
				if (current.lastName.equals(data)) {
					target = current;
				}
			}
		}
		long end = System.nanoTime();
		long duration = end - start;
		double seconds = (double)duration / nanoDivisor;
		System.out.printf("Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
		return target;
	}
	
	public static void searchHashArrayAndDisplay(String data) {
		
		HashNode result = searchHashArray(data);
		String message;
		if (result == null) {
			message = "\n" + data + " was not found in the Hash Array!";
		} else {
			message = String.format("\nMatch was found!"
					+ "\nlastname: %s"
					+ "\ncustomer ID: %d", result.lastName, result.customerID);
		}
		System.out.println(message);
	}
}