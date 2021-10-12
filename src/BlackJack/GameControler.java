package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameControler {
	
	private static Random rand = new Random();
	
	private static Suit[] suits = {Suit.HEARTS, Suit.CLUBS, Suit.SPADES, Suit.DIAMONDS};

	
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println("Deck size: " + deck.size());
		
		
		createDeck(deck);
		System.out.println("Deck size: " + deck.size());
		deck.printDeck();
		
		Deck shuffled = shuffleDeck(deck);
		shuffled.printDeck();
		System.out.println("Deck size: " + shuffled.size());
	}
	
	private static void createDeck(Deck deck) {
		
		for (int i = 0; i < 4; i++) {	//suits
			for (int j = 1; j < 13; j++) { //card values
				deck.push(new Card(suits[i], j));
			}
		}
	}
	
	private static Deck shuffleDeck(Deck deck) {
		Deck newDeck = new Deck();
		ArrayList<Card> shuffleList = new ArrayList<Card>();
		while (!deck.isEmpty()) {
			shuffleList.add(deck.pop());
		}
		Collections.shuffle(shuffleList);
		for (Card card : shuffleList) {
			newDeck.push(card);
		}
		return newDeck;
	}
	
}
