import java.util.ArrayList;

public class EnemyField {
	private ArrayList<Card> enemies;
	private Player player;

	public EnemyField(Player player) {
		enemies = new ArrayList<Card>();
		Card myCard = new Card("10;15");
		Card mySecondCard = new Card("10;15");
		Card myThirdCard = new Card("10;15");
		enemies.add(myCard);
		enemies.add(mySecondCard);
		enemies.add(myThirdCard);
		for (Card enemy : enemies) {
			enemy.getView().setEnabled(false);
			enemy.getView().setDisabledIcon(enemy.getView().getImage());
		}
		this.player = player;
	}

	public ArrayList<Card> getEnemies() {
		return enemies;
	}

	public void attack() {
		for (Card enemy : enemies) {
			if (player.fieldIsEmpty()) {
				player.takeDamage();
			} 
			else {
				player.fieldAttacked();
			}
		}
	}
	
	public void enableAllEnemyCards() {
		for(Card enemy : enemies) {
			enemy.getView().setEnabled(true);
		}
	}
	
	public void disableAllEnemyCards() {
		for(Card enemy : enemies) {
			enemy.getView().setEnabled(false);
		}
	}
	
	public void enemyAttacked(Card attackedEnemy) {
		enemies.remove(attackedEnemy);
		player.updateUI();
		disableAllEnemyCards();
		player.enableAllPlayerCards();
	}
	
	public void areDefeated() {
		if(enemies.size() == 0) {
			GUITest2.win();
		}
	}
}
