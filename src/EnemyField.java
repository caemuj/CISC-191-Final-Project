import java.util.ArrayList;

public class EnemyField {
	private ArrayList<Card> enemies;
	private Player player;

	public EnemyField(Player player) {
		enemies = new ArrayList<Card>();
		CreatureCard myCard = new CreatureCard("2;2");
		CreatureCard mySecondCard = new CreatureCard("2;2");
		CreatureCard myThirdCard = new CreatureCard("2;2");
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
				player.takeDamage(enemy.getStrength());
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
	}
	
	public void endAttack() {
		disableAllEnemyCards();
		player.enableAllPlayerCards();
	}
	
	public void areDefeated() {
		if(enemies.size() == 0) {
			GUITest2.win();
		}
	}
}
