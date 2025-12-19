import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Caeden Mujahed
 * @version 1.0
 *          Responsible for handling player interactions with enemy cards
 */
public class EnemyListener implements ActionListener
{
	Card linkedEnemy;
	EnemyField enemies;

	/**
	 * Constructor for the enemy card listener
	 * 
	 * @param linkedEnemy The enemy card this listener is listening to
	 * @param enemies     The EnemyField object managing the enemy cards
	 */
	public EnemyListener(Card linkedEnemy, EnemyField enemies)
	{
		this.linkedEnemy = linkedEnemy;
		this.enemies = enemies;
	}

	/**
	 * Handles event when the player clicks on an enemy card, checks if the
	 * player's current attack value is sufficient to defeat the enemy, and
	 * processes the attack accordingly.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (CardListener.currentAttackValue >= linkedEnemy.getStrength())
		{
			enemies.enemyAttacked(linkedEnemy);
			enemies.areDefeated();
		}
		enemies.endAttack();
	}
}
