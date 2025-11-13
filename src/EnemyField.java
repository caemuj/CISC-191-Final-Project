
public class EnemyField {
	Card[] enemies;
	Player player;
	public EnemyField(Player player){
		enemies = new Card[3];
		Card myCard = new Card("10;15");
		Card mySecondCard = new Card("10;15");
		Card myThirdCard = new Card("10;15");
		enemies[0] = myCard;
		enemies[1] = mySecondCard;
		enemies[2] = myThirdCard;
		this.player = player;
	}
	public Card[] getEnemies() {
		return enemies;
	}
	public void attack() {
		for(Card enemy : enemies) {
			player.takeDamage();
		}
	}
}
