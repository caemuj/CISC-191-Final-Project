import java.util.ArrayList;
import java.util.Stack;

public class Deck {
	Stack<Card> drawPile;
	ArrayList<Card> hand;
	ArrayList<Card> field;
	DeckList cards;
	public Deck(DeckList cards) {
		this.cards = cards;
		drawPile = new Stack<Card>();
		for(Card c : cards.getCards()) {
			drawPile.add(c);
		}
		hand = new ArrayList<Card>();
		for(int i = 0; i < 5; i++) {
			hand.add(drawPile.pop());
		}
	}
	public void addCard(Card c) {
		drawPile.add(c);
	}
	public Card draw() {
		Card drawnCard = drawPile.pop();
		hand.add(drawnCard);
		return drawnCard;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
}
