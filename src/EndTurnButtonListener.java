import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndTurnButtonListener implements ActionListener{
	private EnemyField enemies;
	private JLabel healthTag;
	private JLabel manaTag;
	private Player deck;
	private JPanel allyPanel;
	private GUITest2 gui;
	public EndTurnButtonListener(GUITest2 gui, EnemyField enemies, JLabel healthTag, Player deck, JPanel allyPanel, JLabel manaTag) {
		this.enemies = enemies;
		this.healthTag = healthTag;
		this.manaTag = manaTag;
		this.deck = deck;
		this.allyPanel = allyPanel;
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		enemies.attack();
		healthTag.setText("Health: " + deck.getHealth());
		if(deck.getHealth() <= 0) {
			GUITest2.lose();
		}
		Card drawnCard = deck.draw();
		drawnCard.getView().addActionListener(new CardListener(drawnCard, deck, enemies, manaTag));
		allyPanel.add(drawnCard.getView());
		deck.resetMana();
		manaTag.setText("Mana: " + deck.getMana());
		gui.updateUI();
	}
}
