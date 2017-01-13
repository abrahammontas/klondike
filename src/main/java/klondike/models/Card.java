package klondike.models;

public class Card {

	private Suit suit;
	private Number number;
	private boolean hidden;

	public Card(Number number, Suit suit, boolean hidden) {
		this.number = number;
		this.suit = suit;
		this.hidden = hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public Suit getSuit() {
		return suit;
	}

	public Number getNumber() {
		return number;
	}

	public boolean isHidden() {
		return hidden;
	}

	@Override
	public String toString() {
		if (this.hidden) {
			return "[]";
		}
		return "[" + this.number + " " + this.suit + "]";
	}
}