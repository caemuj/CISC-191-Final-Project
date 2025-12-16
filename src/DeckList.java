import java.util.HashMap;

public class DeckList {
	private Card[] cards;
	public DeckList() {
		cards = new Card[20];
		for(int i = 0; i < 11; i++) {
			cards[i] = new CreatureCard("1;1");
		}
		for(int i = 11; i < 20; i++) {
			cards[i] = new CreatureCard("2;2");
		}
	}
	public Card[] getCards() {
		return cards;
	}
}
