import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Caeden Mujahed
 * @version 1.0
 * Contains data and methods pertaining to the visual representation of a card
 */
public class CardView extends JButton {
	private Card viewedCard;
	private ImageIcon image;
	private boolean onField;
	public CardView(Card viewedCard) {
		this.viewedCard = viewedCard;
		image = new ImageIcon(String.format("%s.png", viewedCard.getID()));
		image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		this.setIcon(image);
		onField = false;
		this.setText("false");
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public boolean isOnField() {
		return onField;
	}
	
	public void playCard() {
		onField = true;
		this.setText("true");
	}
	
	public void offField() {
		onField = false;
		this.setText("false");
	}
}
