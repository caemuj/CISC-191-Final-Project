import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class EndTurnButtonListener implements ActionListener{
	EnemyField enemies;
	JLabel healthTag;
	Player player;
	public EndTurnButtonListener(EnemyField enemies, Player player, JLabel healthTag) {
		this.enemies = enemies;
		this.healthTag = healthTag;
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		enemies.attack();
		healthTag.setText("" + player.getHealth());
		if(player.getHealth() <= 0) {
			GUITest2.lose();
		}
	}

}
