import java.util.ArrayList;
import java.util.Stack;

public class Player {
	private GUITest2 ui;
	private Stack<Card> drawPile;
	private ArrayList<Card> hand;
	private ArrayList<Card> field;
	private DeckList cards;
	private int hp;
	public Player(DeckList cards) {
		hp = 10;
		this.cards = cards;
		drawPile = new Stack<Card>();
		for(Card c : cards.getCards()) {
			drawPile.add(c);
		}
		hand = new ArrayList<Card>();
		for(int i = 0; i < 5; i++) {
			hand.add(drawPile.pop());
		}
		field = new ArrayList<Card>();
	}
	public void takeDamage() {
		hp--;
	}
	public int getHealth() {
		return hp;
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
	public void addToField(Card addedCard) {
		field.add(addedCard);
		hand.remove(addedCard);
		System.out.println("hi");
		ui.updateUI();
	}
	public void addUI(GUITest2 ui) {
		this.ui = ui;
	}
	public boolean fieldIsEmpty() {
		if(field.size() == 0) {
			return true;
		}
		return false;
	}
	public void fieldAttacked() {
		field.removeFirst();
		System.out.println(field.size());
	}
	public ArrayList<Card> getField(){
		return field;
	}
	
	public void disableAllPlayerCards() {
		for(Card c : hand) {
			c.getView().setEnabled(false);
		}
		for(Card c : field) {
			c.getView().setEnabled(false);
		}
	}
	
	public void enableAllPlayerCards() {
		for(Card c : hand) {
			c.getView().setEnabled(true);
		}
		for(Card c : field) {
			c.getView().setEnabled(true);
		}
	}
	
	public void updateUI() {
		ui.updateUI();
	}
}
