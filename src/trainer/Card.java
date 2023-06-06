package trainer;

public class Card {
	private enum Faces {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	private enum Suits {
		CLUBS, SPADES, HEARTS, DIAMONDS
	}

	private Faces face;
	private Suits suit;

	public Card(String face, String suit) {
		this.face = Faces.valueOf(face.toUpperCase());
		this.suit = Suits.valueOf(suit.toUpperCase());
	}

	public String getFace() {
		return face.toString().toLowerCase();
	}

	public String getSuit() {
		return suit.toString().toLowerCase();
	}
	
	public boolean equals(Card other) {
		return this.getFace() == other.getFace() && this.getSuit() == other.getSuit();
	}
}
