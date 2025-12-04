import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardListener implements ActionListener{
	private Card linkedCard;
	private Player playerDeck;
	private EnemyField enemyField;
	public CardListener(Card linkedCard, Player playerDeck, EnemyField enemyField) {
		this.linkedCard = linkedCard;
		this.playerDeck = playerDeck;
		this.enemyField = enemyField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//check whether a card is in hand or on field
		if(linkedCard.getView().isOnField()) {
			//if the card is on the field, disable all player hand and field cards and enable enemy cards for attack
			playerDeck.disableAllPlayerCards();
			enemyField.enableAllEnemyCards();
		}
		else {
			playerDeck.addToField(linkedCard);
			linkedCard.getView().playCard();
		}
	}
	
}
