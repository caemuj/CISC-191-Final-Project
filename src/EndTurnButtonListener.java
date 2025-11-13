import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndTurnButtonListener implements ActionListener{
	EnemyField enemies;
	JLabel healthTag;
	Player player;
	Deck deck;
	JPanel allyPanel;
	GUITest2 gui;
	public EndTurnButtonListener(GUITest2 gui, EnemyField enemies, Player player, JLabel healthTag, Deck deck, JPanel allyPanel) {
		this.enemies = enemies;
		this.healthTag = healthTag;
		this.player = player;
		this.deck = deck;
		this.allyPanel = allyPanel;
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		enemies.attack();
		healthTag.setText("" + player.getHealth());
		if(player.getHealth() <= 0) {
			GUITest2.lose();
		}
		allyPanel.add(new JLabel(deck.draw().getImage()));
		gui.updateUI();
	}
}
