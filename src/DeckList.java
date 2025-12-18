/**
 * A simple DeckList class that initializes a deck of 20 cards
 */
public class DeckList {
	private Card[] cards;
	
	/**
	 * Constructor for the DeckList class, initializes a deck of 20 cards
	 */
	public DeckList() {
		cards = new Card[22];
		for(int i = 0; i < 11; i++) {
			cards[i] = new CreatureCard("1;1");
		}
		for(int i = 11; i < 17; i++) {
			cards[i] = new CreatureCard("2;2");
		}
		for(int i = 17; i < 22; i++) {
			cards[i] = new SpellCard("2;-1");
		}
	}
	
	/**
	 * Getter for the deck of cards
	 * @return An array of Card objects representing the deck
	 */
	public Card[] getCards() {
		return cards;
	}
}
