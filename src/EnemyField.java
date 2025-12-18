import java.util.ArrayList;

/**
 * @author Caeden Mujahed
 * @version 1.0
 * Responsible for managing the enemy board state
 */
public class EnemyField {
	private ArrayList<Card> enemies;
	private Player player;

	/**
	 * A constructor for the EnemyField class
	 * @param player The Player object the enemies will be attacking
	 */
	public EnemyField(Player player) {
		enemies = new ArrayList<Card>();
		CreatureCard myCard = new CreatureCard("1;1");
		CreatureCard mySecondCard = new CreatureCard("1;1");
		enemies.add(myCard);
		enemies.add(mySecondCard);
		for (Card enemy : enemies) {
			enemy.getView().setEnabled(false);
			enemy.getView().setDisabledIcon(enemy.getView().getImage());
		}
		this.player = player;
	}
	
	/**
	 * A method to reset the enemy field and populate it with new enemies after the player has beaten all currently on field enemies.
	 * The strength and kinds of enemies generated are based on the player's score.
	 */
	public void reset() {
		Director.addScore();
		if(Director.getScore() < 3) {
			for(int i = 1; i < 3; i++) {
				enemies.add(new CreatureCard(String.format("%d;%d", i, i)));
			}
		}
		else if(Director.getScore() >= 3 && Director.getScore() < 6) {
			for(int i = 1; i <= Director.getScore(); i++) {
				enemies.add(new CreatureCard("2;2"));
			}
		}
		else {
			for(int i = 1; i < 3; i++) {
				enemies.add(new CreatureCard("2;2"));
			}
		}
		for(Card enemy : enemies) {
			enemy.getView().addActionListener(new EnemyListener(enemy, this));
			enemy.getView().setEnabled(false);
			enemy.getView().setDisabledIcon(enemy.getView().getImage());
		}
	}

	/**
	 * Getter for the enemies on the field
	 * @return The ArrayList of enemy cards on the field
	 */
	public ArrayList<Card> getEnemies() {
		return enemies;
	}

	/**
	 * Method to handle the enemy attack phase, happens every time the player ends their turn.
	 */
	public void attack() {
		for (Card enemy : enemies) {
			if (player.fieldIsEmpty()) {
				player.takeDamage(enemy.getStrength());
			} 
			else {
				player.fieldAttacked(enemy);
			}
		}
	}
	
	/**
	 * Enables enemy cards for interaction allowing the player to target them for an attack
	 */
	public void enableAllEnemyCards() {
		for(Card enemy : enemies) {
			enemy.getView().setEnabled(true);
		}
	}
	
	/**
	 * Disables enemy cards to prevent interaction after the player has made their attack
	 */
	public void disableAllEnemyCards() {
		for(Card enemy : enemies) {
			enemy.getView().setEnabled(false);
		}
	}
	
	/**
	 * Method to destroy enemies that have been successfully attacked by the player and update the UI
	 * @param attackedEnemy The enemy card that was targeted
	 */
	public void enemyAttacked(Card attackedEnemy) {
		enemies.remove(attackedEnemy);
		player.updateUI();
	}
	
	/**
	 * Ends the player's attack
	 */
	public void endAttack() {
		disableAllEnemyCards();
		player.enableAllPlayerCards();
	}
	
	/**
	 * Checks whether or not all enemies have been defeated. Resets the enemy field and updates the UI if so.
	 */
	public void areDefeated() {
		if(enemies.size() == 0) {
			reset();
			player.updateUI();
		}
	}
}
