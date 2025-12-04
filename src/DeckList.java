import java.util.HashMap;

public class DeckList {
	private Card[] cards;
	public DeckList() {
		cards = new Card[20];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = new Card("10;15");
		}
	}
	public Card[] getCards() {
		return cards;
	}
}
