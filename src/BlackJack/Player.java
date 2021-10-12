package BlackJack;

public class Player {

	private String name;
	private int money;
	private int total;
	private Card[] hand;
	
	public Player (String name, int total) {
		this.name = name;
		this.money = 500;
		this.total = 0;
		this.hand = new Card[2];
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public Card[] getHand() {
		return this.hand;
	}
	
	public void printHand() {
		for (Card card : hand) {
			System.out.println(Deck.cardInfo(card));
		}
	}
	
	//I should be error checking here, but the user doesn't handle this method so its fine
	//will need to do error checking for Pazaak tho
	public void addCard(Card card) {
		if (hand[0] == null) {
			hand[0] = card;
		} else {
			hand[1] = card;
		}
	}
}
