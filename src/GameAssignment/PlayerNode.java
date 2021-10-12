package GameAssignment;

public class PlayerNode {

	
	private PlayerNode next;
	
	private int playedID;
	private String firstName;
	private String lastName;
	private String playerName;
	private String playerType;
	private double lifePoints;
	private double totalScore;
	
	//when constructor is passed a next value
	public PlayerNode(int playedID, String firstName, String lastName, String playerName, String playerType,
			double lifePoints, double totalScore, PlayerNode node) {
		this.playedID = playedID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerName = playerName;
		this.playerType = playerType;
		this.lifePoints = lifePoints;
		this.totalScore = totalScore;
		this.next = node;
	}
	
	//when constructor is not passed a next value
	public PlayerNode(int playedID, String firstName, String lastName, String playerName, String playerType,
			double lifePoints, double totalScore) {
		this.playedID = playedID;
		this.firstName = firstName.replaceAll("[^\\x00-\\x7F]", "").trim();
		this.lastName = lastName.replaceAll("[^\\x00-\\x7F]", "").trim();
		this.playerName = playerName.replaceAll("[^\\x00-\\x7F]", "").trim();
		this.playerType = playerType.replaceAll("[^\\x00-\\x7F]", "").trim();
		this.lifePoints = lifePoints;
		this.totalScore = totalScore;
		this.next = null;
	}
	
	public PlayerNode getNext() {
		return next;
	}

	public int getPlayedID() {
		return playedID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerType() {
		return playerType;
	}

	public double getLifePoints() {
		return lifePoints;
	}

	public double getTotalScore() {
		return totalScore;
	}
	
	public void setNext(PlayerNode next) {
		this.next = next;
	}
	
	
	
	
	
}
