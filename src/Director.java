
public class Director {
	Player player;
	EnemyField enemyField;
	private static int levelScore = 0;
	public Director(Player player, EnemyField enemyField) {
		this.player = player;
		this.enemyField = enemyField;
	}
	
	public static void addScore(){
		levelScore++;
	}
}
