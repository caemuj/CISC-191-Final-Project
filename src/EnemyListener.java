import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyListener implements ActionListener{
	Card linkedEnemy;
	EnemyField enemies;
	public EnemyListener(Card linkedEnemy, EnemyField enemies) {
		this.linkedEnemy = linkedEnemy;
		this.enemies = enemies;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(CardListener.currentAttackValue >= linkedEnemy.getStrength()) {
			enemies.enemyAttacked(linkedEnemy);
			enemies.areDefeated();
		}
		enemies.endAttack();
	}
}
