import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card{
	private String cardID;
	private CardView view;
	public Card(String cardID) {
		super();
		this.cardID = cardID;
		view = new CardView(this);
	}
	public String getID() {
		return cardID;
	}
	
	public CardView getView() {
		return view;
	}
	
	public int getCost() {
		return -1;
	}
	
	public int getStrength() {
		return -1;
	}
}
