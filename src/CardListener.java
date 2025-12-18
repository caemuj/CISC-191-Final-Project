import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Caeden Mujahed
 * @version 1.0
 * Responsible for handling player interactions with their own cards
 */
public class CardListener implements ActionListener{
	public static int currentAttackValue = 0;
	private Card linkedCard;
	private Player playerDeck;
	private EnemyField enemyField;
	private JLabel manaTag;
	public CardListener(Card linkedCard, Player playerDeck, EnemyField enemyField, JLabel manaTag) {
		this.linkedCard = linkedCard;
		this.playerDeck = playerDeck;
		this.enemyField = enemyField;
		this.manaTag = manaTag;
	}
	/**
	 * Handles event when the player clicks on their own card, allows them to either play the card from their hand to the field or spend mana to attack with it if it is already on the field.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(linkedCard instanceof SpellCard) {
			playerDeck.removeCard(linkedCard);
			playerDeck.spendMana(linkedCard.getCost());
			manaTag.setText("Mana: " + playerDeck.getMana());
			playerDeck.draw(linkedCard.getDraw());
		}
		else if(linkedCard.getView().isOnField() && playerDeck.getMana() >= linkedCard.getCost()) {
			currentAttackValue = linkedCard.getStrength();
			playerDeck.disableAllPlayerCards();
			enemyField.enableAllEnemyCards();
			playerDeck.spendMana(linkedCard.getCost());
			manaTag.setText("Mana: " + playerDeck.getMana());
			
		}
		else if(linkedCard.getView().isOnField()) {
			JOptionPane.showMessageDialog(null, "Not Enough Mana!");
		}
		else if(playerDeck.fieldHasSpace()){
			playerDeck.addToField(linkedCard);
			linkedCard.getView().playCard();
		}
	}
	
}
