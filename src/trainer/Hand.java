package trainer;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private boolean suited;

	public Hand(Card one, Card two) {
		hand = new ArrayList<>();
		hand.add(one);
		hand.add(two);
		suited = suited(one, two);
	}

	public Hand(Card one, Card two, boolean suited) {
		hand = new ArrayList<>();
		hand.add(one);
		hand.add(two);
		this.suited = suited;
	}
	
	public boolean suited() {
		return hand.get(0).getFace() == hand.get(1).getFace();
	}

	public boolean suited(Card one, Card two) {
		if (one.getFace() != two.getFace()) {
			return one.getSuit() == two.getSuit();
		}
		return false;
	}
	
	public Card getCard(int i) {
		return hand.get(i - 1);
	}
}
