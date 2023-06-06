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

	public Faces getFace() {
		return face;
	}

	public Suits getSuit() {
		return suit;
	}
}
