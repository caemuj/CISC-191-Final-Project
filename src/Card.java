import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Caeden Mujahed
 * @version 1.0
 * Used as a parent class for the other card types
 */
public abstract class Card{
	private String cardID;
	private CardView view;
	
	/**
	 * Constructor for the Card class
	 * @param cardID An internal string representing the card's stats. Standard format is defined in subclasses.
	 */
	public Card(String cardID) {
		super();
		this.cardID = cardID;
		view = new CardView(this);
	}
	
	/**
	 * Getter for the card's ID
	 * @return The card's ID string
	 */
	public String getID() {
		return cardID;
	}
	
	/**
	 * Getter for the card's visual representation
	 * @return The CardView object representing the card visually
	 */
	public CardView getView() {
		return view;
	}
	
	/**
	 * Getter for the card's mana cost
	 * @return Returns card's mana cost
	 */
	public abstract int getCost();
	
	/**
	 * Getter for the card's strength
	 * @return Returns 0 by default; overridden in relevant subclasses
	 */
	public int getStrength() {
		return 0;
	}
	
	/**
	 * Getter for the card's strength
	 * @return Returns 0 by default; overridden in relevant subclasses
	 */
	public int getDraw() {
		return 0;
	}
}
