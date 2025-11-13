import javax.swing.ImageIcon;

public class Card {
	String cardID;
	ImageIcon image;
	public Card(String cardID) {
		this.cardID = cardID;
		image = new ImageIcon(String.format("%s.png", cardID));
	}
	public String getID() {
		return cardID;
	}
	public ImageIcon getImage() {
		return image;
	}
}
