import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Caeden Mujahed
 * @version 1.0
 *          Responsible for handling the end turn button functionality
 */
public class EndTurnButtonListener implements ActionListener
{
	private EnemyField enemies;
	private JLabel healthTag;
	private JLabel manaTag;
	private Player deck;
	private JPanel allyPanel;
	private GameGUI gui;

	/**
	 * Constructor for the end turn button listener
	 * 
	 * @param gui       The game GUI
	 * @param enemies   The EnemyField object for the current game
	 * @param healthTag The JLabel responsible for displaying the player's
	 *                  health
	 * @param deck      The Player object for the current game
	 * @param allyPanel The JPanel containing the player's cards in hand
	 * @param manaTag   The JLabel responsible for displaying the player's mana
	 */
	public EndTurnButtonListener(GameGUI gui, EnemyField enemies,
			JLabel healthTag, Player deck, JPanel allyPanel, JLabel manaTag)
	{
		this.enemies = enemies;
		this.healthTag = healthTag;
		this.manaTag = manaTag;
		this.deck = deck;
		this.allyPanel = allyPanel;
		this.gui = gui;
	}

	/**
	 * Handles the end turn button being pressed. Causes enemies to attack,
	 * updates player health, draws a card, resets mana, and then updates the UI
	 * to visually display the changes.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		enemies.attack();
		healthTag.setText("Health: " + deck.getHealth());
		if (deck.getHealth() <= 0)
		{
			GameGUI.lose();
		}
		Card drawnCard = deck.draw();
		if (drawnCard != null)
		{
			allyPanel.add(drawnCard.getView());
		}
		deck.resetMana();
		manaTag.setText("Mana: " + deck.getMana());
		gui.updateUI();
	}
}
