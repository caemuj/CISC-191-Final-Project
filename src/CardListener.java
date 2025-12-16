import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	@Override
	public void actionPerformed(ActionEvent e) {
		//check whether a card is in hand or on field
		if(linkedCard.getView().isOnField() && playerDeck.getMana() >= linkedCard.getCost()) {
			//if the card is on the field, disable all player hand and field cards and enable enemy cards for attack
			currentAttackValue = linkedCard.getStrength();
			System.out.println("Current Attack Value: " + currentAttackValue);
			playerDeck.disableAllPlayerCards();
			enemyField.enableAllEnemyCards();
			playerDeck.spendMana(linkedCard.getCost());
			manaTag.setText("Mana: " + playerDeck.getMana());
			
		}
		else if(linkedCard.getView().isOnField()) {
			JOptionPane.showMessageDialog(null, "Not Enough Mana!");
		}
		else {
			playerDeck.addToField(linkedCard);
			linkedCard.getView().playCard();
		}
	}
	
}
